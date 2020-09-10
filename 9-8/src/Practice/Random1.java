package Practice;

public class Random1 {
    public static int creatRandom(int a,int b){
        if(a>b){
            int temp=b;
            b=a;
            a=temp;
        }
        int r=(int)(Math.random()*(b-a+1))+a;
        return r;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            System.out.print(Random1.creatRandom(-4,20)+" ");
            if((i+1)%10==0){
                System.out.println();
            }
        }
    }
}
