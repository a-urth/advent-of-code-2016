(ns advent-of-code-2016.day-3
  (:require [clojure.string :as str]))

(defn valid? [coll]
  (let [[s1 s2 s3] (sort coll)]
    (> (+ s1 s2) s3)))

(defn row->ints [s]
  (map #(Integer. %) (str/split (str/trim s) #"\s+")))

(defn main-1 [s]
  (count
    (filter valid? (map  row->ints (str/split-lines s)))))

(defn main-2 [s]
  (count
    (filter
      valid?
      (mapcat
        #(apply (partial map vector) (map row->ints %))
        (partition 3 (str/split-lines s))))))
