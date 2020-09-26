package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Device;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceDto {

    private Long id;

    private String name;

    private String dimension;

    private double price;

    private String note;

    public Device toDevice() {
        Device device= new Device();
        device.setId(id);
        device.setName(name);
        device.setDimension(dimension);
        device.setPrice(price);
        device.setNote(note);
        return device;
    }

    public static DeviceDto fromDevice(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        deviceDto.setId(device.getId());
        deviceDto.setName(device.getName());
        deviceDto.setDimension(device.getDimension());
        deviceDto.setPrice(device.getPrice());
        deviceDto.setNote(device.getNote());
        return deviceDto;
    }

    public static List<DeviceDto> deviceDtoList(List<Device> devices) {
        List<DeviceDto> deviceDtoList = new ArrayList<>();
        devices.forEach(device -> deviceDtoList.add(fromDevice(device)));
        return deviceDtoList;
    }
}
