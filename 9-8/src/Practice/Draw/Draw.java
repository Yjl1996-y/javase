package Practice.Draw;

import java.util.Random;
import java.util.Scanner;

public class Draw {
    Random rand=new Random();
    private int a=rand.nextInt(100);;
    public void printDraw(){
        if(a<5){
            System.out.println("大吉");
        }else if(a>=5 && a<15){
            System.out.println("中吉");
        }else if(a>=15 && a<30){
            System.out.println("小吉");
        }else if(a>=30 && a<60 ){
            System.out.println("吉");
        }else if(a>=60 && a<80){
            System.out.println("末吉");
        }else if(a>=80 && a<95){
            System.out.println("凶");
        }else if(a>=95 && a<99 ){
            System.out.println("大凶");
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            int next=scanner.nextInt();
            if(next==0){
                System.out.println("程序结束");
                break;
            }
            Draw d=new Draw();
            d.printDraw();
        }
    }
}
