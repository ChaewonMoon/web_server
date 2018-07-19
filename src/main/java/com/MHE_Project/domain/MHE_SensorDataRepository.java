package com.MHE_Project.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MHE_SensorDataRepository extends JpaRepository<MHE_SensorData, Long> {

}
