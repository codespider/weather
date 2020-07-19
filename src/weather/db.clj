(ns weather.db
  (:require [clojure.java.jdbc :as jdbc]
            [weather.config :refer [config]]
            [clojure.data.json :as json]))

(defn save-current-condition
  [date hour is-raining? current-condition]
  (jdbc/insert! (:db-config config)
                "WEATHER"
                {"DAY"              date
                 "HOUR"             hour
                 "ACCU_ACTUAL_RAIN" (if is-raining? 1
                                        0)
                 "ACCU_RAW_ACTUAL"  (json/write-str current-condition)})
  (print current-condition))

(defn save-forecast [forecast]
  (print forecast))

