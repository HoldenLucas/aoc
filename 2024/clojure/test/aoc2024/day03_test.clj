(ns aoc2024.day03-test
  (:require [clojure.test :as test]
            [aoc2024.io :as aio]
            [aoc2024.day03 :as d3]))

(def ID "03")

(def EXAMPLE (aio/load-example ID))
(def INPUT (aio/load-input ID))

(test/deftest parse-input-test
  (test/testing "parses input"
    (test/is (= (d3/parse-input EXAMPLE)
                "foo"))))

(test/deftest part1-test
  (test/testing "solves part 1"
    (test/are [input expected] (= expected (d3/part1 input))
      EXAMPLE "bar"
      INPUT "baz")))

(test/deftest part2-test
  (test/testing "solves part 2"
    (test/are [input expected] (= expected (d3/part2 input))
      EXAMPLE "qux"
      INPUT "quux")))
