package br.com.codenoir;

import java.time.LocalDate;

public class Client {
    private int id;
    private String name;
    private LocalDate birth;
    private String email;

    public Client(int id, String name, LocalDate birth, String email) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
