package ph.com.alliance.dao.impl;

import org.springframework.stereotype.Repository;
import ph.com.alliance.dao.ModuleDao;
import ph.com.alliance.entity.User2;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

@Repository("moduleDao")
public class ModuleDaoImpl implements ModuleDao {

    @Override
    public List<User2> getAllUsers(EntityManager em) {
        Query query = em.createQuery("From User2");
        List<User2> userList = query.getResultList();


        return userList;


//		List<User2> myUsers = new ArrayList<User2>();
//		for(int counter = 1; counter < 11 ; counter++) {
//			User2 newUser = new User2();
//			newUser.setAge("" + (counter+25));
//			newUser.setUid("UID-"+counter);
//			newUser.setFname("FNAME - " + counter);
//			newUser.setlName("LNAME - " + counter);
//			myUsers.add(newUser);
//		}
        // TODO Auto-generated method stub
    }

    @Override
    public void addUser(User2 user, EntityManager em) {
        em.persist(user); // if the object exists, throw an exception
        //em.merge(user); // if the object exists, update
        //but if the object does not exist, insert
    }

    @Override
    public User2 getUser(String uid, EntityManager em) {
        Query userQuery = em.createQuery("From User2 user WHERE user.uid = :uidParam ");
        userQuery.setParameter("uidParam", uid);
        User2 myUser = (User2) userQuery.getSingleResult();
        return myUser;
    }

    @Override
    public void editUser(User2 user, EntityManager em) {
        em.merge(user);
    }

    @Override
    public void deleteUsers(String[] userIdList, EntityManager em) {
        Query userQuery = em.createQuery("DELETE From User2 user WHERE user.uid IN (:uidParamList)");
        List<String> arrayListOfUID = Arrays.asList(userIdList);
        userQuery.setParameter("uidParamList", arrayListOfUID);
        userQuery.executeUpdate();
    }

}
