package com.dhanashri.Service;

import java.util.List;

import com.dhanashri.entity.Supplier;

public interface SupplierService {
	public Boolean addSupplier(Supplier supplier);
	public Supplier getSupplierById(Long id);
	public Supplier getSupplierByName(String name);
	public List<Supplier> getAllSupplier();
}
