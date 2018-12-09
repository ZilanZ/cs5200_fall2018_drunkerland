package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StockRepository extends CrudRepository<Stock, Integer>{
	
	@Query(value = "SELECT s FROM Stock s WHERE s.available = :available")
	List<Stock> findStockByAvailable(@Param("available") Boolean available);
	
	@Query(value = "SELECT s FROM Stock s WHERE s.vendor = :vendor")
	List<Stock> findStockByVendor(@Param("vendor") Vendor vendor);
	
	@Query(value = "SELECT s FROM Stock s WHERE s.wine = :wine")
	List<Stock> findStockByWine(@Param("wine") Wine wine);

}
