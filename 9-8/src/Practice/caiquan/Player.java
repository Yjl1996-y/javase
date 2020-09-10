package Practice.caiquan;

import java.util.Random;
import java.util.Scanner;

public class Player {

    // 每人的出拳
    private String fingerType;
    // 每人是否被淘汰
    boolean isOut;
    // 玩家编号
    private int id;
    //玩家类型 1 玩家 2 电脑
    private String userType;

    public Player(int id ,String  userType){
        this.id=id;
        this.userType=userType;
    }

    public String getFingerType() {
        return fingerType;
    }

    public void setFingerType(String fingerType) {
        this.fingerType = fingerType;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    public String getUserTypeName(){
        if(getUserType()==Main.USER_TYPE_HUMAN){
            return "玩家";
        }else {
            return "电脑";
        }
    }
    public void showFinger(){
        // 玩家
        if(userType=="1"){
            Scanner scanner=new Scanner(System.in);
            System.out.println("请出拳,1.剪刀 2.石头3.布");
            System.out.println("你的输入:");
            String line = scanner.nextLine();
            switch (line){
                case "1":
                case "2":
                case "3":
                    fingerType=line;
                    break;
                default:
                    System.out.println("输入错误,请重新输入:");
                    showFinger();
            }
        }else{
            Random random = new Random();
            fingerType=String.valueOf(random.nextInt(3)+1);
        }
    }
    public String getFingerTypeName(){
        switch (fingerType){
            case "1":
                return "剪刀";
            case "2":
                return "石头";
            case "3":
                return "布";
        }
        return "";
    }
    public String getFingerTypeInfo() {
        return getUserTypeName() + id + "出了" + getFingerTypeName();
    }
}
