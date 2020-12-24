package Practice;

import java.util.Arrays;

public class ArrayPractice {
    public static char printGrade(double grade) {
        return grade >= 90 ? 'A'
                : grade >= 60 && grade < 90 ? 'B'
                : grade >= 40 && grade < 60 ? 'C' : 'D';
    }

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


    public static void main(String[] args) {
        //System.out.println(ArrayPractice.printGrade(40));
        ArrayPractice.MaxAndMinAndReverse();
    }
}
