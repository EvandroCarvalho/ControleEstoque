package br.com.spring.Spring.ConnectionDao;


import br.com.spring.Spring.Connection.ConnectionFactory;
import br.com.spring.Spring.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Dao {
    Connection connection;
    public void insertUser (Users user){
        connection = new ConnectionFactory().getConnection();
        String sql = "insert into users values (?,?,?)";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,0);
            stmt.setString(2,user.getUser());
            stmt.setString(3,user.getPassword());
            stmt.execute();
            stmt.close();
            connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<Users> selectUsers (){
        String sql = "select * from users";
        List<Users> list = new ArrayList<Users>();
        connection = new ConnectionFactory().getConnection();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()){
             Users user = new Users();
             user.setId(result.getInt("id"));
             user.setUser(result.getString("user"));
             user.setPassword(result.getString("password"));
             list.add(user);
            }
            stmt.close();
            connection.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    public void delete(){
        connection = new ConnectionFactory().getConnection();
        String sql = "delete from users";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            connection.close();
            stmt.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
