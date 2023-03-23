package softwaredesign;

import softwaredesign.tamagotchis.Tamagotchi;

public class Command {
    private User user;
    private Tamagotchi tamagotchi;

    Command(User userLogin){
        user = userLogin;
        tamagotchi = user.getTamagotchi();
    }

    public void feed(){


        tamagotchi.eat();
    }

    public void play(){
        tamagotchi.playWithUser();
    }

    public void callDoctor(){
        tamagotchi.meetDoctor();
    }

    public void rest(){
        tamagotchi.sleep();
    }

    public void cleanUp(){
        tamagotchi.wash();
    }

    public void earnMoneyWithMiniGame(){
        user.rockPaperScissors();
    }

}
