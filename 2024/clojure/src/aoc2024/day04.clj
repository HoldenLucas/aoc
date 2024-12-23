(ns aoc2024.day04
  (:require [hashp.core]
            [clojure.string :as str]))

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
