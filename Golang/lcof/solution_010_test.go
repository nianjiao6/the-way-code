package lcof

import (
	"fmt"
	"testing"
)

type pair struct {
	left  []int
	right []int
}

func initData() []pair {
	return []pair{{left: []int{1, 2, 3, 2}, right: []int{2}}}
}

func IsContainInt(items []int, item int) bool {
	for _, eachItem := range items {
		if eachItem == item {
			return true
		}
	}
	return false
}

func TestFunc(t *testing.T) {
	list := initData()
	flag := true
	s := new(Solution101)
	for _, item := range list {
		data := item.left
		pass := item.right
		num := s.FindRepeatNumber(data)

		if !(len(pass) == 0 && num == -1) && !IsContainInt(pass, num) {
			flag = false
			fmt.Printf("匹配失败 -> %p : %p\n", data, pass)
		}
	}

	if flag {
		fmt.Println("匹配成功")
	}
}
