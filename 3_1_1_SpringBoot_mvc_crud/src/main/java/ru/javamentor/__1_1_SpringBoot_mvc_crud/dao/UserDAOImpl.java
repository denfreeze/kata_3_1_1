package ru.javamentor.__1_1_SpringBoot_mvc_crud.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.javamentor.__1_1_SpringBoot_mvc_crud.model.User;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> allUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);
    }

    @Override
    public User getOne(long id) {
        return em.createQuery("select u from User u where u.id = :id", User.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public void updateUser(Long id, User user) {
        User updateUser = em.find(User.class, id);
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setAge(user.getAge());
        em.merge(updateUser);
    }

    @Override
    public void deleteUser(Long id) {
        User deleteUser = em.find(User.class, id);
        em.remove(deleteUser);
    }
}
