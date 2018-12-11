package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.dto.WineQueryDto;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


/**
 * @PathVariable passing by URL eg. /{id}
 * @RequestParam passing by URL eg. ?key1=value1&key2=value2
 * @RequestBody passing by body [type: (default) json]
 *
 * we use @RestController here, @ResponseBody is not required. default: Json
 */
@RequestMapping("rest/api/wines")
public interface WineApi {

    /**
     * create
     * @param wine
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    Wine createWine(@RequestBody Wine wine);

    /**
     * retrieve all wines
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    List<Wine> findAllWines();

    /**
     * retrieve wine by id
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Wine findWineById(@PathVariable int id);

    /**
     * retrieve wine by name
     * @param name
     * @return
     */
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    List<Wine> findWineByName(@PathVariable("name") String name);

    /**
     * retrieve wine by vintage
     * @param vintage
     * @return
     */
    @RequestMapping( value = "/vintage/{vintage}", method = RequestMethod.GET)
    List<Wine> findWineByVintage(@PathVariable("vintage") String vintage);

    /**
     * retrieve wine by color
     * @param color
     * @return
     */
    @RequestMapping(value = "/color/{color}", method = RequestMethod.GET)
    List<Wine> findWineByColor(@PathVariable("color") String color);


    /**
     * retrieve wine by appellation
     * @param appellation
     * @return
     */
    @RequestMapping(value = "/appellation/{appellation}", method = RequestMethod.GET)
    List<Wine> findWineByAppellation(@PathVariable("appellation") String appellation);

    /**
     * retrieve wine by country
     * @param country
     * @return
     */
    @RequestMapping(value = "/country/{country}", method = RequestMethod.GET)
    List<Wine> findWineByCountry(@PathVariable("country") String country);

    /**
     * retrieve wine by region
     * @param region
     * @return
     */
    @RequestMapping(value = "/region/{region}", method = RequestMethod.GET)
    List<Wine> findWineByRegion(@PathVariable("region") String region);

    /**
     * retrieve wine by score
     * @param scoreScope
     * @return
     */
    @RequestMapping(value = "/score", method = RequestMethod.GET)
    List<Wine> findWineBetweenScore(@RequestParam("scoreScope") String scoreScope);

    /**
     * retrieve wine by date
     * @param startDate
     * @param endDate
     * @return
     */
    @RequestMapping(value = "/date", method = RequestMethod.GET)
    List<Wine> findWineByDate(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate);

    /**
     * delete wine by id
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void deleteWineById(@PathVariable("id") int id);

    /**
     * update wine by id
     * @param id
     * @param newWine
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Wine updateWineById(@PathVariable("id") int id, @RequestBody Wine newWine);

    /**
     * Find the supplier of the wine
     * @param wId
     * @return
     */
    @RequestMapping(value = "/{wId}/supplier", method = RequestMethod.GET)
    Supplier findSupplierForWine(@PathVariable("wId") int wId);

    /**
     * Retrieve wine with multiple search fields
     * @param wineQueryDto
     * @return
     */
    @RequestMapping(value = "/multipleSearch", method = RequestMethod.POST)
    List<Wine> multipleSearch(@RequestBody WineQueryDto wineQueryDto);

    /**
     * retrieve wines by supplier
     * @param supplier
     * @return
     */
    @RequestMapping(value = "/supplier", method = RequestMethod.POST)
    List<Wine> findWinesBySupplier(@RequestBody Supplier supplier);
    
    
    @RequestMapping(value ="/{wId}/supplier/{sId}", method = RequestMethod.PUT)
    Wine setSupplier(@PathVariable("wId") int wId, @PathVariable("sId") int sId);
    
    
    @RequestMapping(value ="/{wId}/stock/{stId}", method = RequestMethod.PUT)
    Wine addStockForWine(@PathVariable("wId") int wId, @PathVariable("stId") int stId);
}
