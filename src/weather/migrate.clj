(ns weather.migrate
  (:require [ragtime.jdbc :as jdbc]
            [ragtime.repl :as repl]
            [weather.config :refer [config]]))

(defn migration-config []
  {:datastore  (jdbc/sql-database (-> config :db-config :db-url))
   :migrations (jdbc/load-resources (-> config :db-config :migrations))})

(defn migrate []
  (repl/migrate (migration-config)))

(defn rollback []
  (repl/rollback (migration-config)))