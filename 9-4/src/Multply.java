public class Multply {
    public static int multply(int a,int b){
        if(a==0 ||b==0){
            return 0;
        }
        int temp=a;
        while (b>1){
            a+=temp;
            b--;
        }
        return a;
    }

    public static void main(String[] args) {
        int a=multply(3,4);
        System.out.println(a);
    }
}
