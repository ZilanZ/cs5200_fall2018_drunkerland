package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.VendorApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Stock;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Vendor;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.StockRepository;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendorController implements VendorApi {

    @Autowired
    VendorRepository vendorRepository;
    @Autowired
    StockRepository stockRepository;
    @Autowired
    StockController stockController;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public List<Vendor> findAllVendors() {
        return (List<Vendor>) vendorRepository.findAll();
    }

    public Vendor findVendorById(int id) {
        return vendorRepository.findById(id).orElse(null);
    }

    public List<Vendor> findVendorByName(String name) {
        String[] names = name.split(" ");
        return vendorRepository.findVendorByName(names[0], names[1]);
    }

    public Vendor findVendorByCredential(Vendor vendor) {
        return vendorRepository.findVendorByCredential(vendor.getUsername(), vendor.getPassword());
    }

    public void deleteVendorById(int id) {
        vendorRepository.deleteById(id);
    }

    public Vendor updateVendorById(int id, Vendor newVendor) {
        Vendor vendor = findVendorById(id);
        vendor.setVendor(newVendor);
        return vendorRepository.save(vendor);
    }

	@Override
	public Vendor addStockForVendor(int vId, int stId) {
		Vendor vendor = findVendorById(vId);
		Stock stock = stockController.findStockById(stId);
		vendor.addStock(stock);
		stock.setVendor(vendor);
		stockRepository.save(stock);
		return vendorRepository.save(vendor);
	}
}
