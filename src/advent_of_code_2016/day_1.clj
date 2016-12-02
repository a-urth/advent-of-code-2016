(ns advent-of-code-2016.day-1
  (:require [clojure.string :as str]))

(defn new-direction
  "0 - N; 1 - E; 2 - S; 3 - W"
  [turn cur-direct]
  (if (= turn \R)
    (rem (inc cur-direct) 4)
    (if (zero? cur-direct) 3 (dec cur-direct))))

(defn get-coords-delta [direction n]
  (case direction
    0 [0 n]
    1 [n 0]
    2 [0 (/ n -1)]
    3 [(/ n -1) 0]))

(defn walk
  ([turns]
   (walk turns 0))
  
  ([turns cur-direct]
   (when (not-empty turns)
     (let [turn (first turns)
           direct (first turn)
           n (Integer. (subs turn 1))
           new-direct (new-direction direct cur-direct)
           coords (get-coords-delta new-direct n)]
       (lazy-seq (cons coords (walk (rest turns) new-direct)))))))

(defn main [s]
  (apply
    +
    (map #(Math/abs %) (reduce #(map + %1 %2) (walk (str/split s #", "))))))
