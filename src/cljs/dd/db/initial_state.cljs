(ns dd.db.initial-state)

(def locations
  [{:name :downtown
    :demand {:g 4
             :w 10}
    :goons 0}
   {:name :school
    :demand {:g 4
             :w 0}
    :goons 0}
   {:name :club
    :demand {:g 5
             :w 5}
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
    :locations [:park :club]
    :transport {:rail true
                :airport true}}])

(def default-db
  {:name "stuff2"
   :towns towns
   :locations locations
   :selected-town 1
   :money 11})
