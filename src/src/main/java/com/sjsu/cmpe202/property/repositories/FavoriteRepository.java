package com.sjsu.cmpe202.property.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.sjsu.cmpe202.search.retail.listing.model.Favorite;

/*
 * Author: Atanu Ghosh
 */

public interface FavoriteRepository extends CrudRepository<Favorite, Long>, JpaRepository<Favorite, Long>, JpaSpecificationExecutor<Favorite> {
}