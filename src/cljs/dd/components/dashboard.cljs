(ns dd.components.dashboard
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [dd.components.locations :as locations-comp]
              [dd.components.towns :as towns]
              ))


(defn dashboard-component []
  [re-com/v-box
   :gap "1em"
   :children [
              [towns/towns-component]
              [locations-comp/locations-component]
              ]])
