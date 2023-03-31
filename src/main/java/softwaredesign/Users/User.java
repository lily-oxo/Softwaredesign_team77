package softwaredesign.Users;

import softwaredesign.RockPaperScissors;
import softwaredesign.tamagotchis.Tamagotchi;

public class User {
    public String id;
    public String username;
    private Authentication pw;
    public int balance = 30;
    private Tamagotchi tamagotchi;

    public User(String id, String username, String pw){
        this.id = id;
        this.username = username;
        this.pw = new Authentication(pw);
    }

    public void setTamagotchi(Tamagotchi tamagotchiInput){
        tamagotchi = tamagotchiInput;
    }
    public Tamagotchi getTamagotchi(){
        return tamagotchi;
    }
    public boolean enoughBalance(int price){
        return balance - price >= 0;
    }
    public int getBalance(){
        return balance;
    }
    public void updateBalance(int addition) {
        balance = balance + addition;
    }
    public void buyFood(int price){
        balance -= price;
        if(balance<0) balance = 0;
    }
    public void rockPaperScissors(){
        RockPaperScissors RPSgame = new RockPaperScissors();
        RPSgame.playGame();
    }
    public boolean matchPassword(String pw){
        return this.pw.matchPassword(pw);
    }

}

class Authentication {
    private String pw;
    Authentication(String pw){
        this.pw = pw;
    }
    boolean matchPassword(String password){
        if(password.equals(pw)){
            return true;
        }else return false;
    }
}