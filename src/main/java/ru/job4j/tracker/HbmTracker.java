package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Artem Chernikov
 * @version 1.0
 * @since 27.04.2023
 */
public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        int isUpdated = 0;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("UPDATE Item SET name = :name, created = :created WHERE id = :id", Item.class)
                    .setParameter("name", item.getName())
                    .setParameter("created", Timestamp.valueOf(item.getCreated()))
                    .setParameter("id", id);
            isUpdated = query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return isUpdated > 0;
    }

    @Override
    public boolean delete(int id) {
        int isDeleted = 0;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("DELETE Item WHERE id = :id", Item.class)
                    .setParameter("id", id);
            isDeleted = query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return isDeleted > 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("from Item", Item.class);
            items = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("from Item WHERE name = :name", Item.class)
                    .setParameter("name", key);
            items = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("from Item WHERE id = :id", Item.class)
                    .setParameter("id", id);
            item = query.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    @Override
    public boolean deleteAll() {
        int isDeleted = 0;
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            Query<Item> query = session.createQuery("DELETE from Item", Item.class);
            isDeleted = query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return isDeleted > 0;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}
