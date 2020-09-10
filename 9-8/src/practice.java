import jdk.swing.interop.SwingInterOpUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class practice {
    public static String toStr(byte[] bytes,int begin,int length){
        StringBuilder str= new StringBuilder();
        for (int i=begin;i<begin+length;i++){
            str.append(Character.toString(bytes[i]));
        }
        return str.toString();
    }
    public static int tocompareTo(String s1,String s2){
            int m=s1.length();
            int n=s2.length();
            if(m!=n){
                return Math.abs(m-n);
            }
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        for (int i = 0; i <m ; i++) {
            if(chars[i]!=chars1[i]){
                return Math.abs(chars[i]-chars1[i]);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        byte [] by={65,67,68,97,98,101};
        String s =practice.toStr(by,0,2) ;
        System.out.println(s);
        String str1="abcdw";
        String str2="ABCDW";
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println("我是你的谁,我是你的剑".contains("剑"));
        System.out.println("我是你的谁,我是你的剑".endsWith("剑"));
        String str3="";
        String str4=null;
        System.out.println(str3==str4);
        System.out.println("我是你的小宝贝".substring(0,1));
        System.out.println("我是你的谁,我是你的剑".indexOf("你"));
        System.out.println("我是你的谁,我是你的剑".lastIndexOf("你"));
        System.out.println("我是你的谁,我是你的剑".substring(4).indexOf("你"));
        String s1 = " 我是你的谁,我是你的剑 ".trim();
        System.out.println(s1);
        System.out.println(s1.replace("谁","被子"));
        System.out.println(s1.replace("你","哈"));
        String s2="avabc";
        String s3="avab";
        System.out.println(s2.compareTo(s3));
        System.out.println(practice.tocompareTo(s2,s3));
        String s4="记得拉开关机";
        String s5 = new String(s4.getBytes(), StandardCharsets.ISO_8859_1);
        byte[] s6 = s5.getBytes(Charset.forName("ISO_8859_1"));
        System.out.println(new String(s6,StandardCharsets.UTF_8));
    }

}
