(ns dd.components.transport
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [reagent.core :as reagent]
              [devtools.core :as devtools]
              [dd.util :as util]
              ))

(devtools/install!)

(def transport-title
  [re-com/title
   :label "Transport"
   :level :level2])

(defn all-transport [transport]
  (for [k transport]
    ^{:key k}
   [re-com/title
   :label (str k)
   :level :level3]))

(defn transport-component [town]
  [re-com/v-box
   :gap "em1"
   :children [transport-title
              (all-transport (:transport town))
              ]])
