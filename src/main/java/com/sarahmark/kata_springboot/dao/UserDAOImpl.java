package com.sarahmark.kata_springboot.dao;

import com.sarahmark.kata_springboot.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void saveUser(User user) {
        if (user.getId() == 0) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("select u from User u", User.class).getResultList();
        return users;
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUser(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
