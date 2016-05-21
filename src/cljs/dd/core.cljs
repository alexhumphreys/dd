(ns dd.core
    (:require [reagent.core :as reagent]
              [re-frame.core :as re-frame]
              [weasel.repl :as weasel]
              [dd.handlers]
              [dd.subs]
              [dd.routes :as routes]
              [dd.views :as views]
              [dd.config :as config]))

(when config/debug?
  (println "dev mode"))

(defn mount-root []
  (reagent/render [views/main-panel]
                  (.getElementById js/document "app")))

(defn ^:export init [] 
  (routes/app-routes)
  (re-frame/dispatch-sync [:initialize-db])
  (mount-root))

(weasel/connect  "ws://localhost:9001" :verbose true)

(js/console.log "sup")
