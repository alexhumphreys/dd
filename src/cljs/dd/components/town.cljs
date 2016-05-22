(ns dd.components.town
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [reagent.core :as reagent]
              [devtools.core :as devtools]
              [dd.util :as util]
              ))

(devtools/install!)

(def location-title
  [re-com/title
   :label "Location"
   :level :level3])

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
  [re-com/v-box
        :gap  "1em"
        :children [location-title
                   (location-els (:locations town))
                  ]])
