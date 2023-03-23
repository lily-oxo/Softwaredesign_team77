package softwaredesign;

public class Command {
    private User user;
    private Tamagotchi tamagotchi;

    Command(User userLogin){
        user = userLogin;
        tamagotchi = user.getTamagotchi();
    }

    public void feed(){

    }

    public void play(){

    }

    public void callDoctor(){

    }

    public void rest(){

    }

    public void cleanUp(){

    }

    public void earnMoneyWithMiniGame(){

    }

}
