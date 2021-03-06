(defproject weather "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [clj-http "3.10.1"]
                 [org.clojure/tools.reader "1.3.2"]
                 [cheshire "5.10.0"]
                 [org.clojure/data.json "1.0.0"]
                 [camel-snake-kebab "0.4.1"]
                 [org.clojure/tools.cli "1.0.194"]
                 [ragtime "0.8.0"]
                 [org.clojure/java.jdbc "0.7.10"]
                 [com.h2database/h2 "1.4.200"]
                 [clojure.java-time "0.3.2"]]
  :plugins [[jonase/eastwood "0.3.10"]
            [lein-cljfmt "0.6.8"]]
  :aliases {"migrate"  ["run" "-m" "weather.migrate/migrate"]
            "rollback" ["run" "-m" "weather.migrate/rollback"]}
  :main ^:skip-aot weather.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
