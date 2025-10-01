package structural.facade;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private Map<String, String> users = new HashMap<>();

    public UserDatabase() {
        // Prepopulate with some users (username -> password)
        users.put("username", "password@123");
        users.put("aaa", "aaa@123");
    }

    public boolean validateUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

