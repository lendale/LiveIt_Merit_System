package ph.com.alliance.service;

import ph.com.alliance.entity.Product;
import ph.com.alliance.entity.User;

import java.util.List;

/**
 *
 *
 */
public interface DBTransactionTestService {
    /**
     * @return
     */
    boolean createUser(User pUser);

    /**
     *
     */
    User updateUser(User pUser);

    /**
     *
     */
    void deleteUser(User pUser);

    /**
     * @return
     */
    User selectUser(User pUser);

    /**
     * @return
     */
    List<User> selectUsers(String pKey);

    /**
     * @return
     */
    boolean createProduct(Product pProd);

    /**
     *
     */
    Product updateProduct(Product pProd);

    /**
     *
     */
    void deleteProduct(Product pProd);

    /**
     * @return
     */
    Product selectProduct(Product pProd);

    /**
     * @return
     */
    List<User> selectAllUsers();

    /**
     * @return
     */
    List<Product> selectProducts(String pKey);

    /*-------------------- MULTI TABLE TRANSASCTION TESTS -----------------------*/
    boolean createUserAndProduct(User pUser, Product pProd, boolean pRollbackFlag);

    boolean createUserAndUpdateProduct(User pUser, Product pProd, boolean pRollbackFlag);


}
