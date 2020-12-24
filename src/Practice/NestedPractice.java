package Practice;

import java.util.Scanner;

public class NestedPractice {
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
        if (BMI < 18.5)
            return "过轻";
        else if (18.5 <= BMI && BMI < 24)
            return "正常";
        else if (24 <= BMI && BMI < 27)
            return "过重";
        else if (27 <= BMI && BMI < 30)
            return "轻肥";
        else if (30 <= BMI && BMI < 35)
            return "中肥";
        else
            return "重肥";

    }

    public static String LeapYear(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("年份：");
        int year = scanner.nextInt();

        if ((year%4 == 0 && year%100 != 0) || year%400 == 0)
            return "闰年";
        else
            return "非闰年";
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

    public static int factorial() { //阶乘
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
                sum = sum*2 + 1;  // S(n) = 2S(n-1)+1
            System.out.println("第"+i+"天要了"+sum+"块钱");
        }

        return sum;
    }

    public static void ContinueAndBreak() {
        for (int i=0; i<=100; i++) {
            if (i%3 == 0 || i%5 == 0)
                continue;
            System.out.println(i);
        }

        boolean breakout = false; //是否终止外部循环的标记
        for (int i = 0; i < 10; i++) {

            for (int j = 1; j < 10; j++) {
                System.out.println(i+":"+j);
                if (j%2 == 0) {
                    breakout = true;
                    break;
                }
            }
            if (breakout) //判断是否终止外部循环
                break;
        }

        outLoop: //使用标签结束外部循环
        for (int i = 0; i < 10; i++) {

            for (int j = 1; j < 10; j++) {
                System.out.println(i+":"+j);
                if (0==j%2)
                    break outLoop; //如果是双数，结束当前循环
            }
        }
    }

    public static void GoldenRatio() {
        double temp, min = 1;
        int m = 0, n = 0;
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <=20; j++) {
                if (i%2 == 0 && j%2 == 0)
                    continue;
                if (i >= j)
                    continue;
                temp = Math.abs((double) i/j - 0.618);
                if (temp < min) {
                    min = temp;
                    m = i;
                    n = j;
                    System.out.printf("%d, %d, %f %n", m, n, (double)m/n);
                }
            }
        }
        System.out.printf("离黄金分割点最近的两个数是：%d / %d = %f", m, n, (double)m/n);
    }

    public static void Narcissistic() {
        for (int i = 100; i < 1000; i++) {
            String num = String.valueOf(i); //int转String
            //String num = Integer.toString(i);

            int first = Integer.parseInt(Character.toString(num.charAt(0))); //char转int
            int second = Integer.parseInt(String.valueOf(num.charAt(1)));
            int third = Character.getNumericValue(num.charAt(2));

            int number = first*first*first + second*second*second + third*third*third;

            if (number == i)
                System.out.println(i);
        }
    }

    public static void Primary() {
        Start:
        for (int a = 0; a < 8; a ++) {
            for (int b = 0; b < 8; b++) {
                for (int c = 0; c < 14; c++) {
                    for (int d = 0; d < 10; d++) {
                        if (a + b == 8 && a + c == 14 && b + d == 10 && c - d == 6) {
                            System.out.println("a = " + a + "\nb = " + b + "\nc = " + c + "\nd = " + d);
                            break Start;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //Nested.ScannerPractice();
        //while (true) { System.out.println(BMI()); }
        //while (true) { System.out.println(LeapYear()); }
        //System.out.println(Season());
        //System.out.println(factorial());
        //System.out.println(Begging());
        //Nested.ContinueAndBreak();
        //Nested.GoldenRatio();
        //Nested.Narcissistic();
        NestedPractice.Primary();
    }
}
