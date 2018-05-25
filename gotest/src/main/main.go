package main

import (
	"cal"
	"cal/multi"
	"fmt"
)

func main() {
	result := cal.Add(1, 2)
	fmt.Printf("%d\n", result)

	result = cal.Substract(110, 2)
	fmt.Printf("%d\n", result)

	result = multi.Multi(2, 4)
	fmt.Printf("%d\n", result)
}
