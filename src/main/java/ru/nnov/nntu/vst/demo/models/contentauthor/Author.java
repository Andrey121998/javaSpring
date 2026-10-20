package ru.nnov.nntu.vst.demo.models.contentauthor;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;

    // формируем связь многие ко многим с созданием дополнительной таблицы
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "Author_Content",
               joinColumns = {@JoinColumn(referencedColumnName = "id")},
               inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<Content> content = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
