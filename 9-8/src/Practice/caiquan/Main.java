package Practice.caiquan;

import java.util.Scanner;

public class Main {
    //出拳类型
    //剪刀
    public static final String FINGER_TYPE_SCISSORS="1";
    //石头
    public static final String FINGER_TYPE_ROCK="2";
    //布
    public static final String FINGER_TYPE_FABRIC="3";

    public static final String  USER_TYPE_HUMAN = "1";
    public static final String USER_TYPE_COMPUTER = "2";
    //猜拳人数
    public static int playerCount;

    //玩家列表
    public static Player[] players;
    //每人的出拳
    //每人是否淘汰
    //玩家编号

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入参与猜拳人数(2-5)人,输入0退出");
            System.out.println("请输入人数:");
            String line = scanner.nextLine();
            switch (line){
                case "0":
                    System.out.println("程序结束");
                    return;
                case "2":
                case "3":
                case "4":
                case "5":
                    initPlayerList(line);
                    fingerGuess();
                default:
                    System.out.println("输入不合法，请重新输入！");
                    break;
            }
        }
    }

    private static void initPlayerList(String line) {
        Main.playerCount=Integer.parseInt(line);
        Main.players = new Player[Main.playerCount];
        players[0]=new Player(1,USER_TYPE_HUMAN);
        for (int i = 1; i < players.length; i++) {
            players[i]=new Player(i+1,USER_TYPE_COMPUTER);
        }
    }

    private static void fingerGuess() {
        System.out.println("======开始猜拳======");
        //循环直到1人胜出，如果有人胜出，就打印胜出玩家的信息
        // 当前未被淘汰的人依次出拳，比较当前这一轮的人的出拳结果，输出信息，然后修改玩家是否被淘汰的状态
        Player winner = getWinner();
        if(winner!=null){
            System.out.println(winner.getUserTypeName()+winner.getId()+"获胜!");
        }else{
            setPlayerFinger();
            String fingerResult = getFingerResult();
            if(fingerResult.length()==1 || fingerResult.length()==3){
                printUserDrawState();
            }else{
                String winnerFinger = getWinnerFinger(fingerResult);
                printAndSetPlayerOutState(winnerFinger);
            }
            fingerGuess();
        }

    }

    private static void printAndSetPlayerOutState(String winnerFinger) {
        for (Player player : players) {
            if(!player.isOut()){
                if(player.getFingerType().equals(winnerFinger)){
                    System.out.println(player.getFingerTypeInfo()+",获胜");
                }else{
                    player.setOut(true);
                    System.out.println(player.getFingerTypeInfo()+",淘汰");
                }
            }
        }
    }

    private static String getWinnerFinger(String fingerResult) {
        switch (fingerResult){
            case "12":
            case "21":
                return FINGER_TYPE_ROCK;
            case "23":
            case "32":
                return FINGER_TYPE_FABRIC;
            case "13":
            case "31":
                return FINGER_TYPE_SCISSORS;
        }
        return "";
    }

    private static void printUserDrawState() {
        for (Player player : players) {
            if(!player.isOut()){
                System.out.println(player.getFingerTypeInfo()+",平局");
            }
        }
    }

    private static String getFingerResult() {
        String rlt="";
        for (Player player : players) {
            if(!player.isOut){
                String fingerType = player.getFingerType();
                if(!rlt.contains(fingerType)){
                    rlt+=fingerType;
                }
            }
        }
        return rlt;
    }

    private static void setPlayerFinger() {
        for (Player player : players) {
            if(!player.isOut){
                player.showFinger();
            }
        }
    }
    private  static Player getWinner(){
        //剩余玩家人数
        int playerLeft = 0;
        Player winner = null;
        for (Player player : players) {
            if(!player.isOut){
                playerLeft++;
                winner=player;
            }
        }
        if(playerLeft==1){
            return winner;
        }else {
            return null;
        }
   }
}
