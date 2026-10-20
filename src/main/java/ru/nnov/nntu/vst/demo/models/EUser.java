package ru.nnov.nntu.vst.demo.models;


import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class EUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_usertype", referencedColumnName = "id")
    private EUserType userType;
    @Column(name = "name_db")
    private String name; // Имя пользователя
    @Column(name = "email_db", nullable = false, unique = true)
    private String email; // Email пользователя

    public EUser() {
    }

    // Конструктор, принимающий значения переменных
    public EUser(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public EUser(Long id, EUserType userType, String name, String email) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.email = email;
    }

    public EUserType getUserType() {
        return userType;
    }

    public void setUserType(EUserType userType) {
        this.userType = userType;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EUser{" +
                "id=" + id +
                ", userType=" + userType +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
