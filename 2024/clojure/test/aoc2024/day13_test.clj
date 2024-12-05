(ns aoc2024.day13-test
  (:require [clojure.test :as test]
            [aoc2024.io :as aio]
            [aoc2024.day13 :as d13]))

(def ID "13")

(def EXAMPLE (aio/load-example ID))
(def INPUT (aio/load-input ID))

(test/deftest parse-input-test
  (test/testing "parses input"
    (test/is (= (d13/parse-input EXAMPLE)
                "foo"))))

(test/deftest part1-test
  (test/testing "solves part 1"
    (test/are [input expected] (= expected (d13/part1 input))
      EXAMPLE "bar"
      INPUT "baz")))

(test/deftest part2-test
  (test/testing "solves part 2"
    (test/are [input expected] (= expected (d13/part2 input))
      EXAMPLE "qux"
      INPUT "quux")))
