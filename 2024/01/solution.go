package main

import (
	"slices"
	"strconv"
	"strings"

	"github.com/holdenlucas/aoc/lib/go/input"
	"github.com/holdenlucas/aoc/lib/go/solution"
)

func parse() ([]int, []int) {
	i := input.LoadLines(2024, 1)

	var llist []int
	var rlist []int
	for _, line := range i {
		if strings.TrimSpace(line) == "" {
			continue
		}

		fields := strings.Fields(line)
		if len(fields) < 2 {
			continue
		}

		l, err := strconv.Atoi(fields[0])
		if err != nil {
			panic(err)
		}
		llist = append(llist, l)

		r, err := strconv.Atoi(fields[1])
		if err != nil {
			panic(err)
		}
		rlist = append(rlist, r)
	}
	return llist, rlist
}

func part1() int {
	llist, rlist := parse()

	slices.Sort(llist)
	slices.Sort(rlist)

	res := 0
	for i := range llist {
		diff := llist[i] - rlist[i]
		if diff < 0 {
			diff = -diff
		}
		res += diff
	}

	return res
}

func part2() int {
	llist, rlist := parse()

	freq := map[int]int{}
	freq = make(map[int]int)
	for _, v := range llist {
		freq[v] = 0
	}

	for _, v := range rlist {
		_, exists := freq[v]
		if exists {
			freq[v] += 1
		}
	}

	res := 0
	for _, v := range llist {
		res += v * freq[v]
	}

	return res
}

func main() {
	solution.Answer(part1, part2)
}
