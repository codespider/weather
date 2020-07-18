(ns weather.core
  (:require [clojure.tools.cli :as cli]
            [weather.db :as db]
            [weather.accuweather :as aw]
            [weather.config :refer [config]]))

(def cli-options
  [["-h" "--help"]])

(defn current-conditions-handler
  []
  (let [location-key      (aw/get-location-key (:jeevan-bhima-nagar config))
        current-condition (aw/get-current-conditions location-key)]
    (db/save-current-condition current-condition)))

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
