package lcof;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import utils.Pair;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Solution050 {
    
    static List<Pair<String, String>> checkList = new ArrayList<>();
    static {
        checkList.add(new Pair<>("We are happy.", "We%20are%20happy."));
    }
    /**
     * 测试程序
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 程序的测试工作
        AtomicBoolean flag = new AtomicBoolean(true);

        checkList.forEach(x -> {
            String data = x.getLeft();
            String pass = x.getRight();
            if (!pass.equals(replaceSpace(data))) {
                flag.set(false);
                System.out.printf("匹配失败 -> %s : %s%n", data, pass);
            }

        });
        if (flag.get()) {
            System.out.println("匹配成功");
        }
    }

    /**
     * 核心算法
     * 
     * @param matrix
     * @param target
     * @return
     */
    public static String replaceSpace(String s) {
        // return s.replaceAll(" ", "%20");
        StringBuffer buffer = new StringBuffer();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            buffer.append(c == ' ' ? "%20":c);
        }


        return buffer.toString();
    }
}
