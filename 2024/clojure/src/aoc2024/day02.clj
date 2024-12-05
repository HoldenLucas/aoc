(ns aoc2024.day01
  (:require [clojure.string :as str]
            [hashp.core]))

; juxt - when you need multiple transformations on a single input
(defn extract-first-last
  [word-groups]
  ((juxt #(mapv (fn [x] (-> x first parse-long)) %)
         #(mapv (fn [x] (-> x last parse-long)) %))
   word-groups))

(defn parse-input
  [input]
  (->> input
       str/split-lines
       (map #(str/split % #"\s+"))
       extract-first-last))

(defn part1
  [input]
  (->> input
       parse-input
       (map sort)
       (apply map -)
       (map abs)
       (reduce +)))

(defn multiply-by-frequency [freqs x]
  (* x (get freqs x 0)))

(defn part2
  [input]
  (let [[numbers freqs] (parse-input input) freq-map (frequencies freqs)]
    (->> numbers
         (map #(multiply-by-frequency freq-map %))
         (reduce +))))
