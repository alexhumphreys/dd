(ns dd.db
  (:require [schema.core :as s :include-macros true]))

(def default-db
  {:name "reframe"})

(def schema
  {:name s/Str})

(def stock-schema
  {:g s/Int
   :w s/Int })

(def price-schema
  {:g s/Int
   :w s/Int })

(def location-schema
  {:name s/Str
   :demand stock-schema
   :goons s/Int})

(def transport-schema
  {:road true
   :rail s/Bool
   :airport s/Bool})

(def facility-schema
  {:ware s/Keyword
   :capacity s/Int})

(def town-schema
  {:prices price-schema
   :stock stock-schema
   :facilities [facility-schema]
   :locations [location-schema]
   :transport transport-schema})
