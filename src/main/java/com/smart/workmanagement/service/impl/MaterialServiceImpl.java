package com.smart.workmanagement.service.impl;

import com.smart.workmanagement.model.Material;
import com.smart.workmanagement.model.Status;
import com.smart.workmanagement.repo.MaterialRepo;
import com.smart.workmanagement.service.MaterialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepo materialRepo;

    @Autowired
    public MaterialServiceImpl(MaterialRepo materialRepo) {
        this.materialRepo = materialRepo;
    }


    @Override
    public List<Material> getAllMaterial() {
        List<Material> materials = materialRepo.findAll();
        log.info("IN getAllMaterials - {} materials found", materials.size());
        return materials;
    }

    @Override
    public Material getById(Long id) {
        Material material = materialRepo.findById(id).orElse(null);
        if (material == null) {
            log.warn("IN findById - no material found by id: {}", id);
            return null;
        }
        log.info("IN findById - material found by id: {}", material);
        return material;
    }

    @Override
    public void create(Material material) {
        material.setCreatedDate(LocalDateTime.now());
        material.setStatus(Status.ACTIVE);
        Material createdMaterial = materialRepo.save(material);
        log.info("IN create - material: {} successfully registered", createdMaterial);

    }

    @Override
    public void delete(Long id) {
        Material material = materialRepo.findById(id).orElse(null);
        if (material == null) {
            log.warn("IN findById - no material found by id: {}", id);
        } else {
            material.setStatus(Status.DELETED);
        }
        materialRepo.deleteById(id);

    }
}
