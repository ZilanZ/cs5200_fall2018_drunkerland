package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.AddressApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Address;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.AddressRepository;

@RestController
public class AddressController implements AddressApi{
	
	@Autowired
	AddressRepository addressRepository;

	@Override
	public Address createAddress(Address address) {
		
		return addressRepository.save(address);
	}

	@Override
	public List<Address> findAllAddresses() {
		
		return (List<Address>) addressRepository.findAll();
	}

	@Override
	public Address findAddressById(int id) {
		
		return addressRepository.findById(id).orElse(null);
	}

	@Override
	public List<Address> findAddressesByUser(User user) {
		
		return addressRepository.findAddressesByUser(user);
	}

	@Override
	public void deleteAddressById(int id) {
		addressRepository.deleteById(id);
		
	}

	@Override
	public Address updateAddressById(int id, Address newAddress) {
		Address address = findAddressById(id);
		address.set(newAddress);
		return addressRepository.save(address);
	}

}
