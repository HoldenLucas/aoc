(ns aoc2024.io
  "I/O utility functions for Advent of Code solutions"
  (:require [clojure.java.io :as io]))

(defn load-input
  "Loads puzzle input from a file"
  [filename]
  (slurp filename))

(defn load-input-resource
  "Loads puzzle input from resources directory"
  [filename]
  (slurp (io/resource filename)))
