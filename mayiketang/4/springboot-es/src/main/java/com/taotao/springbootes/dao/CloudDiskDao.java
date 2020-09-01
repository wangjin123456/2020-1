package com.taotao.springbootes.dao;


import com.taotao.springbootes.entity.CloudDiskEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @author Administrator
 */
public interface CloudDiskDao extends  ElasticsearchRepository<CloudDiskEntity, String>  {

}
