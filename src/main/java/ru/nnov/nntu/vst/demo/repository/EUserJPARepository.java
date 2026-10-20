package ru.nnov.nntu.vst.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nnov.nntu.vst.demo.dto.UserDTO;
import ru.nnov.nntu.vst.demo.models.EUser;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EUserJPARepository extends JpaRepository<EUser, Long> {
    @Query(value = "SELECT u FROM EUser u")
    public List<EUser> findAllUsersWithQueryAnnotation();

    @Query(value = "SELECT u FROM EUser u WHERE u.name = ?1")
    public Optional<List<EUser>> findUsersByName(String name);

    @Query(value = "SELECT u FROM EUser u LEFT JOIN u.userType")
    public List<EUser> findAllUsersWithUserType();
}