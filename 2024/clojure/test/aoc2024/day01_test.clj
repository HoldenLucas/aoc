(ns aoc2024.day01-test
  (:require [clojure.test :as test]
            [aoc2024.day01 :as day01]
            [aoc2024.io :as aio]))

(def EXAMPLE (aio/load-input "../input/01e.txt"))
(def INPUT (aio/load-input "../input/011.txt"))

(test/deftest parse-input-test
  (test/testing "parses input into pairs of numbers"
    (test/is (= [[3 4 2 1 3 3] [4 3 5 3 9 3]]
                (day01/parse-input EXAMPLE)))))

(test/deftest part1-test
  (test/testing ""
    (test/are [input expected] (= expected (day01/part1 input))
      EXAMPLE 11
      INPUT 1222801)))

(test/deftest part2-test
  (test/testing ""
    (test/are [input expected] (= expected (day01/part2 input))
      EXAMPLE 31
      INPUT 22545250)))
