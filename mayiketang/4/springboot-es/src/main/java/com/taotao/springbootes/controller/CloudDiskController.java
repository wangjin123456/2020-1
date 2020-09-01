package com.taotao.springbootes.controller;

import com.google.common.collect.Lists;
import com.taotao.springbootes.dao.CloudDiskDao;
import com.taotao.springbootes.entity.CloudDiskEntity;
import com.taotao.springbootes.entity.UserEntity;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 *@author tom
 *Date  2020/5/30 0030 9:33
 *
 */
@RestController
public class CloudDiskController {
 @Autowired
 private CloudDiskDao cloudDiskDao;
@RequestMapping("/findById/{id}")
 public Optional<CloudDiskEntity> findById(@PathVariable String id){
     return   cloudDiskDao.findById(id);
 }
    @RequestMapping("/addUser1")
    public CloudDiskEntity addUser1(CloudDiskEntity cloudDiskEntity){
        return cloudDiskDao.save(cloudDiskEntity);
    }

    @RequestMapping("/search")
    public List<CloudDiskEntity> search(String key){
    //查询所有
        BoolQueryBuilder boolQueryBuilder= QueryBuilders.boolQuery();
       if(!Strings.isEmpty(key)){
                   //模糊查询一定要查中文
           MatchQueryBuilder matchQueryBuilder=QueryBuilders.matchQuery("name",key);
           boolQueryBuilder.must(matchQueryBuilder);
       }
        Iterable<CloudDiskEntity> search=cloudDiskDao.search(boolQueryBuilder);
        return Lists.newArrayList(search);
    }
}
