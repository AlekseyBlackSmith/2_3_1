package app.dao;

import app.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeById(int id) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id",id).executeUpdate();
    }

    @Override
    public void update(int id, User user) {
        User userForUpdating = getById(id);
        userForUpdating.setName(user.getName());
        userForUpdating.setLastName(user.getLastName());
        userForUpdating.setAge(user.getAge());
    }

    @Override
    public User getById(int id) {
        return entityManager.createQuery("from User where id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User",User.class).getResultList();
    }
}
