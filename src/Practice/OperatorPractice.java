package Practice;

import java.util.Scanner;

public class OperatorPractice {

    public static void ScannerPractice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("输入整数：");
        int a = scanner.nextInt();
        System.out.println("第一个整数："+ a);

        System.out.println("输入浮点数：");
        double b = scanner.nextDouble();
        System.out.println("第一个浮点数："+ b);

        System.out.println("输入字符串：");
        String s1 = scanner.nextLine(); //读取的是换行回车
        String s2 = scanner.nextLine(); //读取的是输入字符
        System.out.println("第一个字符串："+ s2);
    }

    public static char printGrade(double grade) {
        return grade >= 90 ? 'A'
                : grade >= 60 && grade < 90 ? 'B'
                : grade >= 40 && grade < 60 ? 'C' : 'D';
    }

    public static void main(String[] args) {
        //OperatorPractice.ScannerPractice();
        System.out.println(OperatorPractice.printGrade(40));
    }
}
