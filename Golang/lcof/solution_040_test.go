package lcof

import (
	"fmt"
	"testing"
)

type Pair040 struct {
	Left  int
	Right bool
}

func TestFunc040(t *testing.T) {

	arr := [][]int{
		{1, 4, 7, 11, 15},
		{2, 5, 8, 12, 19},
		{3, 6, 9, 16, 22},
		{10, 13, 14, 17, 24},
		{18, 21, 23, 26, 30},
	}

	list := []Pair040{{Left: 3, Right: true}, {Left: 25, Right: false}}
	flag := true
	s := new(Solution040)
	for _, item := range list {
		data := item.Left
		pass := item.Right
		result := s.findNumberIn2DArray(arr, data)

		if !((!result || pass) && (result || !pass)) {
			flag = false
			fmt.Println("匹配失败 -> ", data, "  : ", pass)
		}
	}

	if flag {
		fmt.Println("匹配成功")
	}
}
