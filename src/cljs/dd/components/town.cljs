(ns dd.components.town
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
     [re-com/v-box
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
    [location-details l]))

(def location-title
  [re-com/title
   :label "Location"
   :level :level3])

(defn location-one [loc]
  (let [locations (re-frame/subscribe [:locations])]
    (fn []
    [re-com/title
     :label (str loc)
     :level :level3])))

(defn location-els [locations]
  (for [l locations]
    ^{:key l}
    [re-com/title
     :label (str l)
     :level :level3]))

(defn locations-component [town]
  [re-com/v-box
   :gap  "1em"
   :children [[re-com/title
               :label "Location"
               :level :level2]
              ]])

(defn town-component [town]
  (.log js/console [location-title])
  (.log js/console [location-details (first (:locations town))])
  (.log js/console [(all-locations (:locations town))])

  [re-com/v-box
        :gap  "1em"
        :children [location-title
                   (all-locations (:locations town))
                  ]])
