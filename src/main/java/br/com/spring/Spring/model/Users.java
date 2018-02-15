package br.com.spring.Spring.model;

public class Users {
    private int id;
    private String user;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users() {

    }

    public Users(int id, String name, String pawword) {

        this.id = id;
        this.user = name;
        this.password = pawword;
    }
}
