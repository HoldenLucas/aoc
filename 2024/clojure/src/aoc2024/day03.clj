(ns aoc2024.day03
  (:require [hashp.core]))

(defn parse-input
  [input]
  (->>  input
        (re-seq #"(mul)\((\d{1,3}),(\d{1,3})\)")
        (map rest)
        (map (fn [[op n1 n2]] [op (parse-long n1) (parse-long n2)]))))

(defn calculate [op x y]
  (case op
    "mul" (* x y)
    (str "Unknown operation: " op)))

(defn part1
  [input]
  (->> input
       parse-input
       (map #(apply calculate %))
       (reduce +)))

(defn part2
  [input]
  (->> input
       parse-input))
