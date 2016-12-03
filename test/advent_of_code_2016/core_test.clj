(ns advent-of-code-2016.core-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2016.inputs :as inputs]
            [advent-of-code-2016.day-1 :as day-1]
            [advent-of-code-2016.day-2 :as day-2]
            [advent-of-code-2016.day-3 :as day-3]))


(deftest day-1-test
  (testing "Testing day-1"
    (is (= (day-1/main-1 "R2, L3") 5))
    (is (= (day-1/main-1 "R2, R2, R2") 2))
    (is (= (day-1/main-1 "R5, L5, R5, R3") 12))
    (is (= (day-1/main-1 inputs/day-1) 300))))

(deftest day-2-test
  (testing "Testing day-2"
    (is (= (day-2/main-1 "ULL\nRRDDD\nLURDL\nUUUUD") "1985"))
    (is (= (day-2/main-1 inputs/day-2) "78293"))
    (is (= (day-2/main-2 "ULL\nRRDDD\nLURDL\nUUUUD") "5DB3"))
    (is (= (day-2/main-2 inputs/day-2) "AC8C8"))))

(deftest day-3-test
  (testing "Testing day-3"
    (is (= (day-3/main-1 "5 10 25") 0))
    (is (= (day-3/main-1 inputs/day-3) 982))
    (is (= (day-3/main-2 inputs/day-3) 1826))))
