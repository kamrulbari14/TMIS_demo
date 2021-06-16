package com.crystal.tmis.service;

import com.crystal.tmis.entity.Batch;
import com.crystal.tmis.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchServiceImpl implements BatchService {

    private BatchRepository batchRepository;

    @Autowired
    public BatchServiceImpl(BatchRepository batchRepository) {
        this.batchRepository = batchRepository;
    }

    @Override
    public List<Batch> getAllBatch() {
        return batchRepository.findAll();
    }

    @Override
    public Batch getBatchByID(Long id) {

        Optional<Batch> result = batchRepository.findById(id);

        Batch batch;

        if (result.isPresent()){
            batch = result.get();
        }

        else {
            throw new RuntimeException("Not Found "+id);
        }

        return batch;
    }

    @Override
    public void saveBatch(Batch batch) {
        batchRepository.save(batch);
    }

    @Override
    public List<Batch> getBatchesByCourse(Long id) {
        return batchRepository.findBatchesByCourse(id);
    }
}
