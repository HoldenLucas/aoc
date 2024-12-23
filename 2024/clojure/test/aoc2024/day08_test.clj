(ns aoc2024.day08-test
  (:require [clojure.test :as test]
            [aoc2024.io :as aio]
            [aoc2024.day08 :as d08]))

(def ID "08")

(def EXAMPLE (aio/load-example ID))
(def INPUT (aio/load-input ID))

(test/deftest parse-input-test
  (test/testing "parses input"
    (test/is (= (d08/parse-input EXAMPLE)
                [[\. \. \. \. \. \. \. \. \. \. \. \.]
                 [\. \. \. \. \. \. \. \. \0 \. \. \.]
                 [\. \. \. \. \. \0 \. \. \. \. \. \.]
                 [\. \. \. \. \. \. \. \0 \. \. \. \.]
                 [\. \. \. \. \0 \. \. \. \. \. \. \.]
                 [\. \. \. \. \. \. \A \. \. \. \. \.]
                 [\. \. \. \. \. \. \. \. \. \. \. \.]
                 [\. \. \. \. \. \. \. \. \. \. \. \.]
                 [\. \. \. \. \. \. \. \. \A \. \. \.]
                 [\. \. \. \. \. \. \. \. \. \A \. \.]
                 [\. \. \. \. \. \. \. \. \. \. \. \.]
                 [\. \. \. \. \. \. \. \. \. \. \. \.]]))))

(d08/foo (d08/parse-input EXAMPLE))

(test/deftest part1-test
  (test/testing "solves part 1"
    (test/are [input expected] (= expected (d08/part1 input))
      EXAMPLE 14
      INPUT "baz")))

(test/deftest part2-test
  (test/testing "solves part 2"
    (test/are [input expected] (= expected (d08/part2 input))
      EXAMPLE "qux"
      INPUT "quux")))
