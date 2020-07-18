(ns weather.accuweather
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]
            [weather.config :refer [config]]))

(defn get-location-key
  ([lat long]
   (let [response     (client/get (:location-key-url config)
                                  {:query-params {"apikey" (:api-key config)
                                                  "q"      (str lat "," long)}})
         location-key (-> (:body response)
                          (json/read-str)
                          (get "Key"))]
     location-key))
  ([[lat long]]
   (get-location-key lat long)))

(defn get-12-hr-forecast
  [location-key]
  (client/get (str (:12-hr-forecast-url config) location-key)
              {:query-params {"apikey"  (:api-key config)
                              "details" "true"}}))

(defn get-current-conditions
  [location-key]
  (client/get (str (:current-weather-url config) location-key)
              {:query-params {"apikey"  (:api-key config)
                              "details" "true"}}))

