package ph.com.alliance.dao;

import ph.com.alliance.entity.Product;

import javax.persistence.EntityManager;

/**
 *
 *
 */
public interface ProductDao {

    /**
     * @param pEM
     * @param pProd
     * @return
     */
    boolean createProduct(EntityManager pEM, Product pProd);

    /**
     * @param pEM
     * @param pProd
     * @return
     */
    Product updateProduct(EntityManager pEM, Product pProd);

    /**
     * @param pEM
     * @param pKey
     * @return
     */
    Product selectProduct(EntityManager pEM, String pSerialNo);

}
