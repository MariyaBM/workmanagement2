package com.smart.workmanagement.service;

import com.smart.workmanagement.model.Material;

import java.util.List;

public interface MaterialService {

    List<Material> getAllMaterial();

    Material getById(Long id);

    void create(Material material);

    void delete(Long id);
}
