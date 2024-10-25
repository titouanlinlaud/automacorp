package com.emse.automacorp.dao;

import com.emse.automacorp.model.WindowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface WindowDao extends JpaRepository<WindowEntity, Long>, WindowDaoCustom {
}


