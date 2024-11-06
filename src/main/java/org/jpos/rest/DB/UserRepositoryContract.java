package org.jpos.rest.DB;

import org.hibernate.Session;
import org.jpos.rest.model.User;

public interface UserRepositoryContract {
    public void addUser (Session session, User user);
    public User getUserById(Session session, int id);
}
