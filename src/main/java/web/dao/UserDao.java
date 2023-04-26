package web.dao;

import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao {
    void add(User user);
    void update(User updateUser);

    void removeById(Long id);
    List<User> listUsers();
    User getById(Long id);

}
