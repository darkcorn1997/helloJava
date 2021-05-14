package Practice;

import java.util.Arrays;

public class ArrayPractice {

    public static void MaxAndMinAndReverse() {
        int[] array = new int[5];
        for(int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        System.out.println("数组中的各个随机数是:" + Arrays.toString(array));

        int max = array[0], min = array[0];
        for (int i : array) {
            if (max < i)
                max=i;
            if (min > i)
                min=i;
        }
        System.out.println("通过for循环，遍历数组，找出最小值: " + min + " 最大值：" + max);


        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[array.length-1-i];
        }
        System.out.println("反转数组：" + Arrays.toString(newArray));
    }

    public static int[] ArrayCopy() {   //类方法
        // copyOfRange(int[] original, int from, int to)
        // 第一个参数表示源数组，第二个参数表示开始位置(取得到)，第三个参数表示结束位置(取不到)
        int[] a = new int[] { 18, 62, 68, 82, 65, 9 };
        return Arrays.copyOfRange(a, 0, 5);
    }

    public static void main(String[] args) {
        ArrayPractice.MaxAndMinAndReverse();
        System.out.println(Arrays.toString(ArrayPractice.ArrayCopy()));
    }
}
