(ns dd.handler
  (:require [compojure.core :refer [GET defroutes]]
            [compojure.route :as route]
            weasel.repl.websocket
            weasel.repl.server
            [cljs.build.api :refer  [build]]
            [ring.middleware.defaults :refer  [wrap-defaults site-defaults]]
            [ring.adapter.jetty :refer  [run-jetty]]
            [ring.middleware.reload :refer  [wrap-reload]]
            [ring.util.response :refer [file-response]]))

(defroutes handler
  (GET "/" [] (file-response "index.html" {:root "resources/public"})))

(defn repl-env  []
  (weasel.repl.server/stop)
  (weasel.repl.websocket/repl-env :ip  "0.0.0.0" :port 9001))
