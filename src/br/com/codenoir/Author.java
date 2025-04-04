package br.com.codenoir;

import java.time.LocalDate;

public class Author {
    private static int idCounter = 0;
    private int id;
    private String name;
    private LocalDate birth;

    public Author(String name, LocalDate birth) {
        this.id = ++idCounter;
        this.name = name;
        this.birth = birth;
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
}
