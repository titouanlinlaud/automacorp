package com.emse.automacorp.dao;

import com.emse.automacorp.model.WindowEntity;
import java.util.List;



public interface WindowDaoCustom {
    List<WindowEntity> findRoomsWithOpenWindows(Long id);
}


