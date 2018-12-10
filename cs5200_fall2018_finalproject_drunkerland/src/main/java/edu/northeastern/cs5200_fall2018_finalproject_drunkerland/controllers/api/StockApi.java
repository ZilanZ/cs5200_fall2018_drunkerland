package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;

@RequestMapping("rest/api/stock")
public interface StockApi {
	
	
	/**
	 * create stock
	 * @param stock
	 * @return
	 */
	 @RequestMapping(method = RequestMethod.POST)
	 Stock createStock(@RequestBody Stock stock);
	 
	 
	 /**
	  * retrieve all stocks
	  * @return
	  */
	 @RequestMapping(method = RequestMethod.GET)
	 List<Stock> findAllStocks();
	 
	 
	 /**
	  * retrieve stock by stock id
	  * @param id
	  * @return
	  */
	 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	 Stock findStockById(@PathVariable int id);
	 
	 
	 /**
	  * retrieve stock which is or is not available
	  * @param available
	  * @return
	  */
	 @RequestMapping(value = "/available", method = RequestMethod.GET)
	 List<Stock> findStocksByAvailable(@RequestParam("available") Boolean available);
	 
	 
	 /**
	  * retrieve stock by vendor
	  * @param vendor
	  * @return
	  */
	 @RequestMapping(value = "/vendor", method = RequestMethod.POST)
	 List<Stock> findStocksByVendor(@RequestBody Vendor vendor);
	 
	 
	 /**
	  * retrieve stock by wine
	  * @param wine
	  * @return
	  */
	 @RequestMapping(value = "/wine", method = RequestMethod.POST)
	 List<Stock> findStocksByWine(@RequestBody Wine wine);
	 
	 
	 /**
	  * delete stock by id
	  * @param id
	  */
	 @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	 void deleteStockById(@PathVariable("id") int id);
	 
	 
	 /**
	  * update stock by id
	  * @param id
	  * @param newStock
	  * @return
	  */
	 @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	 Stock updateStockById(@PathVariable("id") int id, @RequestBody Stock newStock);

}
