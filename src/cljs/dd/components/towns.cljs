(ns dd.components.towns
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [devtools.core :as devtools]
              ))

(devtools/install!)

(defn town-li [town]
  [re-com/h-box
        :gap  "1em"
        :children [[re-com/title
                  :label (get town :name)
                  :level :level1]]])

(defn towns-component []
  (let [towns (re-frame/subscribe [:towns])]
    (def town-els (for [t @towns]
                [re-com/title
                  :label (get t :name)
                  :level :level1]))
    (fn []
      [re-com/v-box
        :gap  "1em"
        :children [town-els]])))
