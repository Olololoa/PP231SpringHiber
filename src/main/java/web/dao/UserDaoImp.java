package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext()
    private EntityManager entityManager;

    @Override
    @Transactional
    public void add(User user) {
        entityManager.persist(user);
        entityManager.close();
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    @Transactional
    public void update(User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    @Transactional
    public void removeById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

}
