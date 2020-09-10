import java.lang.reflect.Array;
import java.util.Arrays;

public class StringList {
    private static String[] strings=new String[100];
    private static int count=0;
    private String string=StringList.ToString();
    public static void addStr(String string){
        ExtendArrayLength();
        strings[count++]=string;
    }

    private static void ExtendArrayLength() {
        if (count > (strings.length * 3 / 4)) {
            strings = Arrays.copyOf(strings, strings.length * 2);
        }
    }
    public static void addStr(String string,int index){
        if(index>count){
            strings[index-1]=string;
        }
        ExtendArrayLength();
        String temp=strings[index-1];
        for (int i = count-1; i >=index-1; i--) {
            strings[i+1]=strings[i];
        }
        strings[index-1]=string;
        count++;
    }
    public static int research(String string){
        for (int i = 0; i <count; i++) {
            if(strings[i].equals(string)){
                return i;
            }
        }
        return -1;
    }
    public static String remove(String str){
        if(research(str)==-1){
            return StringList.ToString();
        }
        for (int i = 0; i <count ; i++) {
            if(strings[i].equals(str)){
                strings[i]=null;
            }
        }
        return StringList.ToString();
    }
    public static void update(String string,int index){
        strings[index-1]=string;
    }
    public static String getString(int index){
        return strings[index];
    }
    public static boolean empty(){
        return count==0;
    }
    public static String ToString(){
        String string="";
        for (int i = 0; i < strings.length; i++) {
            if(strings[i]!=null){
                string+=strings[i];
            }
        }
        return string;
    }

    public static void main(String[] args) {
        StringList.addStr("abcd ");
        StringList.addStr("1234 ");
        StringList.addStr("qwer ");
        StringList.addStr("asdf ");
        System.out.println(StringList.ToString());
        StringList.addStr("e ",2);
        System.out.println(StringList.ToString());
        StringList.addStr("rtyu ",4);
        System.out.println(StringList.ToString());
        StringList.remove("1234 ");
        System.out.println(StringList.ToString());
        System.out.println(StringList.strings);
    }
}
