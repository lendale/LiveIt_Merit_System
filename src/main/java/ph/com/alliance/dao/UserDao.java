package ph.com.alliance.dao;

import ph.com.alliance.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 *
 */
public interface UserDao {
    /**
     * @param puser
     * @return
     */
    boolean createUser(EntityManager pEM, User pUser);

    /**
     * @param p_em
     * @param pUser
     * @return
     */
    User updateUser(EntityManager pEM, User pUser);

    /**
     * @param p_em
     * @param pUser
     * @return
     */
    int deleteUser(EntityManager pEM, User pUser);

    /**
     * @param p_em
     * @param pUser
     * @return
     */
    User selectUser(EntityManager pEM, String pUid);

    /**
     * @param p_em
     * @param pKey
     * @return
     */
    List<User> selectUsers(EntityManager pEM, String pKey);

    /**
     * @param pEM
     * @return
     */
    List<User> selectAllUsers(EntityManager pEM);

}
