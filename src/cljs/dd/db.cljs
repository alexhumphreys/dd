(ns dd.db
  (:require [schema.core :as s :include-macros true]
            [dd.db.initial-state :as init]))

(def default-db
  init/default-db)

(def stock-schema
  {:g s/Int
   :w s/Int })

(def price-schema
  {:g s/Int
   :w s/Int })

(def location-schema
  {:name s/Keyword
   :demand stock-schema
   :goons s/Int})

(def transport-schema
  {:rail s/Bool
   :airport s/Bool})

(def facility-schema
  {:ware s/Keyword
   :capacity s/Int})

(def town-schema
  {:id s/Int
   :name s/Str
   :locations [s/Keyword]
   :transport transport-schema})

(def game-town-schema
  {:prices price-schema
   :stock stock-schema
   :facilities [facility-schema]
   :attrs town-schema})

(def game-state-schema
  {:money s/Int
   :locations [location-schema]
   :towns [town-schema]})

(def schema
  (merge {:name s/Str
          :selected-town s/Int}
         game-state-schema))
