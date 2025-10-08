package main

import (
	"math"
	"strconv"
	"strings"

	"github.com/holdenlucas/aoc/lib/go/input"
	"github.com/holdenlucas/aoc/lib/go/solution"
)

func parse() [][]int {
	lines := input.LoadLines(2024, 2)

	var reports [][]int
	for _, line := range lines {
		fields := strings.Fields(line)

		row := make([]int, 0, len(fields))
		for _, field := range fields {
			num, err := strconv.Atoi(field)
			if err != nil {
				panic(err)
			}
			row = append(row, num)
		}
		reports = append(reports, row)
	}
	return reports
}

func checkReport(report []int) bool {
	shouldIncrease := report[0] <= report[1]

	for i := 1; i < len(report); i++ {
		diff := int(math.Abs(float64(report[i] - report[i-1])))
		if diff > 3 || diff < 1 {
			return false
		}

		increasing := report[i] > report[i-1]
		if increasing != shouldIncrease {
			return false
		}
	}

	return true
}

func part1() int {
	safeReports := 0

	for _, report := range parse() {
		if checkReport(report) {
			safeReports++
		}
	}

	return safeReports
}

func part2() int {
	safeReports := 0

	for _, report := range parse() {
		if checkReport(report) {
			safeReports++
		} else {
			for i := range report {
				// remove element
				newReport := make([]int, 0, len(report)-1)
				newReport = append(newReport, report[:i]...)
				newReport = append(newReport, report[i+1:]...)

				if checkReport(newReport) {
					safeReports++
					break
				}
			}
		}
	}

	return safeReports
}

func main() {
	solution.Answer(part1, part2)
}
