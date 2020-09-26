package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Material;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MaterialDto {

    private Long id;

    private String name;

    private String dimension;

    private double price;

    private String note;

    public Material toMaterial() {
        Material material = new Material();
        material.setId(id);
        material.setName(name);
        material.setDimension(dimension);
        material.setPrice(price);
        material.setNote(note);
        return material;
    }

    public static MaterialDto fromMaterial(Material material) {
        MaterialDto materialDto = new MaterialDto();
        materialDto.setId(material.getId());
        materialDto.setName(material.getName());
        materialDto.setDimension(material.getDimension());
        materialDto.setPrice(material.getPrice());
        materialDto.setNote(material.getNote());
        return materialDto;
    }

    public static List<MaterialDto> materialDtoList(List<Material> materials) {
        List<MaterialDto> materialDtoList = new ArrayList<>();
        materials.forEach(material -> materialDtoList.add(fromMaterial(material)));
        return materialDtoList;
    }

}
