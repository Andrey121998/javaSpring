package ru.nnov.nntu.vst.demo.models.wdpparser;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Directory")
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_db")
    private String name;

    public Directory(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Directory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
