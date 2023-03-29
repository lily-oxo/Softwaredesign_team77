package softwaredesign.tamagotchis;

import softwaredesign.Vital;

public abstract class Tamagotchi {
    private String name;
    //private int age;
    //private String color;
    private String gender;
    public Vital vital;

    public Tamagotchi(String name, String gender){
        this.name = name;
        this.gender = gender;
        vital = new Vital(70, 20, 20);
    }

    public String getName(){return name;}
    public String getGender(){return gender;}
    public abstract String getRole();

    public void eat(int num){
        vital.setHunger(-num);
        vital.setMood(10);
    }
    public void playWithUser(){
        vital.setMood(30);
    }
    public void meetDoctor(){
        vital.treat();
    }
    public void sleep(){
        vital.setMood(20);
    }
    public void wash(){
        vital.setCleanliness(30);
    }
}
