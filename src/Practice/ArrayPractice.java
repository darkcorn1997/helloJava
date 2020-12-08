package Practice;

public class ArrayPractice {
    public static char printGrade(double grade) {
        return grade >= 90 ? 'A'
                : grade >= 60 && grade < 90 ? 'B'
                : grade >= 40 && grade < 60 ? 'C' : 'D';
    }

    public static void main(String[] args) {
        int[] array = new int[5];
        array[0] = (int) (Math.random() * 100);
        array[1] = (int) (Math.random() * 100);
        array[2] = (int) (Math.random() * 100);
        array[3] = (int) (Math.random() * 100);
        array[4] = (int) (Math.random() * 100);

        System.out.println("数组中的各个随机数是:");
        for (int i : array) System.out.println(i);

        int max = array[0];
        int min = array[0];
        for (int i : array) {
            if (max < i) { max=i; }
            if (min > i) { min=i; }
        }

        System.out.println("本练习的目的是，通过for循环，遍历数组，找出最小值: " + min + " 最大值：" + max);
        System.out.println(printGrade(40));
    }
}
