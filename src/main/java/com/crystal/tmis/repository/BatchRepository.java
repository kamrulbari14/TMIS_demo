package com.crystal.tmis.repository;

import com.crystal.tmis.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query(value = "SELECT * FROM BATCH u WHERE u.course_id = :theId",
            nativeQuery = true)
    List<Batch> findBatchesByCourse(@Param("theId") Long theId);
}
