(ns dd.db.initial-state)

(def default-db
  {:name "stuff" 
   :towns towns
   :money 11})

(def locations
  [{:name :downtown
    :demand {:g 4
             :w 10}
    :goons 0}
   {:name :school
    :demand {:g 4
             :w 0}
    :goons 0}
   {:name :park
    :demand {:g 10
             :w 2}
    :goons 0}])

(def towns
  [{:id 1
    :name "Mitte"
    :locations [:downtown :school]
    :transport {:rail true
                :airport true}}
   {:id 2
    :name "kberg"
    :locations [:downtown :school]
    :transport {:rail true
                :airport true}}])