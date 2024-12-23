(ns aoc2024.day08
  (:require [clojure.string :as str]
            [hashp.core]))

(defn parse-input
  [input]
  (->> input
       str/split-lines
       (map vec)))

(defn foo
  [input]
  (map-indexed
   (fn [ir row]
     (map-indexed
      (fn [ic col]
        [[ir ic] col])
      row))
   input))

(defn part1
  [input]
  (->> input
       parse-input))

(defn part2
  [input]
  (->> input
       parse-input))
