package com.jhola.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jhola.model.Vendor;

@Repository
public interface VendorRepo extends CrudRepository<Vendor , Long>{

}
