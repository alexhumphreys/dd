(ns dd.components.dashboard
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [dd.components.locations :as locations-comp]
              ))


(defn dashboard-component []
  [re-com/v-box
   :gap "1em"
   :children [
              [locations-comp/locations-component]
              ]])
