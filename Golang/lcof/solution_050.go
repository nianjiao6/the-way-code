package lcof

import "strings"

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
type Solution050 struct {
	//
}

// 核心算法
func (s *Solution050) replaceSpace(str string) string {
	return strings.Replace(str, " ", "%20", -1)
}
