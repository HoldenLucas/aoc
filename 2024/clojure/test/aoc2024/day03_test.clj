(ns aoc2024.day03-test
  (:require [clojure.test :as test]
            [aoc2024.io :as aio]
            [aoc2024.day03 :as d3]))

(def ID "03")

(def EXAMPLE (aio/load-example ID))
(def INPUT (aio/load-input ID))

(test/deftest parse-input-test
  (test/testing "parses input into columns of numbers"
    (test/is (= (d3/parse-input EXAMPLE)
                "foo"))))

(test/deftest part1-test
  (test/testing ""
    (test/are [input expected] (= expected (d3/part1 input))
      EXAMPLE 11
      INPUT 1222801)))

(test/deftest part2-test
  (test/testing ""
    (test/are [input expected] (= expected (d3/part2 input))
      EXAMPLE 31
      INPUT 22545250)))