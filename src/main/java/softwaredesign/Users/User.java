package softwaredesign.Users;

import softwaredesign.tamagotchis.Tamagotchi;

public class User {
    public String id;
    public String username;
    private Authentication pw;
    private int balance = 0;
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
    public void rockPaperScissors(){
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