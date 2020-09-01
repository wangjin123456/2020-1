package com.mayikt.mtshopservicepay.base;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 *@author tom
 *Date  2020/4/21 0021 9:27
 *
 */
public class MeiteBeanUtils<Dto,Do> {
    /**
     *  dto 转换为Do  工具类
     */
    public  static  <Do>  Do dtoToDo(Object dtoEntity,Class<Do> doClass){
        //判断dto 是否为空
        if(dtoEntity ==null){
            return  null;
        }
        //判断DoClass 是否为空
        if(doClass == null){
            return  null;
        }
        try {
            Do newInstance =doClass.newInstance();
            BeanUtils.copyProperties(dtoEntity,newInstance);
            //Dto 转Do
            return  newInstance;

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return  null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return  null;
        }
    }

    /**
     * do 转 dto
     */
    /**
     * do 转换为Dto 工具类
     */
    public static <Dto> Dto doToDto(Object doEntity, Class<Dto> dtoClass) {
        // 判断dto是否为空!
        if (doEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (dtoClass == null) {
            return null;
        }
        try {
            Dto newInstance = dtoClass.newInstance();
            BeanUtils.copyProperties(doEntity, newInstance);
            // Dto转换Do
            return newInstance;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * do 转换为Dto 工具类
     */
    public static <Dto> List<Dto> doToDtoList(List<?> doEntity, Class<Dto> dtoClass) {
        // 判断dto是否为空!
        if (doEntity == null) {
            return null;
        }
        // 判断DoClass 是否为空
        if (dtoClass == null) {
            return null;
        }
        try {
            List<Dto> objects = new ArrayList<>();
            for (Object object : doEntity) {
                Dto newInstance = dtoClass.newInstance();
                BeanUtils.copyProperties(object, newInstance);
                objects.add(newInstance);
            }
            // Dto转换Do
            return objects;
        } catch (Exception e) {
            return null;
        }
    }

}
