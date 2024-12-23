(ns aoc2024.io
  "I/O utility functions for Advent of Code solutions"
  (:require [clojure.java.io :as io]))

(defn load-input
  "Loads puzzle input from a file"
  [day]
  (let [file (io/file (str "../input/" day ".txt"))]
    (if (.exists file)
      (slurp file)
      (throw (Exception. (str "Input file not found: " (.getPath file)))))))

(defn load-example
  "Loads puzzle example input from a file"
  [day]
  (let [file (io/file (str "../input/" day ".example.txt"))]
    (if (.exists file)
      (slurp file)
      (throw (Exception. (str "Example file not found: " (.getPath file)))))))

(defn load-input-resource
  "Loads puzzle input from resources directory"
  [filename]
  (slurp (io/resource filename)))
