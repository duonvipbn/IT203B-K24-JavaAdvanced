package Ss04.BaiTapTongHop01;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    List<User> users = new ArrayList<>();
    public void addUser(User user){
        if(user.getUsername().isBlank()){ //___ is isBlank
            throw new IllegalArgumentException("Username cannot be null!");
        }
        users.add(user);
    }
    public User findUserById(int id){
        return users.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public boolean isValidEmail(String email){
        String regex = "[a-zA-Z0-9]+@[a-zA-Z]+\\.[a-zA-Z]{2,4}";
        return email.matches(regex);
    }
}
