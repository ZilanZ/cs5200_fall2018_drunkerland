package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RequestMapping("rest/api/suppliers")
public interface SupplierApi {

    /**
     * create supplier
     * @param supplier
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    Supplier createSupplier(@RequestBody Supplier supplier);

    /**
     * retrieve all suppliers
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Supplier> findAllSuppliers();

    /**
     * retrieve supplier by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Supplier findSupplierById(@PathVariable int id);

    /**
     * retrieve supplier by name
     * @param name
     * @return
     */
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    List<Supplier> findSupplierByName(@RequestParam("name") String name);

    /**
     * supplier authentication: retrieve supplier by credential
     * @param supplier
     * @return
     */
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    Supplier findSupplierByCredential(@RequestBody Supplier supplier);

    /**
     * delete supplier by id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteSupplierById(@PathVariable("id") int id);

    /**
     * update supplier by id
     * @param id
     * @param newSupplier
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Supplier updateSupplierById(@PathVariable("id") int id, @RequestBody Supplier newSupplier);

    /**
     * add a wine to a supplier
     * @param sId
     * @param wId
     * @return
     */
    @RequestMapping(value = "/{sId}/wine/{wId}", method = RequestMethod.PUT)
    Supplier addWinesForSupplier(@PathVariable("sId") int sId, @PathVariable("wId") int wId);
}
