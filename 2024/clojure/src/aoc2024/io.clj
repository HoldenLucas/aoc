(ns aoc2024.io
  "I/O utility functions for Advent of Code solutions"
  (:require [clojure.java.io :as io]))

(defn load-input
  "Loads puzzle input from a file"
  [day]
  (slurp (str "../input/" day ".txt")))

(defn load-example
  "Loads puzzle example input from a file"
  [day]
  (slurp (str "../input/" day ".example.txt")))

(defn load-input-resource
  "Loads puzzle input from resources directory"
  [filename]
  (slurp (io/resource filename)))
