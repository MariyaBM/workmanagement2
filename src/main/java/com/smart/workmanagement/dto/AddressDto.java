package com.smart.workmanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.smart.workmanagement.model.Address;
import com.smart.workmanagement.model.WorkGroup;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDto {
    private Long id;
    private String name;

    public Address toAddress() {
        Address address = new Address();
        address.setId(id);
        address.setName(name);
        return address;
    }

    public static AddressDto fromAddress(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setName(address.getName());
        return addressDto;
    }

    public static List<AddressDto> addressDtoList(List<Address> addresses) {
        List<AddressDto> addressDtoList = new ArrayList<>();
        addresses.forEach(address -> addressDtoList.add(fromAddress(address)));
        return addressDtoList;
    }


}
