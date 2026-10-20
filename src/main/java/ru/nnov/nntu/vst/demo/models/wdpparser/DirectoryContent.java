package ru.nnov.nntu.vst.demo.models.wdpparser;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "DirectoryContent")
public class DirectoryContent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name_db")
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_directory", referencedColumnName = "id")
    private Directory directory;

    public DirectoryContent(int id, String name, Directory directory) {
        this.id = id;
        this.name = name;
        this.directory = directory;
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

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    @Override
    public String toString() {
        return "DirectoryContent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directory=" + directory +
                '}';
    }
}
