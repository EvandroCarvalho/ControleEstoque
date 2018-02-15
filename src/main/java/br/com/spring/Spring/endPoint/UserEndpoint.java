package br.com.spring.Spring.endPoint;

import br.com.spring.Spring.Connection.ConnectionFactory;
import br.com.spring.Spring.ConnectionDao.Dao;
import br.com.spring.Spring.model.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("users")
public class UserEndpoint {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity userlist(){
        return new ResponseEntity( new Dao().selectUsers(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getUserById(@PathVariable("id") int id){
        Connection connection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from users where id = " + id);
            ResultSet result = stmt.executeQuery();
            System.out.println(result);
            if (result.next()) {
                Users user = new Users();
                user.setId(result.getInt("id"));
                user.setUser(result.getString("user"));
                user.setPassword(result.getString("password"));
                return new ResponseEntity(user, HttpStatus.OK);
            }
            return new ResponseEntity("Não encontrado", HttpStatus.NOT_FOUND);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity save(@RequestBody Users user){
        new Dao().insertUser(user);
        return  new ResponseEntity(user, HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteAll(){
        new Dao().delete();
        return new ResponseEntity("Todos os dados da tabela User foram excluidos",HttpStatus.OK);
    }
    //ajustar este método e o Dao
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Users user){
        new Dao().update(user.getUser(), user.getUser());
        return new ResponseEntity(user, HttpStatus.OK);
    }
}

