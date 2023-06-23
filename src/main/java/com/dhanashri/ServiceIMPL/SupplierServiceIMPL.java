package com.dhanashri.ServiceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanashri.Dao.SupplierDao;
import com.dhanashri.entity.Supplier;
import com.dhanashri.Service.SupplierService;

@Service
public class SupplierServiceIMPL implements SupplierService {

	@Autowired
	private SupplierDao dao;

	@Override
	public Boolean addSupplier(Supplier supplier) {
		return dao.addSupplier(supplier);
	}

	@Override
	public Supplier getSupplierById(Long id) {
		return dao.getSupplierById(id);
	}

	@Override
	public Supplier getSupplierByName(String name) {
		return dao.getSupplierByName(name);
	}

	@Override
	public List<Supplier> getAllSupplier() {
		return dao.getAllSupplier();
	}

}
