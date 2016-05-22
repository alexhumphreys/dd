(ns dd.components.towns
    (:require [re-frame.core :as re-frame]
              [re-com.core :as re-com]
              [reagent.core :as reagent]
              [dd.util :as util]
              [dd.components.town :as town]
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

(defn town-tab [town]
  (merge {:label (:name town)}
          (select-keys town [:id])))

(defn towns-component []
  (let [towns (re-frame/subscribe [:towns])
        selected-tab-id (reagent/atom (:id (first @towns)))
        change-tab #(reset! selected-tab-id %)]
    (fn []
      [re-com/v-box
        :gap  "1em"
        :children [[re-com/h-box
                    :align    :center
                    :children [[re-com/horizontal-tabs
                                :model     selected-tab-id
                                :tabs      (map town-tab @towns)
                                :on-change change-tab]]]
                   ^{:key @selected-tab-id}
                   [re-com/v-box
                     :gap  "1em"
                     :children [(town/town-component 
                                  (util/find-in :id @selected-tab-id @towns))]]]])))
