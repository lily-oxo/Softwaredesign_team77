package softwaredesign;

import softwaredesign.tamagotchis.Tamagotchi;

public class Observer {
    TamagotchiGUI tamagotchiGUI;
    Vital vital;
    public Observer(TamagotchiGUI tamagotchiGUI, Tamagotchi tamagotchi){
        this.tamagotchiGUI = tamagotchiGUI;
        this.vital = tamagotchi.vital;
        vital.attach(this);
    }

    public void update(){
        tamagotchiGUI.updateFrame();
    }
}
