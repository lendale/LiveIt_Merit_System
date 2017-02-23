package ph.com.alliance.dao;

import ph.com.alliance.entity.User2;

import javax.persistence.EntityManager;
import java.util.List;

public interface ModuleDao {

    List<User2> getAllUsers(EntityManager em);

    void addUser(User2 user, EntityManager em);

    User2 getUser(String uid, EntityManager em);

    void editUser(User2 user, EntityManager em);

    void deleteUsers(String[] userIdList, EntityManager em);
}
