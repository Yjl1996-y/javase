package Practice.GuN;

import java.util.Random;
import java.util.Scanner;

public class GuessNum2 {
    private static final Scanner scanner =new Scanner(System.in);
    private static Random random =new Random();
    private  int num;//随机数
    private String [] s=new String[100];//记录结果
    private  int times;//次数
    private  int count;
    static String [] level={"(0~9)","(0~99)","(0~999)"};
    // 控制菜单的flag选项
    private static final int MENU_LEVEL = 1;
    private static final int MENU_TIMES = 2;
    private static final int MENU_PLAY = 3;
    private static final int MENU_FINISH = 4;
    private static final int MENU_QUIT = 5;
    private static int flag = MENU_LEVEL;


    public static void main(String[] args) {
        GuessNum2 g=new GuessNum2();
        g.print();
    }
    
    private static boolean isNotNumber(String input){
        char [] chars=input.toCharArray();
        for (char achar:chars) {
            if(achar<'0'||achar>'9'){
                return true;
            }
        }
        return false;
    }
    private void chooseFinish() {
        System.out.println("猜题记录");
        for (int i = 0; i <count ; i++) {
            System.out.println(s[i]);
        }
        while(true) {
            System.out.println("是否继续，1.继续, 0. 退出");
            int a=scanner.nextInt();
            if(a==0){
                flag = MENU_QUIT;
                break;
            }else{
                flag = MENU_LEVEL;
                break;
            }
        }
    }
    private void choosePlay() {
        System.out.println("现在开始猜数");
        while (times!=0){
            System.out.print("剩余次数"+times+"，请输入数字：");
            int next3 = scanner.nextInt();
            if (next3 > num) {
                times--;
                s[count++]="第"+count+"次 "+next3+"=> "+(next3-num);
                System.out.println("输入的是" + next3 + "，没有猜中，猜大了");
            } else if (next3 < num) {
                times--;
                s[count++]="第"+count+"次 "+next3+"=> "+(next3-num);
                System.out.println("输入的是" + next3 + "，没有猜中，猜小了");
            } else {
                times--;
                s[count++]="第"+count+"次 "+next3+"=> 正确";
                System.out.println("输入的是" + next3 + "，恭喜你，猜中了");
                break;
            }
        }
        if(times==0){
            System.out.println("次数为0,结束");
        }
        flag=MENU_FINISH;
    }
    private  void chooseTimes() {
        System.out.println("请输入想要猜的次数，0返回上一级");
        System.out.print("你的输入：");
        String input=scanner.nextLine();
        if (isNotNumber(input)){
            System.out.println("输入不合法");
            return;
        }
        int inputTimes = Integer.parseInt(input);
        if (inputTimes < 0 || inputTimes > 1000) {
            System.out.println("输入不合法");
            return;
        }

        if (inputTimes == 0) {
            flag = MENU_LEVEL;
            return;
        }
        times=inputTimes;
        flag=MENU_PLAY;
    }

    private  void chooseLevel() {
        System.out.println("请选择难度等级");
        System.out.println("1. 0~9");
        System.out.println("2. 0~99");
        System.out.println("3. 0~999");
        System.out.println("0. 退出");
        String input=scanner.nextLine();
        switch (input){
            case "1":
            case "2":
            case "3":
                System.out.println("你当前选择的难度等级"+level[Integer.parseInt(input)-1]);
                num=(random.nextInt((int)(Math.pow(10,Integer.parseInt(input)))));
                flag=MENU_TIMES;
                break;
            case "0":
                flag = MENU_QUIT;
                break;
            default:
                System.out.println("输入不合法，请重新输入");
                break;
        }
    }
    public void print(){
        while(true){
            switch (flag){
                case MENU_LEVEL:
                    chooseLevel();
                    break;
                case MENU_TIMES:
                    chooseTimes();
                    break;
                case MENU_PLAY:
                    choosePlay();
                    break;
                case MENU_FINISH:
                    chooseFinish();
                    break;
                case MENU_QUIT:
                    System.out.println("结束程序");
                    return;
                default:
                    break;
            }
        }
    }




}
