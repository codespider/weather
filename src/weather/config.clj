(ns weather.config)
(def config
  {:api-key             ""
   :jeevan-bhima-nagar  ["12.9642" "77.6581"]
   :location-key-url    "http://dataservice.accuweather.com/locations/v1/cities/geoposition/search"
   :12-hr-forecast-url  "http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/"
   :current-weather-url "http://dataservice.accuweather.com/currentconditions/v1/"
   :db-config           {:db-url     "jdbc:h2:file:~/example.h2"
                         :dbname     "~/example.h2"
                         :dbtype     "h2"
                         :migrations "migrations"}})
