package softwaredesign.tamagotchis;

public class TA extends Tamagotchi {
    public TA(String name, String gender) {
        super(name, gender);
    }
    @Override
    public String getRole() {
        return "TA";
    }
    @Override
    public void eat(int num){
        vital.setHunger(-num);
        vital.setMood(15);
    }
    @Override
    public void playWithUser(){
        vital.setMood(10);
    }
    @Override
    public void sleep(){
        vital.setMood(30);
    }
    @Override
    public void wash(){
        vital.setCleanliness(20);
    }
}
