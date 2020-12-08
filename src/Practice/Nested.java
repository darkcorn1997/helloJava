package Practice;

import java.util.Scanner;

public class Nested {
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

    public static String BMI() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("身高(m)：");
        double height = scanner.nextDouble();

        System.out.println("体重(kg)：");
        double weight = scanner.nextDouble();

        double BMI = weight / (height * height);
        if (BMI < 18.5) { return "过轻"; }
        else if (18.5 <= BMI && BMI < 24) { return "正常"; }
        else if (24 <= BMI && BMI < 27) { return "过重"; }
        else if (27 <= BMI && BMI < 30) { return "轻肥"; }
        else if (30 <= BMI && BMI < 35) { return "中肥"; }
        else { return "重肥"; }

    }

    public static String LeapYear(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("年份：");
        int year = scanner.nextInt();

        if ((year%4 == 0 && year%100 != 0) || year%400 == 0) { return "闰年"; }
        else { return "非闰年"; }
    }

    public static String Season() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入月份");
        int month = scanner.nextInt();

        return switch (month) {
            case 1, 2, 3 -> "spring";
            case 4, 5, 6 -> "summer";
            case 7, 8, 9 -> "fall";
            case 10,11,12 -> "winter";
            default -> "invalid";
        };
    }

    public static int factorial() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个整数");
        int i = scanner.nextInt();
        int sum = 1;

        while (i>0) {
            sum = sum * i;
            i--;
        }

/*      do {
            sum = sum * i;
            i--;
        } while (i>0);     */

        return sum;
    }

    public static int Begging() { // 0 1 2 4 8 16，等比数列求和
        int income = 0;
        int total = 0;

        for (int i=0; i<=10; i++) {
            if (i<=1)
                income = i;
            else
                income = income*2;
            total = total + income;
        }

        int sum = 0;
        for (int i = 0; i<= 10; i++) {
            if (i>=1)
                sum = sum*2 + 1; // S(n) = 2S(n-1)+1
            System.out.println("第"+i+"天要了"+sum+"块钱");
        }

        return total;
    }

    public static void main(String[] args) {
        //ScannerPractice();
        //while (true) { System.out.println(BMI()); }
        //while (true) { System.out.println(LeapYear()); }
        //System.out.println(Season());
        //System.out.println(factorial());
        System.out.println(Begging());
    }
}
