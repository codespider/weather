(ns weather.core
  (:require [clojure.tools.cli :as cli]
            [weather.db :as db]
            [weather.accuweather :as aw]
            [weather.config :refer [config]]
            [java-time :as java-time]))

(def cli-options
  [["-h" "--help"]])

(defn current-hour []
  (-> (java-time/local-date-time)
      (java-time/as-map)
      :hour-of-day))

(defn current-conditions-handler
  []
  (let [location-key      (aw/get-location-key (:jeevan-bhima-nagar config))
        current-condition (aw/get-current-conditions location-key)
        is-raining?       (and (get current-condition "HasPrecipitation")
                               (= "Rain" (get current-condition "PrecipitationType")))]
    (db/save-current-condition (java-time/local-date) (current-hour) is-raining? current-condition)))

(defn forecast-conditions-handler []
  (let [location-key      (aw/get-location-key (:jeevan-bhima-nagar config))
        current-condition (aw/get-12-hr-forecast location-key)]
    (db/save-forecast current-condition)))

(defn -main
  [& args]
  (let [{:keys [arguments errors summary]} (cli/parse-opts args cli-options)
        action (first arguments)]
    (if errors
      (print summary)
      (case action
        "current" (current-conditions-handler)
        "forecast" (forecast-conditions-handler)
        (print "Use `current` or `forecast`")))))
