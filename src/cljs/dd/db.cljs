(ns dd.db
  (:require [schema.core :as s :include-macros true]))

(def default-db
  {:name "reframe"})

(def schema
  {:name s/Str})
