package nowcoder;

import java.util.*;


public class Easy {

    /**
     * 反转字符串
     * @param str string字符串
     * @return string字符串
     */
    public String solve (String str) {
        char[] ans = new char[str.length()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = str.charAt(str.length()-1-i);
        }
        return new String(ans);
    }

    /**
     * 螺旋矩阵
     * @param matrix .
     * @return  .
     */
    public void spiralOrder(int[][] matrix) {

    }
}