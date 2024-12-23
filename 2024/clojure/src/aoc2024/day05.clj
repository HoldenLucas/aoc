(ns aoc2024.day05
  (:require [clojure.string :as str]
            [hashp.core]))

(defn parse-input
  [input]
  (->> input
       str/split-lines))

(defn part1
  [input]
  (->> input
       parse-input))

(defn part2
  [input]
  (->> input
       parse-input))
