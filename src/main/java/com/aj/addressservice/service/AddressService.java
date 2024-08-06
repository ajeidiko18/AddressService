package com.aj.addressservice.service;

import com.aj.addressservice.entity.Address;
import com.aj.addressservice.repo.AddressRepo;
import com.aj.addressservice.response.AddressResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;


    public AddressResponse getAddressById(int employeeId) {

        Address address= addressRepo.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(address, AddressResponse.class);

        return addressResponse;


    }


    public List<AddressResponse> getAllAddresses() {

        List<Address> addresses= addressRepo.findAll();
        List<AddressResponse> addressResponses = modelMapper.map(addresses, List.class);

        return addressResponses;
    }
}
