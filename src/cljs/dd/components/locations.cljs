(ns dd.components.locations
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]))


(defn locations-component []
  (fn []
    [re-com/title
     :label "Locations"
     :level :level2]))
