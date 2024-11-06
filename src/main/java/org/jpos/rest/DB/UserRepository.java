package org.jpos.rest.DB;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.jpos.rest.model.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class UserRepository implements UserRepositoryContract{

    public UserRepository() {
    }

    @Override
    public void addUser (Session session, User user){
        session.save(user);
    }

    @Override
    public User getUserById(Session session, int id){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cp = cb.createQuery(User.class);
        Root<User> root = cp.from(User.class);
        cp.select(root).where(cb.equal(root.get("id"),id));

        return session.createQuery(cp).uniqueResult();
    }
}
