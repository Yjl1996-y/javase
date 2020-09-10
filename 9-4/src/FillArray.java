import java.lang.reflect.Array;
import java.util.Arrays;

public class FillArray {
    public static int[] fillarrray(int[] array){
        Arrays.sort(array);
        int[] ints = new int[array.length];
        int count=0;
        for (int i = 0; i <array.length-1 ; i++) {
            if(array[i]!=array[i+1]){
                ints[count++]=array[i];
                ints[count]=array[i+1];
            }
        }
        return ints=Arrays.copyOfRange(ints,0,count+1);
    }

    public static void main(String[] args) {
        int[] ints={1,2,3,4,4,3,3,2,5};
        int[] fillarrray = fillarrray(ints);
        System.out.println(Arrays.toString(fillarrray));
    }
}
