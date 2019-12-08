package Service.dao;

import Model.Purchase;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class PurchaseDAO {
    public PurchaseDAO() {}

    @SuppressWarnings("unchecked")
    public List<Purchase> allPurchases(Session session) {
        return session.createQuery("from Purchase").list();
    }

    public Purchase getPurchase(long id, Session session) throws HibernateException {
        Criteria criteria = session.createCriteria(Purchase.class);
        return (Purchase) criteria.add(Restrictions.eq("id", id)).uniqueResult();
    }

    public void insertPurchase(Purchase purchase, Session session) throws HibernateException {
        session.save(purchase);
    }

    public void updatePurchase(Purchase purchase, Session session) throws HibernateException {
        session.update(purchase);
    }

    public void deletePurchase(Purchase purchase, Session session) throws HibernateException {
        session.delete(purchase);
    }
}