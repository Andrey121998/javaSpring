package ru.nnov.nntu.vst.demo.models.contentauthor;

import jakarta.persistence.*;
import ru.nnov.nntu.vst.demo.models.wdpparser.Directory;
import ru.nnov.nntu.vst.demo.models.wdpparser.DirectoryContent;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "content")
public abstract class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_db")
    private String name; // Имя пользователя
    @ManyToOne
    @JoinColumn(name = "id_contenttype", referencedColumnName = "id")
    private DirectoryContent contentType;

    @ManyToMany(mappedBy = "content")
    private Set<Author> authors;

    public Content(int id, String name, DirectoryContent contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public Content() {
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

    public DirectoryContent getDirectory() {
        return contentType;
    }

    public void setDirectory(DirectoryContent directory) {
        this.contentType = directory;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directory=" + contentType +
                '}';
    }
}
