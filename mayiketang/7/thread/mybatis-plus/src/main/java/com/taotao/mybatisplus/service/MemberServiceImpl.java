package com.taotao.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.taotao.mybatisplus.entity.UserEntity;
import com.taotao.mybatisplus.mapper.UserMapper;
import com.taotao.mybatisplus.utils.TransactionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiPredicate;


/**
 * @ClassName MemberService
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
public class MemberServiceImpl {
    Map<String, String> map = new ConcurrentHashMap<>();
    @Autowired
    public UserMapper userMapper;

    @Autowired
    private TransactionUtils transactionUtils;

    /**
     * findByUser userId
     *
     * @param userId
     * @return
     */
    @GetMapping("/findByUserId")
    public UserEntity findByUser(Integer userId) {
        UserEntity userEntity = userMapper.selectById(userId);
        return userEntity;
    }


    /**
     * 多条件查询
     *
     * @return
     */
    @GetMapping("/findByUserEntityList")
    public List<UserEntity> findByUserEntityList(UserEntity userEntity, Integer startAge, Integer endAge
            , String userIds) {
        // 拼接查询条件的sql语句
        QueryWrapper<UserEntity> queryWrapper = new QueryWrapper<UserEntity>();
        queryWrapper.eq(StringUtils.isNoneEmpty(userEntity.getUserName()), "user_name", userEntity.getUserName());
        //condition  是否需要拼接条件参数
        queryWrapper.gt(userEntity.getUserAge() != null, "user_age", userEntity.getUserAge());
        queryWrapper.between(startAge != null & endAge != null, "user_age", startAge, endAge);
        queryWrapper.like(StringUtils.isNoneEmpty(userEntity.getUserAddres()), "user_addres", userEntity.getUserAddres());
        //in(18,20,20) 18,22,23

        queryWrapper.in(StringUtils.isNoneEmpty(userIds), "user_id",
                StringUtils.isNoneEmpty(userIds) ? userIds.split(",") :
                        null);


        // user_name ?  and user_Age>10
        queryWrapper.orderByDesc("user_age");
        List<UserEntity> userList = userMapper.selectList(queryWrapper);
        return userList;
    }


    /**
     * 增加对象 注意默认的情况下 主键是不会自动增长。
     *
     * @param userEntity
     * @return
     */
    @GetMapping("/insertUser")
    public String insertUser(UserEntity userEntity) {
        TransactionStatus begin = null;
        try {
            begin = transactionUtils.begin();
            String result = userMapper.insert(userEntity) > 0 ? "success" : "fail";
            int j = 1 / userEntity.getUserAge();
            transactionUtils.commit(begin);
        } catch (Exception e) {
            e.printStackTrace();
            if (begin != null)
                transactionUtils.rollback(begin);
        }
        return "success";
    }

    /**
     * 逻辑删除 标记 0（存在）,1（隐藏）
     * <p>
     * SELECT  z在SQL语句后面加上 delete=0
     */

    @GetMapping("/deleteUser")
    public String deleteUser(Long userId) {
        // update set delete=1 where userId=userId

        return userMapper.deleteById(userId) > 0 ? "success" : "fail";
    }

    /**
     * 根据主键id实现修改
     *
     * @param userEntity
     * @return
     */
    @GetMapping("/updateUser")
    public String updateUser(UserEntity userEntity) {
        TransactionStatus begin = transactionUtils.begin();
        // 行锁的机制
        int updatesult = userMapper.updateById(userEntity);
        // 行锁机制如何
//        transactionUtils.commit(begin);
        return updatesult > 0 ? "success" : "fail";
    }

    /**
     * 根据条件修改
     *
     * @param userEntity
     * @return
     */
    @GetMapping("/updateUserWrapper")
    public synchronized String updateUserWrapper(UserEntity userEntity) {
        UpdateWrapper<UserEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq(StringUtils.isNoneEmpty(userEntity.getUserName()), "user_name", userEntity.getUserName());
        return userMapper.update(userEntity, updateWrapper) > 0 ? "success" : "fail";
    }


    /**
     * 分页查询
     *
     * @return
     */
    @GetMapping("/listUser")
    public List<UserEntity> listUser(Page<UserEntity> page) {
        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<>();
        Page<UserEntity> pagelist = userMapper.selectPage(page, userEntityQueryWrapper);
        return pagelist.getRecords();
    }


    /**
     * 乐观锁
     *
     * @return
     */
    @GetMapping("/optimisticLockUser")
    public String optimisticLock(UserEntity userEntity) {
        Long userId = userEntity.getUserId();
        // 标记该线程是否修改成功
        Integer resultCount = 0; //cas 灵活控制超时
        while (resultCount <= 0) {
            // 1.根据userid 查找到对应的VERION版本号码 获取当前数据的版本号码 VERION=1
            UserEntity dbUserEntity = userMapper.selectById(userId);
            if (dbUserEntity == null) {
                return "未查询到该用户";
            }
            // 2.做update操作的时候，放入该版本号码  乐观锁
            userEntity.setVersion(dbUserEntity.getVersion());
            resultCount = userMapper.updateById(userEntity);
        }
        return resultCount > 0 ? "success" : "fail";
    }

    @RequestMapping("/listUserAllEq")
    public List<UserEntity> listUserAllEq(UserEntity userEntity) {

        QueryWrapper<UserEntity> userEntityQueryWrapper = new QueryWrapper<UserEntity>();
        HashMap<String, String> paramsMap = new HashMap<>();
        BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String o) {
                Boolean result = s.indexOf(o) > 0;

                return result;
            }
        };
        paramsMap.put("user_name", userEntity.getUserName());
        biPredicate.test(userEntity.getUserName(), "mayikt");

        userEntityQueryWrapper.allEq(biPredicate, paramsMap);
        List<UserEntity> userEntities = userMapper.selectList(userEntityQueryWrapper);

        return userEntities;
    }

}
