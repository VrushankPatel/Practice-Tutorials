package main

import "fmt"

// p := 2, we can't use this syntax for var to declare them at package level, we've to use var keyword
var p = 32. // or var p float32 = 32.

// var block below.
var (
	doctorName   string  = "Maheta"
	doctorPoints float32 = 34.22
	nurseName    string  = "vishva"
	nursePoints  float32 = 44.11
)

func main() {
	// below line will access global vars
	fmt.Print(doctorName, " : ", doctorPoints, "\n", nurseName, " : ", nursePoints, "\n")

	// declaring global vars in local for new vars as local
	var doctorName string = "local Maheta"
	var doctorPoints float32 = 78.32
	var nurseName string = "local vishva"
	var nursePoints float32 = 21.22

	// now access local directly
	fmt.Print(doctorName, " : ", doctorPoints, "\n", nurseName, " : ", nursePoints, "\n")

	fmt.Printf("p : %v %T\n", p, p) // v = value  T = template, it'll be of int type

	// var a int = 23
	a := 23
	a = 43
	fmt.Println(a)
	fmt.Printf("a : %v %T\n", a, a) // v = value  T = template, it'll be of int type

	const aa float32 = 23.33
	fmt.Println(aa)
	fmt.Printf("aa : %v %T\n", aa, aa) // v = value  T = template

	var k = 23.33
	fmt.Printf("k : %v %T", k, k) // v = value  T = template, it'll be of float64 type

	var kk = 99.
	fmt.Printf("kk : %v %T", kk, kk) // v = value  T = template, it'll be of float64 type
}
