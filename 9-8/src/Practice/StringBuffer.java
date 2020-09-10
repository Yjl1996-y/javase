package Practice;

public class StringBuffer {
    private char [] chars=new char[100];
    private int count;
    public  void append(String str){
        char []s=str.toCharArray();
        for (int i = 0; i <s.length ; i++) {
            chars[count++]=s[i];
        }
    }
    public  void append(char str){
        chars[count++]=str;
    }
    public String toString(){
        String newStr=new String(chars);
        return newStr;
    }
    public void clear(){
        for(int i=0;i<=count;i++){
            chars[i]=0;
        }
    }
    public String reverse(){
        char [] c=new char[100];
        for (int i = 0; i <=count ; i++) {
            c[i]=chars[count-i];
        }
        return new String(c);
    }
    public String reverse(int from,int to){
        int j=1;
        for (int i = from; i <(from+to)/2; i++) {
            char temp=chars[to-j];
            chars[to-j]=chars[from];
            chars[from]=temp;
            j++;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        StringBuffer s=new StringBuffer();
        System.out.println(s);
        s.append("abcd");
        s.append('e');
        s.append("fg");
        System.out.println(s.toString());
        System.out.println(s.reverse());
        System.out.println(s.reverse(1,3));
        s.clear();
        System.out.println(s);
    }
}
