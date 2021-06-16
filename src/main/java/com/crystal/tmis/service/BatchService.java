package com.crystal.tmis.service;
import com.crystal.tmis.entity.Batch;

import java.util.List;

public interface BatchService {
    List<Batch> getAllBatch();
    Batch getBatchByID(Long id);
    void saveBatch(Batch batch);
    List<Batch> getBatchesByCourse(Long id);
}
