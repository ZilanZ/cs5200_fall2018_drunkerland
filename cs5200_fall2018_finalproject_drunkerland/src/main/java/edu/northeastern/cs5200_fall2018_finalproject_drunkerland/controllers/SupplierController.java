package edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers;

import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.controllers.api.SupplierApi;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Supplier;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.models.Wine;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.SupplierRepository;
import edu.northeastern.cs5200_fall2018_finalproject_drunkerland.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupplierController implements SupplierApi {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    WineController wineController;

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public List<Supplier> findAllSuppliers() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    public Supplier findSupplierById(int id) {
        return supplierRepository.findById(id).orElse(null);
    }

    public List<Supplier> findSupplierByName(String name) {
        String[] names = name.split(" ");
        return supplierRepository.findSupplierByName(names[0], names[1]);
    }

    public Supplier findSupplierByCredential(Supplier supplier) {
        return supplierRepository.findSupplierByCredential(supplier.getUsername(), supplier.getPassword());
    }

    public void deleteSupplierById(int id) {
        supplierRepository.deleteById(id);
    }

    public Supplier updateSupplierById(int id, Supplier newSupplier) {
        Supplier supplier = findSupplierById(id);
        supplier.setSupplier(newSupplier);
        return supplierRepository.save(supplier);
    }

    public Supplier addWinesForSupplier( int sId, int wId) {

        Supplier supplier = findSupplierById(sId);
        Wine wine = wineController.findWineById(wId);
        supplier.addWine(wine);
        return supplierRepository.save(supplier);
    }
}
