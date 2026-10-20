package ru.nnov.nntu.vst.demo.dto;


import ru.nnov.nntu.vst.demo.models.EUserType;

public class UserDTO {
    private Long id;
    private UserTypeDTO userType;
    private String name; // Имя пользователя
    private String email; // Email пользователя

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserDTO(Long id, UserTypeDTO userType, String name, String email) {
        this.id = id;
        this.userType = userType;
        this.name = name;
        this.email = email;
    }

    public UserTypeDTO getUserType() {
        return userType;
    }

    public void setUserType(UserTypeDTO userType) {
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
        return "UserDTO{" +
                "id=" + id +
                ", userType=" + userType +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
