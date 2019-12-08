package Service;

import Model.Purchase;
import Service.dao.PurchaseDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class DBService {
    private static SessionFactory sessionFactory = null;

    static {
        Configuration configuration = getMySqlConfiguration();
        sessionFactory = createSessionFactory(configuration);
    }

    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Purchase.class);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/shopping_list?serverTimezone=UTC");
        configuration.setProperty("hibernate.connection.username", "hackerdmitry");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        return configuration;
    }

    private static SessionFactory createSessionFactory(Configuration configuration) {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static List<Purchase> allPurchases() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Purchase> list = new PurchaseDAO().allPurchases(session);
        transaction.commit();
        session.close();
        return list;
    }

    public static Purchase getPurchase(long id) {
        Session session = sessionFactory.openSession();
        Purchase result = new PurchaseDAO().getPurchase(id, session);
        session.close();
        return result;
    }

    public static void addPurchase(Purchase purchase) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PurchaseDAO dao = new PurchaseDAO();
        dao.insertPurchase(purchase, session);
        transaction.commit();
        session.close();
    }

    public static void deletePurchase(Purchase purchase) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PurchaseDAO dao = new PurchaseDAO();
        dao.deletePurchase(purchase, session);
        transaction.commit();
        session.close();
    }

    public static void updatePurchase(Purchase purchase) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        PurchaseDAO dao = new PurchaseDAO();
        dao.updatePurchase(purchase, session);
        transaction.commit();
        session.close();
    }
}