(ns weather.db
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]
            [weather.config :refer [config]]))

(defn save-current-condition
  [current-condition]
  (print current-condition))

(defn save-forecast [forecast]
  (print forecast))

(defn migration-config []
  {:datastore  (jdbc/sql-database (:db-url config))
   :migrations (jdbc/load-resources (:migrations config))})

(defn migrate []
  (repl/migrate (migration-config)))

(defn rollback []
  (repl/rollback (migration-config)))
