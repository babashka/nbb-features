(ns datascript-transit.test-runner
  (:require [cljs.test :as t]
            [nbb.core :as nbb]
            [datascript.test.transit]))

(defmethod t/report [::t/default :end-run-tests] [{:keys [error fail]}]
  (if (pos? (+ error fail))
    (js/process.exit 1)
    (js/process.exit 0)))

(defn init []
  (t/run-tests 'datascript.test.transit))

(when (= nbb/*file* (:file (meta #'init)))
  (init))
