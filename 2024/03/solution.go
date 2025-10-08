package main

import (
	"regexp"
	"strconv"

	"github.com/holdenlucas/aoc/lib/go/input"
	"github.com/holdenlucas/aoc/lib/go/solution"
)

const cmdLength = 8

func parse() ([][]int, []int) {
	line := input.Load(2024, 3)

	mulPattern := regexp.MustCompile(`mul\((\d+),(\d+)\)`)
	matches := mulPattern.FindAllStringSubmatchIndex(line, -1)

	commands := make([][]int, 0, len(matches))
	indexes := make([]int, 0, len(matches))
	for _, match := range matches {
		// match[0] is start of full match, match[1] is end of full match
		// match[2] is start of first capture group, match[3] is end
		// match[4] is start of second capture group, match[5] is end

		x, err := strconv.Atoi(line[match[2]:match[3]])
		if err != nil {
			panic(err)
		}
		y, err := strconv.Atoi(line[match[4]:match[5]])
		if err != nil {
			panic(err)
		}

		res := []int{x, y}

		commands = append(commands, res)
		indexes = append(indexes, match[0])
	}

	return commands, indexes
}

func part1() int {
	commands, _ := parse()

	sum := 0
	for _, vals := range commands {
		sum += vals[0] * vals[1]
	}
	return sum
}

func part2() int {
	memory := input.Load(2024, 3)

	doPattern := regexp.MustCompile(`do\(\)`)
	doMatches := doPattern.FindAllStringSubmatchIndex(memory, -1)
	doIndexes := make([]int, 0, len(memory))
	for _, match := range doMatches {
		doIndexes = append(doIndexes, match[0])
	}

	dontPattern := regexp.MustCompile(`don't\(\)`)
	dontMatches := dontPattern.FindAllStringSubmatchIndex(memory, -1)
	dontIndexes := make([]int, 0, len(memory))
	for _, match := range dontMatches {
		dontIndexes = append(dontIndexes, match[0])
	}

	commands, commandIndexes := parse()

	sum := 0
	for i, commandIndex := range commandIndexes {
		isEnabled := true
		mostRecentIndex := -1

		for _, doIndex := range doIndexes {
			if doIndex < commandIndex && doIndex > mostRecentIndex {
				mostRecentIndex = doIndex
				isEnabled = true
			}
		}

		for _, dontIndex := range dontIndexes {
			if dontIndex < commandIndex && dontIndex > mostRecentIndex {
				mostRecentIndex = dontIndex
				isEnabled = false
			}
		}

		command := commands[i]

		if isEnabled {
			sum += command[0] * command[1]
		}

	}

	return sum
}

func main() {
	solution.Answer(part1, part2)
}
