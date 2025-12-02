package solution

func Answer(part1 func() int, part2 func() int) {
	print(part1(), "\n", part2())
}
