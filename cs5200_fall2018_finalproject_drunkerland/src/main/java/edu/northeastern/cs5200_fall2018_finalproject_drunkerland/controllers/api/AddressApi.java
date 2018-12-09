package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Address;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.User;

@RequestMapping("rest/api/address")
public interface AddressApi {

	
	/**
	 * create address
	 * @param address
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
    Address createAddress(@RequestBody Address address);
	
	
	
	/**
	 * retrieve all addresses
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
    List<Address> findAllAddresses();

	
	
	/**
	 * retrieve address by id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Address findAddressById(@PathVariable int id);
	
	
	
	/**
	 * retrieve addresses by user
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	List<Address> findAddressesByUser(@RequestBody User user);
	
	
	
	/**
	 * delete address by id
	 * @param id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteAddressById(@PathVariable("id") int id);
	
	
	
	/**
	 * update address by id
	 * @param id
	 * @param newAddress
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Address updateAddressById(@PathVariable("id") int id, @RequestBody Address newAddress);
	
}
