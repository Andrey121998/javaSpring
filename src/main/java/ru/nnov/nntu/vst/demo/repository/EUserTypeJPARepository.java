package ru.nnov.nntu.vst.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nnov.nntu.vst.demo.models.EUser;
import ru.nnov.nntu.vst.demo.models.EUserType;

import java.util.List;

public interface EUserTypeJPARepository extends JpaRepository<EUserType, Long> {


}
