package kz.almat.repo;

import kz.almat.model.Vendor;

import java.util.List;

public interface VendorRepo {

    Vendor getById(Long id);

    List<Vendor> getAll();

    void save(Vendor vendor);

    void delete(Long id);

    void update(Vendor vendor);

}
