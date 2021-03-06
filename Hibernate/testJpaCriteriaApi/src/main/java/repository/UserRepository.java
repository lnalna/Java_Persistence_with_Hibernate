package repository;

import user.User;

import java.util.List;


    public interface UserRepository {
        User save(User user);

        boolean delete(int id);

        User get(int id);

        List<User> search();
    }

