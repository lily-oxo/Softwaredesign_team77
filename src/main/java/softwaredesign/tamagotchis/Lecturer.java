package softwaredesign.tamagotchis;

public class Lecturer extends Tamagotchi {
    public Lecturer(String name, String gender) {
        super(name, gender);
    }

    @Override
    public String getRole() {
        return "Lecturer";
    }
    @Override
    public void playWithUser(){
        vital.setMood(20);
    }
}
