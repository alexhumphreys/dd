(ns dd.components.towns
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [devtools.core :as devtools]
              ))

(devtools/install!)

(defn town-li [town]
  ^{:key (get town :id)}
  [re-com/h-box
        :gap  "1em"
        :children [
                  [re-com/title
                   :label (get town :name)
                   :level :level2]]])

(defn towns-component []
  (let [towns (re-frame/subscribe [:towns])]
    (def town-ul (for [t @towns]
                (town-li t)))
    (fn []
      [re-com/v-box
        :gap  "1em"
        :children [town-ul]])))
