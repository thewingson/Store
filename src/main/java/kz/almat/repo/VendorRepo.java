package kz.almat.repo;

import kz.almat.model.Vendor;

import java.util.List;

public interface VendorRepo {

    List<Vendor> getAll();
    Vendor getById(Long id);
    void add(Vendor vendor);
    void delete(Vendor vendor);
    void edit(Vendor vendor);

}
