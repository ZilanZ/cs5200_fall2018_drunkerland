package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;


import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
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
    @RequestMapping(value = "/name", method = RequestMethod.GET)
    Wine findWineByName(@RequestParam("name") String name);

    /**
     * retrieve wine by vintage
     * @param vintage
     * @return
     */
    @RequestMapping(value = "/vintage", method = RequestMethod.GET)
    Wine findWineByVintage(@RequestParam("vintage") String vintage);

    /**
     * retrieve wine by color
     * @param color
     * @return
     */
    @RequestMapping(value = "/color", method = RequestMethod.GET)
    Wine findWineByColor(@RequestParam("color") String color);

    /**
     * retrieve wine by region
     * @param region
     * @return
     */
    @RequestMapping(value = "/region", method = RequestMethod.GET)
    Wine findWineByRegion(@RequestParam("region") String region);

    /**
     * retrieve wine by appellation
     * @param appellation
     * @return
     */
    @RequestMapping(value = "/appellation", method = RequestMethod.GET)
    Wine findWineByAppellation(@RequestParam("appellation") String appellation);

    /**
     * retrieve wine by country
     * @param country
     * @return
     */
    @RequestMapping(value = "/country", method = RequestMethod.GET)
    Wine findWineByCountry(@RequestParam("country") String country);


    /**
     * retrieve wine by score
     * @param score
     * @return
     */
    @RequestMapping(value = "/score", method = RequestMethod.GET)
    Wine findWineByScore(@RequestParam("score") String score);

    /**
     * retrieve wine by date
     * @param date
     * @return
     */
    @RequestMapping(value = "/date", method = RequestMethod.GET)
    Wine findWineByDate(@RequestParam("date") String date);

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
}