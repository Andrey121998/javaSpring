package ru.nnov.nntu.vst.demo.dto;

public class UserTypeDTO {
    private Long id;
    private String name;

    public UserTypeDTO() {
    }

    public UserTypeDTO(Long id, String name) {
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
        return "UserTypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
