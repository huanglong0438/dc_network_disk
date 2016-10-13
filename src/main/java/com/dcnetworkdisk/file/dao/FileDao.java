package com.dcnetworkdisk.file.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dcnetworkdisk.common.dao.DcRepository;
import com.dcnetworkdisk.file.model.DcFile;

@Repository
public interface FileDao extends DcRepository<DcFile, String>{

	public List<DcFile> findByOwnerName(String ownerName);
	
	public List<DcFile> findByOwnerNameAndFilepath(String ownerName, String path);
	
	public List<DcFile> findByOwnerNameAndFilenameAndFilepath(String ownerName, String filename, String filepath);
	
	@Query(value="select * from t_file_list where ownerName=?1 and filepath=?2 orderBy ?3 ?4 limit ?5,?6", nativeQuery=true)
	public List<DcFile> getSubFilelist(String ownerName, String path, String orderBy, String by, int from, int length);
	
	@Query(value="select * from t_file_list where ownerName=:ownerName and filepath =:path order by :orderBy :by", nativeQuery=true)
	public List<DcFile> getAllFilelist(@Param("ownerName") String ownerName,@Param("path") String path,@Param("orderBy") String orderBy,@Param("by") String by);
	
}
