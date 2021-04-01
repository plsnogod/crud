package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
// Маркер для класса, который выполняет роль репа, также известный как объект доступа к данным (ДАО), для автоматической трансляции исключений в вашем слое персистентности.
public class UserDaoImpl implements UserDao {

    @PersistenceContext //  предназначена для автоматического связывания менеджера сущностей с бином
    private EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);

        List <User> allUsers =  query.getResultList();
        return allUsers;
    }


    @Override
    public User getById(long Id) {
        return em
                .createQuery("select u from User u where u.id =?1", User.class)
                .setParameter(1, Id)
                .getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void removeUser(long id) {
        em.remove(getById(id));
    }
}
