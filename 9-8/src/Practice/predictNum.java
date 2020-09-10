package Practice;

import java.util.Random;
import java.util.Scanner;

public class predictNum {
    private char [] num=new char[4];
    private int count1;
    private int count2;
    public  void creatnum(){
        Random rand=new Random();
        char []random={'0','1','2','3','4','5','6','7','8','9'};
        int a=random.length;
        for (int i = 0; i <num.length ; i++) {
            int b=rand.nextInt(a);
            num[i]=random[b];
            if(b!=(a-1)){
                random[b]=random[a-1];
                a--;
            }else{
                a--;
            }
        }
    }
    public boolean contain(char [] a,int i,char source){
        for (int j = i+1; j <a.length; j++) {
            if(a[j]==source){
                return true;
            }
        }
        return false;
    }
    public char[] fillByInput(){
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        while(s.length()!=4){
            System.out.print("请重新输入:");
            s=scanner.nextLine();
        }
        char [] a=s.toCharArray();
        boolean flag=false;
        while(!flag){
            int count=0;
            for(int i=0;i<a.length;i++){
                if((a[i]>='0'&&a[i]<='9')&&!contain(a,i,a[i])){
                    count++;
                }else{
                    System.out.print("请重新输入:");
                    s=scanner.nextLine();
                    break;
                }
            }
            if(count==4){
                flag=true;
                break;
            }
            a=s.toCharArray();
        }
        return a;
    }
    public  void ispredict(char[] a){
        for (int i = 0; i <a.length ; i++) {
            if(num[i]==a[i]){
                count1++;
            }
            for (int j = 0; j <num.length ; j++) {
                if(a[i]==num[j]){
                    count2++;
                }
            }
        }
        System.out.println("包含了"+count2+"个正确的数字");
        System.out.println(count1+"个数字的位置正确");
        if(count1!=4 || count2!=4){
            count1=0;
            count2=0;
        }
    }

    public int getCount1() {
        return count1;
    }

    public void print(){
        creatnum();
        System.out.print("猜一猜4个不重复的数字，");
//        Scanner scanner=new Scanner(System.in);
        while(getCount1()!=4){
            System.out.print("请输入4个数字：");
            ispredict(fillByInput());
        }
        System.out.println("回答正确");
    }

    public static void main(String[] args) {
        predictNum p=new predictNum();
        p.print();
    }
}

