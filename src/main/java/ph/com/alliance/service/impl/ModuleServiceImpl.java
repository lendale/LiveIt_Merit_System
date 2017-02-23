package ph.com.alliance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import ph.com.alliance.dao.ModuleDao;
import ph.com.alliance.entity.User2;
import ph.com.alliance.service.ModuleService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

@Component("moduleService")
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleDao moduleDao;

    @Autowired
    private JpaTransactionManager transactionManager;

    @Override
    public String addTwoNumbers(String firstNumber, String secondNumber) {
        String sum = null;
        User2 myUser = new User2();
        myUser.setAge("");
        try {
            int intFirstNumber = Integer.parseInt(firstNumber);
            int intSecondNumber = Integer.parseInt(secondNumber);

            sum = "" + (intFirstNumber + intSecondNumber);
        } catch (NumberFormatException exception) {
            System.out.println("NAGKA EXCEPTION");
        }

        return sum;
    }

    @Override
    public List<User2> getAllUsers() {
        EntityManager em = transactionManager.getEntityManagerFactory()
                .createEntityManager();

        List<User2> userList = moduleDao.getAllUsers(em);

        if (em.isOpen())
            em.close();

        // List<User2> newArrayList = new ArrayList<User2>();

        // return only those indexes % 2
        // int size = userList.size();
        // for(int counter = 0 ; counter < size; counter++) {
        // if(counter % 2 == 0) {
        // newArrayList.add(userList.get(counter));
        // }
        // }

        return userList;
    }

    @Override
    public void addUser(User2 user) {

        EntityManager em = transactionManager.getEntityManagerFactory()
                .createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            moduleDao.addUser(user, em);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive())
                transaction.rollback();

        } finally {
            System.out.println("FINALLY SOMETHING HAPPENED TO ME");
        }

        if (em.isOpen())
            em.close();
    }

    @Override
    public User2 getUser(String uid) {

        EntityManager em = transactionManager.getEntityManagerFactory().createEntityManager();

        User2 user = moduleDao.getUser(uid, em);

        if (em.isOpen())
            em.close();
        return user;
    }

    @Override
    public void editUser(User2 user) {

        EntityManager em = transactionManager.getEntityManagerFactory()
                .createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            moduleDao.editUser(user, em);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive())
                transaction.rollback();

        } finally {
            System.out.println("FINALLY SOMETHING HAPPENED TO ME");
        }

        if (em.isOpen())
            em.close();
    }

    @Override
    public void deleteUsers(String[] userIdList) {

        EntityManager em = transactionManager.getEntityManagerFactory()
                .createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            moduleDao.deleteUsers(userIdList, em);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction.isActive())
                transaction.rollback();

        } finally {
            System.out.println("FINALLY SOMETHING HAPPENED TO ME");
        }

        if (em.isOpen())
            em.close();
    }

}
