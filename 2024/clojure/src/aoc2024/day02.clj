(ns aoc2024.day02
  (:require [clojure.string :as str]
            [hashp.core]))

(defn parse-input
  [input]
  (->> input
       str/split-lines
       (map #(str/split % #" "))
       (map #(map parse-long %))))

(defn sliding-assert?
  [pred coll]
  (every? pred (partition 2 1 coll)))

(defn monotonic?
  [coll]
  (or
   (sliding-assert? #(apply < %) coll)
   (sliding-assert? #(apply > %) coll)))

(defn bounded-growth?
  [coll]
  (sliding-assert? #(<= (abs (apply - %)) 3) coll))

(defn part1
  [input]
  (->> input
       parse-input
       (filter (every-pred monotonic? bounded-growth?))
       count))

(defn part2
  [input]
  (->> input
       parse-input))
