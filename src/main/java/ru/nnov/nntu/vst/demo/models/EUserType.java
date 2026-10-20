package ru.nnov.nntu.vst.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "usertype")
public class EUserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_db")
    private String name;

    public EUserType() {
    }

    public EUserType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        return "UserType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
