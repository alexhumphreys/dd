(ns dd.components.town
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [reagent.core :as reagent]
              [devtools.core :as devtools]
              [dd.components.location :as location]
              [dd.components.transport :as transport]
              [dd.util :as util]
              ))

(devtools/install!)

(defn town-component [town]
  ^{:key (get town :id)}
  [re-com/v-box
        :gap  "1em"
        :children [
                   (location/location-component town)
                   transport/transport-title
                  ]])
