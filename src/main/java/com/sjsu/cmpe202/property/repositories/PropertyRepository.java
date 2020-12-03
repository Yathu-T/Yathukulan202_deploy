package com.sjsu.cmpe202.property.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sjsu.cmpe202.search.retail.listing.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*
 * Author: Atanu Ghosh
 */

public interface PropertyRepository extends CrudRepository<Property, Long>, JpaRepository<Property, Long>, JpaSpecificationExecutor<Property> {
}