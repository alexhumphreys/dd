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
   :level :level3])
