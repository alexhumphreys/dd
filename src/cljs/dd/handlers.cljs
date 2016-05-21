(ns dd.handlers
    (:require [re-frame.core :as re-frame]
              [schema.core :as s]
              [dd.db :as db]))


(defn check-and-throw
  "throw an exception if db doesn't match the schema."
  [a-schema db]
  (if-let [problems (s/check a-schema db)]
    (throw (js/Error. (str "schema check failed: " problems)))))

;; after an event handler has run, this middleware can check that
;; it the value in app-db still correctly matches the schema.
(def check-schema-mw (re-frame/after (partial check-and-throw db/schema)))

(re-frame/register-handler
 :initialize-db
 check-schema-mw
 (fn  [_ _]
   db/default-db))

(re-frame/register-handler
 :set-active-panel
 (fn [db [_ active-panel]]
   (assoc db :active-panel active-panel)))
