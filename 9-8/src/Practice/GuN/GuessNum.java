package Practice.GuN;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
    Random rand=new Random();
    Scanner scanner=new Scanner(System.in);
    static String [] level={"(0~9)","(0~99)","(0~999)"};
    String [] s=new String[100];
    int times;
    private int num;
    public void creatGuessNum(){
        while(true){
            System.out.println("请选择难度等级");
            System.out.println("1. 0~9");
            System.out.println("2. 0~99");
            System.out.println("3. 0~999");
            System.out.println("0. 退出");
            int next1=scanner.nextInt();
            if(next1==0){
                System.out.println("结束程序");
                return;
            }
            System.out.println("你当前选择的难度等级"+level[next1-1]);
            num=rand.nextInt((int)(Math.pow(10,next1)));
            System.out.println("请输入想要猜的次数，0返回上一级");
            System.out.print("你的输入：");
            int next2=scanner.nextInt();
            if(next2==0){
                continue;
            }
            System.out.println("现在开始猜数");
            while (next2!=0){
                System.out.print("剩余次数"+next2+"，请输入数字"+level[next1-1]+"：");
                int next3 = scanner.nextInt();
                if (next3 > num) {
                    next2--;
                    s[times++]="第"+times+"次 "+next3+"=> "+(next3-num);
                    System.out.println("输入的是" + next3 + "，没有猜中，猜大了");
                } else if (next3 < num) {
                    next2--;
                    s[times++]="第"+times+"次 "+next3+"=> "+(next3-num);
                    System.out.println("输入的是" + next3 + "，没有猜中，猜小了");
                } else {
                    s[times++]="第"+times+"次 "+next3+"=> 正确";
                    System.out.println("输入的是" + next3 + "，恭喜你，猜中了");
                    break;
                }
            }
            if(next2==0){
                System.out.println("次数为0,结束");
            }
            System.out.println("猜题记录");
            for (int i = 0; i <times ; i++) {
                System.out.println(s[i]);
            }
            System.out.println("是否继续，1.继续, 0. 退出");
            if (scanner.nextInt()==1){
                times=0;
                continue;
            }else{
                System.out.println("结束程序");
                break;
            }
        }

    }

    public static void main(String[] args) {
        GuessNum g=new GuessNum();
        g.creatGuessNum();
    }
}