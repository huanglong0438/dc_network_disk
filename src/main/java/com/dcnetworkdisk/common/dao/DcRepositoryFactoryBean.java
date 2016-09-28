package com.dcnetworkdisk.common.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class DcRepositoryFactoryBean <T extends JpaRepository<S, ID>, S, ID extends Serializable>
	extends JpaRepositoryFactoryBean<T, S, ID>{

	@Override
	protected RepositoryFactorySupport createRepositoryFactory(
			EntityManager entityManager) {
		// TODO Auto-generated method stub
		return new DcRepositoryFactory(entityManager);
	}

}
