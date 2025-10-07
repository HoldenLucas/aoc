package main

import (
	"os"
	"slices"
	"strconv"
	"strings"
)

func part1() {
	file, err := os.ReadFile("./input/2024/01/1.txt")
	if err != nil {
		panic(err)
	}
	input := string(file)
	lines := strings.Split(input, "\n")

	var lcol []int
	var rcol []int
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
		lcol = append(lcol, l)

		r, err := strconv.Atoi(fields[1])
		if err != nil {
			panic(err)
		}
		rcol = append(rcol, r)
	}
	slices.Sort(lcol)
	slices.Sort(rcol)

	total := 0
	for i := range lcol {
		d := lcol[i] - rcol[i]
		if d < 0 {
			d = -d
		}
		total += d
	}

	if total == 1222801 {
		print("it worked!")
	} else {
		print("not worked!")
	}
}

func main() {
	part1()
}
