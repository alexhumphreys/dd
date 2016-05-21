(defproject dd "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]
                 [reagent "0.5.1"]
                 [re-frame "0.7.0"]
                 [re-com "0.8.3"]
                 [secretary "1.2.3"]
                 [compojure "1.5.0"]
                 [ring "1.4.0"]
                 [ring/ring-defaults  "0.1.2"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "src/cljs"]

  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-ring  "0.9.7"]
            [lein-less "1.7.5"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"
                                    "test/js"]

  :figwheel {:css-dirs     ["resources/public/css"] 
             :ring-handler dd.handler/handler }
  :ring  {:handler dd.handler/handler }

  :less {:source-paths ["less"]
         :target-path  "resources/public/css"}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "dd.core/mount-root"}
     :compiler     {:main                 dd.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true}}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            dd.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}
    {:id           "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler     {:output-to     "resources/public/js/compiled/test.js"
                    :main          dd.runner
                    :optimizations :none}}
    ]}

  ;; this guy?
  :repl-options {:init-ns dd.handler :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}

  :profiles
  {:dev
   {:plugins [[lein-figwheel "0.5.3"]
              [lein-doo "0.1.6"]
              [cider/cider-nrepl "0.13.0-SNAPSHOT"]
              ]
    :dependencies [[figwheel-sidecar "0.5.3"]
                   [weasel  "0.7.0"]
                   [org.clojure/tools.nrepl  "0.2.10"]
                   [com.cemerick/piggieback "0.2.1"]]
    :repl-options  {:init-ns dd.handler
                    :nrepl-middleware  [cemerick.piggieback/wrap-cljs-repl]}
    }})
