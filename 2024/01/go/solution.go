package main

import (
	"os"
	"strings"
)

func main() {
	file, err := os.ReadFile("../input.txt")
	if err != nil {
		panic(err)
	}
	input := string(file)
	lines := strings.Split(input, "\n")
	for _, line := range lines {
		print(line)
		print()
	}
}
