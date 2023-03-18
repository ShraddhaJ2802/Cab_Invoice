package org.example;

public class UserId {

    private String user;

    public UserId(){

    }

    public UserId(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserId{" +
                "user='" + user + '\'' +
                '}';
    }
}
