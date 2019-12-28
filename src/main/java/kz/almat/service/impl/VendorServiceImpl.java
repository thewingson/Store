package kz.almat.service.impl;

import kz.almat.model.Vendor;
import kz.almat.repo.VendorRepo;
import kz.almat.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

    @Autowired
    private VendorRepo vendorRepo;

    public List<Vendor> getAll() {
        return vendorRepo.getAll();
    }

    public Vendor getById(Long id) {
        return vendorRepo.getById(id);
    }

    public void add(Vendor vendor) {
        vendorRepo.save(vendor);
    }

    public void delete(Long id) {
        vendorRepo.delete(id);
    }

    public void edit(Vendor vendor) {
        vendorRepo.update(vendor);
    }
}
