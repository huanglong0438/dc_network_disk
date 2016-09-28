package com.dcnetworkdisk.common.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;

public class DcRepositoryFactory extends JpaRepositoryFactory{

	private EntityManager entityManager;
	
	public DcRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
	}

	@Override
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(
			RepositoryInformation information, EntityManager entityManager) {
		JpaEntityInformation<?, Serializable> entityInformation = getEntityInformation(information.getDomainType());
		return new DcRepositoryImpl(entityInformation, entityManager);
	}
	
	
}
