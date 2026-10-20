package ru.nnov.nntu.vst.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nnov.nntu.vst.demo.models.EUser;

public interface EUserJPARepository extends JpaRepository<EUser, Long> {
}
