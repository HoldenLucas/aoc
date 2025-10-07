package main

import (
	"os"
	"slices"
	"strconv"
	"strings"
)

func parse(path string) ([]int, []int) {
	file, err := os.ReadFile(path)
	if err != nil {
		panic(err)
	}
	input := string(file)
	lines := strings.Split(input, "\n")

	var llist []int
	var rlist []int
	for _, line := range lines {
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
	llist, rlist := parse("./input/2024/01.txt")

	slices.Sort(llist)
	slices.Sort(rlist)

	total := 0
	for i := range llist {
		diff := llist[i] - rlist[i]
		if diff < 0 {
			diff = -diff
		}
		total += diff
	}

	return total
}

func part2() int {
	llist, rlist := parse("./input/2024/01.txt")

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

	sum := 0
	for _, v := range llist {
		sum += v * freq[v]
	}

	return sum
}

func main() {
	print(part1())
	print("\n")
	print(part2())
}
