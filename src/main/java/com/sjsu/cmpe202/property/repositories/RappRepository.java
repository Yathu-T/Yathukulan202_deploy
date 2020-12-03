package com.sjsu.cmpe202.property.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import com.sjsu.cmpe202.search.retail.listing.model.Rapp;

public interface RappRepository extends CrudRepository<Rapp, Long>, JpaRepository<Rapp, Long>, JpaSpecificationExecutor<Rapp> {
}
