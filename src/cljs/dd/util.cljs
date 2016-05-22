(ns dd.util)

(defn find-in  [k v m]
  (first (filter #(= v (k %)) m)))
