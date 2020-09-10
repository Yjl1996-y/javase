package Practice;

public class StringSplit {
    private String [] s=new String[100];
    private int count;
    public void split(String str){
        String [] s1=str.split(" ");
        for (int i = 0; i <s1.length ; i++) {
            s[count++]=s1[i];
        }
        for (int i = 0; i <count ; i++) {
            char [] c= s[i].toCharArray();
            s[i]="";
            for (int j = 0; j <c.length/2 ; j++) {
                char temp=c[c.length-1-j];
                c[c.length-1-j]=c[j];
                c[j]=temp;
            }
            for (int j = 0; j <c.length ; j++) {
                s[i]+=c[j];
            }
        }
        String s2=new String();
        for (int i = 0; i <count-1 ; i++) {

            s2+=s[i]+" ";
        }
        s2=s2+s[count-1];
        System.out.println(s2);
    }

    public static void main(String[] args) {
        StringSplit s=new StringSplit();
        s.split("To be or not to be");
    }
}
