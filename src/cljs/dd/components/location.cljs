(ns dd.components.location
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [reagent.core :as reagent]
              [devtools.core :as devtools]
              [dd.util :as util]
              ))

(devtools/install!)

(defn location-details [loc]
  (let [locations (re-frame/subscribe [:locations])]
    (fn []
     (def this-location (util/find-in :name loc @locations))
     [re-com/h-box
            :gap  "1em"
            :children [
                       [re-com/title
                        :label (str (:name this-location))
                        :level :level3]
                       [re-com/title
                        :label (str (:demand this-location))
                        :level :level3]
                      ]])))

(defn all-locations [locs]
  (for [l locs]
    ^{:key l}
    [location-details l]))

(def location-title
  [re-com/title
   :label "Locations"
   :level :level3])

(defn location-component [town]
  ^{:key (get town :id)}
  [re-com/v-box
        :gap  "1em"
        :children [location-title
                   (all-locations (:locations town))
                  ]])
