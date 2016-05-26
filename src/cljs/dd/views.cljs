(ns dd.views
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [dd.components.dashboard :as dashboard-comp]))


;; home

(defn home-title []
  [re-com/title
   :label "DD"
   :level :level1])

(defn money []
  (let [money (re-frame/subscribe [:money])]
    (fn []
      [re-com/title
       :label @money
       :level :level1])))

(defn home-panel []
  [re-com/v-box
   :gap "1em"
   :children [[re-com/h-box
               :gap "1em"
               :children [[home-title]
                          [money]]]
              [dashboard-comp/dashboard-component]]])

;; main

(defmulti panels identity)
(defmethod panels :home-panel [] [home-panel])
(defmethod panels :default [] [:div])

(defn show-panel
  [panel-name]
  [panels panel-name])

(defn main-panel []
  (let [active-panel (re-frame/subscribe [:active-panel])]
    (fn []
      [re-com/v-box
       :height "100%"
       :children [[panels @active-panel]]])))
