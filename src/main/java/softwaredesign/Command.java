package softwaredesign;

import softwaredesign.Users.User;
import softwaredesign.tamagotchis.Tamagotchi;

public class Command {
    private User user;
    private Tamagotchi tamagotchi;

    Command(User userLogin){
        user = userLogin;
        tamagotchi = user.getTamagotchi();
    }

    public void feed(){
        tamagotchi.eat(20);
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
