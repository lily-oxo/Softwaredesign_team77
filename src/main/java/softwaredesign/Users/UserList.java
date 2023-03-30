package softwaredesign.Users;

import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static UserList instance = new UserList();
    public List<User> userList;
    private UserList(){userList = new ArrayList<>();}
    User currentUser;
    public static UserList getInstance(){
        return instance;
    }
    public boolean logIn(String id, String pw){
        for(User eachUser: userList){
            if (id.equals(eachUser.id)){
                if(eachUser.matchPassword(pw)){
                    currentUser = eachUser;
                    return true;
                }else return false;
            }
        }
        return false;
    }
    public void addUser(User user){
        userList.add(user);
    }

    public User getCurrentUser(){
        if(currentUser == null) return null;
        return currentUser;
    }

}
