package com.dcnetworkdisk.common.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public class DcRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements DcRepository<T, ID>{

	private final EntityManager entityManager;
	
	public DcRepositoryImpl(final JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

}
