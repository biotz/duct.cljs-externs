(defproject coop.magnet.duct-module/cljs-externs "0.1.0"
  :description "Duct module for managing externs definitions when developing and compiling ClojureScript"
  :url "https://github.com/magnetcoop/duct-module-cljs-externs"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [duct/core "0.6.2"]
                 [duct/compiler.cljs "0.2.0"]
                 [duct/module.cljs "0.3.2" :exclusions [org.clojure/tools.nrepl]]
                 [duct/server.figwheel "0.2.1" :exclusions [org.clojure/tools.nrepl]]
                 [integrant "0.6.2"]])
