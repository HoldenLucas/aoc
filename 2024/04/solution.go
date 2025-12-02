package main

import (
	"fmt"
	"os"

	"github.com/holdenlucas/aoc/lib/go/input"
	"github.com/holdenlucas/aoc/lib/go/solution"
)

func parse() [][]string {
	lines := input.LoadLinesExample(2024, 4)

	res := make([][]string, 0, len(lines))
	for _, line := range lines {
		chars := make([]string, 0, len(line))
		for _, c := range line {
			chars = append(chars, string(c))
		}
		res = append(res, chars)
	}

	return res
}

func part1() int {
	puzzle := parse()
	fmt.Fprintf(os.Stderr, "DEBUGPRINT[110]: solution.go:20: commands=%+v\n", puzzle)

	for y, row := range puzzle {
		for x := range row {
			fmt.Fprintf(os.Stderr, "DEBUGPRINT[111]: solution.go:30: y=%+v\n", y)
			fmt.Fprintf(os.Stderr, "DEBUGPRINT[112]: solution.go:32: x=%+v\n", x)
		}
	}

	sum := 0
	return sum
}

func part2() int {
	sum := 0
	return sum
}

func main() {
	solution.Answer(part1, part2)
}
