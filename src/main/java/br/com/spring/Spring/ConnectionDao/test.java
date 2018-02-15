package br.com.spring.Spring.ConnectionDao;

import br.com.spring.Spring.model.Users;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        Dao dao = new Dao();
        dao.delete();
        Users Uuser = new Users(0,"Evandro","123");
        dao.insertUser(Uuser);

        List<Users> user = new ArrayList<Users>();
        user = dao.selectUsers();
        System.out.println(user.size());

    }
}
