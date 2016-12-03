(ns advent-of-code-2016.day-2
  (:require [clojure.string :as str]))

(defn move-1 [cur-num direction]
  (case direction
    \U (if (> cur-num 3) (- cur-num 3) cur-num)
    \D (if (< cur-num 7) (+ cur-num 3) cur-num)
    \L (if (= (rem cur-num 3) 1) cur-num (dec cur-num))
    \R (if (zero? (rem cur-num 3)) cur-num (inc cur-num))))

(def keypad [[nil nil 1 nil nil]
             [nil  2  3  4  nil]
             [ 5   6  7  8   9 ]
             [nil \A \B \C  nil]
             [nil nil \D nil nil]])

(defn new-coords [y x direction]
  (case direction
    \U [(dec y) x]
    \D [(inc y) x]
    \L [y (dec x)]
    \R [y (inc x)]))

(defn move-2 [[y x] direction]
  (let [[n-y n-x] (new-coords y x direction)]
    (if-let [n (get-in keypad [n-y n-x])] [n-y n-x] [y x])))

(defn get-code [move directions start-pos]
  (when (not-empty directions)
   (let [cur-pos (reduce move start-pos (first directions))]
     (lazy-seq (cons cur-pos (get-code move (rest directions) cur-pos))))))

(defn main-1 [s]
  (apply str (get-code move-1 (str/split-lines s) 5)))

(defn main-2 [s]
  (apply
    str
    (map #(get-in keypad %) (get-code move-2 (str/split-lines s) [2 0]))))
