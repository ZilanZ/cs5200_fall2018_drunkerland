package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RequestMapping("rest/api/vendors")
public interface VendorApi {

    /**
     * create vendor
     * @param vendor
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    Vendor createVendor(@RequestBody Vendor vendor);

    /**
     * retrieve all vendors
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Vendor> findAllVendors();

    /**
     * retrieve vendor by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Vendor findVendorById(@PathVariable int id);

    /**
     * retrieve vendor by name
     * @param name
     * @return
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    List<Vendor> findVendorByName(@RequestParam("name") String name);

    /**
     * vendor authentication: retrieve vendor by credential
     * @param vendor
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    Vendor findVendorByCredential(@RequestBody Vendor vendor);

    /**
     * delete vendor by id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteVendorById(@PathVariable("id") int id);

    /**
     * update vendor by id
     * @param id
     * @param newVendor
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Vendor updateVendorById(@PathVariable("id") int id, @RequestBody Vendor newVendor);

}
