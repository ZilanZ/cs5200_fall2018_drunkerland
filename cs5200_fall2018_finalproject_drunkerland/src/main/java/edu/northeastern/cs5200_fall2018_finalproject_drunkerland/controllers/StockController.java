package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.StockApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.StockRepository;

@RestController
public class StockController implements StockApi{
	
	@Autowired
	StockRepository stockRepository;

	@Override
	public Stock createStock(Stock stock) {
		
		return stockRepository.save(stock);
	}

	@Override
	public List<Stock> findAllStocks() {
		
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock findStockById(int id) {
		
		return stockRepository.findById(id).orElse(null);
	}

	@Override
	public List<Stock> findStocksByAvailable(Boolean available) {
		
		return stockRepository.findStockByAvailable(available);
	}

	@Override
	public List<Stock> findStocksByVendor(Vendor vendor) {
		
		return stockRepository.findStockByVendor(vendor);
	}

	@Override
	public List<Stock> findStocksByWine(Wine wine) {
		
		return stockRepository.findStockByWine(wine);
	}

	@Override
	public void deleteStockById(int id) {
		stockRepository.deleteById(id);
		
	}

	@Override
	public Stock updateStockById(int id, Stock newStock) {
		Stock stock = findStockById(id);
		stock.set(newStock);
		return stockRepository.save(stock);
	}

}
