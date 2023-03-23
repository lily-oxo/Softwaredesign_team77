package softwaredesign;

import softwaredesign.tamagotchis.Tamagotchi;

public class User {
    public String id;
    public String username;
    private String pw;
    private int balance = 0;
    private Tamagotchi tamagotchi;

    public User(String id, String username, String pw){
        this.id = id;
        this.username = username;
        this.pw = pw;
    }

    public void setTamagotchi(Tamagotchi tamagotchiInput){
        tamagotchi = tamagotchiInput;
    }
    public Tamagotchi getTamagotchi(){
        return tamagotchi;
    }
    public void rockPaperScissors(){
    }

}
