(ns coop.magnet.duct-module.cljs-externs
  (:require [duct.core :as core]
            [integrant.core :as ig]))

(defn- get-environment [config options]
  (:environment options (:duct.core/environment config :production)))

(defn- merge-externs
  [config externs]
  (let [builds-path [:duct.compiler/cljs :builds]
        builds (get-in config builds-path)]
    (if-not builds
      config
      (assoc-in config builds-path (mapv #(assoc-in % [:build-options :externs] externs) builds)))))

(defmethod ig/init-key :coop.magnet.duct-module/cljs-externs [_ {:keys [cljs-module externs] :as options}]
  {:req #{:duct.module/cljs}
   :fn (fn [config]
         (case (get-environment config options)
           :production (merge-externs ((:fn cljs-module) config) externs)
           :development config))})
