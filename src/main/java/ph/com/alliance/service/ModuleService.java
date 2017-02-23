package ph.com.alliance.service;

import ph.com.alliance.entity.User2;

import java.util.List;

public interface ModuleService {

    String addTwoNumbers(String firstNumber, String secondNumber);

    List<User2> getAllUsers();

    void addUser(User2 user);

    User2 getUser(String uid);

    void editUser(User2 user);

    void deleteUsers(String[] userIdList);
}
