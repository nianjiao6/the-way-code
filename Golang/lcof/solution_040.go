package lcof

/**
 * 题目描述
 * 在一个 n * m
 * 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
type Solution040 struct {
	//
}

// 核心算法
func (s *Solution040) findNumberIn2DArray(matrix [][]int, target int) bool {

	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return false
	}
	n := len(matrix)
	m := len(matrix[0])

	for i, j := 0, m-1; i < n && j >= 0; {
		tmp := matrix[i][j]
		if tmp == target {
			return true
		}

		if tmp > target {
			j--
		} else {
			i++
		}

	}

	return false
}
