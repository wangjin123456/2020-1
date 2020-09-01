package com.taotao.datasources_ds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"com.taotao.datasources_ds.stock.mapper","com.taotao.datasources_ds.order.mapper"})
@SpringBootApplication
public class DatasourcesDsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatasourcesDsApplication.class, args);
    }

}
