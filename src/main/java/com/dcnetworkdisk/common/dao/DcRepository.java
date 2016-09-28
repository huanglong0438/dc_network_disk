package com.dcnetworkdisk.common.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface DcRepository<T, ID extends Serializable> extends CrudRepository<T, ID>, JpaSpecificationExecutor<T>{

}
