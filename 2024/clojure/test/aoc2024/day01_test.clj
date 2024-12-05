(ns aoc2024.day01-test
  (:require [clojure.test :as test]
            [aoc2024.io :as aio]
            [aoc2024.day01 :as d1]))

(def ID "01")

(def EXAMPLE (aio/load-example ID))
(def INPUT (aio/load-input ID))

(test/deftest parse-input-test
  (test/testing "parses input into columns of numbers"
    (test/is (= (d1/parse-input EXAMPLE)
                [[3 4 2 1 3 3] [4 3 5 3 9 3]]))))

(test/deftest part1-test
  (test/testing ""
    (test/are [input expected] (= expected (d1/part1 input))
      EXAMPLE 11
      INPUT 1222801)))

(test/deftest part2-test
  (test/testing ""
    (test/are [input expected] (= expected (d1/part2 input))
      EXAMPLE 31
      INPUT 22545250)))
