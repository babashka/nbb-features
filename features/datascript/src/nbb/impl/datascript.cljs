(ns nbb.impl.datascript
  {:no-doc true}
  (:require [sci.configs.tonsky.datascript :refer [config]]
            [nbb.core :as nbb]))

(defn init []
  (nbb/register-plugin!
   ::datascript
   config))
