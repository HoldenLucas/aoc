#lang racket

(define lines (file->lines "2024/input/011.txt"))

(for ([line lines])
  (displayln line))
