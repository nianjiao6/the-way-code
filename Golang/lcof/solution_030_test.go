package lcof

import (
	"fmt"
	"testing"
)

type Pair030 struct {
	Left  []int
	Right []int
}

func initData() []Pair030 {
	return []Pair030{{Left: []int{1, 2, 3, 2}, Right: []int{2}}}
}

func IsContainInt(items []int, item int) bool {
	for _, eachItem := range items {
		if eachItem == item {
			return true
		}
	}
	return false
}

func TestFunc030(t *testing.T) {
	list := initData()
	flag := true
	s := new(Solution030)
	for _, item := range list {
		data := item.Left
		pass := item.Right
		num := s.FindRepeatNumber(data)

		if !(len(pass) == 0 && num == -1) && !IsContainInt(pass, num) {
			flag = false
			fmt.Println("匹配失败 -> ", data, "  : ", pass)
		}
	}

	if flag {
		fmt.Println("匹配成功")
	}
}
