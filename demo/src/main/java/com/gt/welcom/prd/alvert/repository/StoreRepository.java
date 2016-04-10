package com.gt.welcom.prd.alvert.repository;
import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.gt.welcom.prd.alvert.domain.Store;
public interface StoreRepository
						extends JpaRepository<Store, Long>{

	@Query("select s from Store s where s.storeName = ?1 ")
	public Store findStoreByStoreName(String storeName) throws Exception;
}
