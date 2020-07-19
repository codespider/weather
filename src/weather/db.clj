(ns weather.db
  (:require [clojure.java.jdbc :as jdbc]
            [weather.config :refer [config]]))

(defn save-current-condition
  [current-condition]
  (jdbc/insert! (:db-config config)
                "WEATHER"
                {"DAY"                   "2020-07-19"
                 "HOUR"                  5
                 "ACCU_RAIN_PROBABALITY" 10
                 "ACCU_ACTUAL_RAIN"      10
                 "ACCU_RAW_FORECAST"     "might rain 1"
                 "ACCU_RAW_ACTUAL"       "slight rain 1"})
  (print current-condition))

(defn save-forecast [forecast]
  (print forecast))

