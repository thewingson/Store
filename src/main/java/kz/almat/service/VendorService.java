package kz.almat.service;

import kz.almat.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> getAll();
    Vendor getById(Long id);
    void add(Vendor vendor);
    void delete(Long id);
    void edit(Vendor vendor);

}
