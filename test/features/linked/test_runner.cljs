(ns linked-test-runner
  (:require [cljs.test :as t]
            [nbb.core :as nbb]
            [linked.map-test]))

(defmethod t/report [::t/default :end-run-tests] [m]
  (let [{:keys [error fail]} m]
    (if (pos? (+ error fail))
      (js/process.exit 1)
      (js/process.exit 0))))

(defn init []
  (t/run-tests 'linked.map-test))

(when (= nbb/*file* (:file (meta #'init)))
  (init))
