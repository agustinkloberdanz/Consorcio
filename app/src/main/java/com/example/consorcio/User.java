package com.example.consorcio;

import java.util.Objects;

public class User {
    private int dni;
    private String password;
    private Boolean admin;

    public User(int dni, String password, Boolean admin) {
        this.dni = dni;
        this.password = password;
        this.admin = admin;
    }
    public User() {}

    public int getDni() {
        return dni;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public User setAdmin(Boolean admin) {
        this.admin = admin;
        return this;
    }

    public User setDni(int dni) {
        this.dni = dni;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "dni=" + dni +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return dni == user.dni && Objects.equals(password, user.password) && Objects.equals(admin, user.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, password, admin);
    }
}
