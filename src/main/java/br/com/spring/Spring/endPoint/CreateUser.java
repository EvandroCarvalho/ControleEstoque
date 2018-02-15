package br.com.spring.Spring.endPoint;

import br.com.spring.Spring.ConnectionDao.Dao;
import br.com.spring.Spring.model.Users;

public class CreateUser {
    Dao dao;
    public void AddUser (Users user) {
        dao = new Dao();
        user = new Users();
        dao.insertUser(user);
    }
}
