import java.util.Arrays;

public class SortArray {
    public static void sortArr(int[] arr,boolean b){

        for (int i = 0; i <arr.length-1 ; i++) {
            boolean flag=false;
            for (int j = 0; j <arr.length-1-i ; j++) {
                if(b){
                    if(arr[j]>arr[j+1]){
                        flag=true;
                        swap(arr, j);
                    }
                }else{
                    if(arr[j]<arr[j+1]){
                        flag=true;
                        swap(arr,j);
                    }
                }
            }
            if(!flag){
                break;
            }
        }
    }
    private static void swap(int[] arr, int j) {
        int temp=arr[j];
        arr[j]=arr[j+1];
        arr[j+1]=temp;
    }

    public static void sortArr(int[] arr){
        sortArr(arr,true);
    }
    public static void print(int [] arr){
        for (int i = 0; i <arr.length ; i++) {
            System.out.print("["+i+"]"+"="+arr[i]+" ");
            if((i+1)%5==0){
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int [] arr={13,26,-3,4,54,26,37,18,69,-10};
        print(arr);
        sortArr(arr,false);
        print(arr);
    }
}
