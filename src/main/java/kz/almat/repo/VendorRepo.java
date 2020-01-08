package kz.almat.repo;

import kz.almat.model.Vendor;

import java.util.List;

public interface VendorRepo {

    Vendor getById(Long id);

    List<Vendor> getAll();

    void delete(Long id);

    void create(Vendor vendor);

    void update(Vendor vendor);



}
