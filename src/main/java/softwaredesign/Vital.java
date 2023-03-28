package softwaredesign;

public class Vital {
    private int hunger;
    private int cleanliness;
    private int mood;
    boolean health = true;
    boolean death = false;
    Observer observer;

    public Vital(int hunger, int cleanliness, int mood){
        this.hunger = hunger;
        this.cleanliness = cleanliness;
        this.mood = mood;
    }

    public void setHunger(int plus){
        hunger += plus;
        if(hunger<0) hunger = 0;
        else if(hunger>100) hunger = 100;
        notifyObserver();
    }
    public void setCleanliness(int plus){
        cleanliness += plus;
        if(cleanliness<0) cleanliness = 0;
        else if(cleanliness>100) cleanliness = 100;
        notifyObserver();
    }
    public void setMood(int plus){
        mood += plus;
        if(mood<0) mood = 0;
        else if(mood>100) mood = 100;
        notifyObserver();
    }

    public void getHungry(){
        //TODO: make this function operate as time passes
        //these code are made to operate just randomly when the user logs in
        if(Math.random()>0.5) setHunger((int)(Math.random()*50));
        checkDeath();
        notifyObserver();
    }
    public void getSick(){
        health = false;
        checkDeath();
        notifyObserver();
    }
    public void getLonely(){
        if(Math.random()>0.5) setMood(-(int)(Math.random()*50));
        checkDeath();
        notifyObserver();
    }
    public void getDirty(){
        if(Math.random()>0.5) setCleanliness(-(int)(Math.random()*50));
        checkDeath();
        notifyObserver();
    }
    public int getHungerV(){
        return hunger;
    }
    public int getCleanlinessV(){
        return cleanliness;
    }
    public int getMoodV(){
        return mood;
    }

    private void checkDeath(){
        if(!health){
            if(mood<10 || hunger>90 || cleanliness<10) death = true;
        }else if(mood<10){
            if(hunger>90 || cleanliness<10) death = true;
        }else if(hunger>90 && cleanliness<10) death = true;
    }

    //about observer
    public void attach(Observer observer){
        this.observer = observer;
    }
    public void notifyObserver(){
        observer.update();
    }

}
