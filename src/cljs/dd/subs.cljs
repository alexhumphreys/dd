(ns dd.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/register-sub
 :name
 (fn [db]
   (reaction (:name @db))))

(re-frame/register-sub
 :money
 (fn [db]
   (reaction (:money @db))))

(re-frame/register-sub
 :locations
 (fn [db]
   (reaction (:locations @db))))

(re-frame/register-sub
 :selected-town
 (fn [db]
   (reaction (:selected-town @db))))

(re-frame/register-sub
 :towns
 (fn [db]
   (reaction (:towns @db))))

(re-frame/register-sub
 :active-panel
 (fn [db _]
   (reaction (:active-panel @db))))
