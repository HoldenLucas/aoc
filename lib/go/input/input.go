package input

import (
	"fmt"
	"os"
	"path/filepath"
	"strconv"
	"strings"
)

func load(year int, day int, example bool) string {
	var d string

	if example {
		// NOTE e suffix
		d = fmt.Sprintf("%02de.txt", day)
	} else {
		d = fmt.Sprintf("%02d.txt", day)
	}

	p := filepath.Join(".", "input", strconv.Itoa(year), d)

	f, err := os.ReadFile(p)
	if err != nil {
		panic(err)
	}

	return strings.TrimRight(string(f), "\n")
}

func Load(year int, day int) string {
	return load(year, day, false)
}

func LoadExample(year int, day int) string {
	return load(year, day, true)
}

func LoadLines(year int, day int) []string {
	i := load(year, day, false)
	return strings.Split(i, "\n")
}

func LoadLinesExample(year int, day int) []string {
	i := load(year, day, true)
	return strings.Split(i, "\n")
}
