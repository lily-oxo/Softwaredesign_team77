package softwaredesign.tamagotchis;

import softwaredesign.Vital;

public class Tamagotchi {
    private String name;
    private int age;
    private String color;
    private String gender;
    private Vital vital;

    public Tamagotchi(String name, String gender){
        this.name = name;
        this.gender = gender;
        vital = new Vital(50, 50, 50);
    }

    public void eat(){
        vital.setHunger(-30);
        vital.setMood(10);
    }
    public void playWithUser(){
        vital.setMood(50);
    }
    public void meetDoctor(){
    }
    public void sleep(){
        vital.setMood(20);
    }
    public void wash(){
        vital.setCleanliness(30);
    }
}
