(ns aoc2024.day02-test
  (:require [clojure.test :as test]
            [aoc2024.io :as aio]
            [aoc2024.day02 :as day]))

(def ID "02")

(def EXAMPLE (aio/load-example ID))
(def INPUT (aio/load-input ID))

(test/deftest parse-input-test
  (test/testing "parses input into columns of numbers"
    (test/is (= (first (day/parse-input EXAMPLE))
                [7 6 4 2 1]))))

(test/deftest part1-test
  (test/testing ""
    (test/are [input expected] (= expected (day/part1 input))
      EXAMPLE 2
      INPUT 631)))

(test/deftest part2-test
  (test/testing ""
    (test/are [input expected] (= expected (day/part2 input))
      EXAMPLE 31
      INPUT 22545250)))
