package softwaredesign.Users;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    public static List<User> userList = new ArrayList<>();
    User currentUser;
    public boolean logIn(String id, String pw){
        for(User eachUser: userList){
            if (id == eachUser.id){
                if(eachUser.matchPassword(pw)){
                    currentUser = eachUser;
                    return true;
                }else return false;
            }
        }
        return false;
    }

    public User getCurrentUser(){
        return currentUser;
    }

}
