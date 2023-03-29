package softwaredesign.tamagotchis;

public class Professor extends Tamagotchi {
    public Professor(String name, String gender) {
        super(name, gender);
    }
    @Override
    public String getRole() {
        return "Professor";
    }
    @Override
    public void sleep(){
        vital.setMood(10);
    }
}
