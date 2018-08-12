package com.MHE_Project.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
 

@Repository
public interface MHE_SensorDataRepository extends JpaRepository<MHE_SensorData, Long> {
	
	@Query("SELECT s FROM MHE_SensorData s WHERE s.MAC LIKE %:MAC ORDER BY s.id ASC")
	List<MHE_SensorData> findByMAC(@Param("MAC") String q);
	
	@Query("SELECT s FROM MHE_SensorData s WHERE s.UID=:UID ORDER BY s.id ASC")
	List<MHE_SensorData> findByID(@Param("UID") String q2);
	
	@Query("SELECT s FROM MHE_SensorData s WHERE s.time=:TIME ORDER BY s.id ASC")
	List<MHE_SensorData> findByTIME(@Param("TIME") String q3); 
	
	@Query("SELECT s FROM MHE_SensorData s WHERE s.time BETWEEN (:TIMEP1) AND (:TIMEP2) ORDER BY s.id ASC")
	List<MHE_SensorData> findByPERIOD(@Param("TIMEP1") String q4, @Param("TIMEP2") String q5);
	
	@Query("SELECT s FROM MHE_SensorData s WHERE s.MAC LIKE %:MAC AND s.UID=:UID AND s.time BETWEEN (:TIMEP1) AND (:TIMEP2)")
	List<MHE_SensorData> findByALL(@Param("MAC") String q,@Param("UID") String q2, @Param("TIMEP1") String q4, @Param("TIMEP2") String q5);

	@Query("SELECT s FROM MHE_SensorData s WHERE s.MAC LIKE %:MAC AND s.time BETWEEN (:TIMEP1) AND (:TIMEP2)")
	List<MHE_SensorData> findByMACPERIOD(@Param("MAC") String q,@Param("TIMEP1") String q4, @Param("TIMEP2") String q5);
	
	@Query("SELECT s FROM MHE_SensorData s WHERE s.MAC LIKE %:MAC AND s.UID=:UID")
	List<MHE_SensorData> findByMACID(@Param("MAC") String q,@Param("UID") String q2);
	
	@Query("SELECT s FROM MHE_SensorData s WHERE s.UID=:UID AND s.time BETWEEN (:TIMEP1) AND (:TIMEP2)")
	List<MHE_SensorData> findByIDPERIOD(@Param("UID") String q2, @Param("TIMEP1") String q4, @Param("TIMEP2") String q5);
	
}

