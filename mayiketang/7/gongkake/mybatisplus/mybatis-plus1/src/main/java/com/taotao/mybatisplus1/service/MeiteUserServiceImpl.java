package com.taotao.mybatisplus1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.taotao.mybatisplus1.entity.MeiteUser;
import com.taotao.mybatisplus1.mapper.MeiteUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-06-09
 */
@RestController
public class MeiteUserServiceImpl {

    @Autowired
    public MeiteUserMapper meiteUserMapper;


    /**
     * 根据id查询数据
     * @param userId
     * @return
     */
    @GetMapping("/findByUser")
    public MeiteUser findByUser(Integer userId) {
        MeiteUser meiteUser = meiteUserMapper.selectById(userId);
        return meiteUser;
    }

    /**
     * 插入数据
     * @param user
     * @return
     */
    @GetMapping("/insertUser")
    public String insertUser(MeiteUser user) {
        String result = meiteUserMapper.insert(user) > 0 ? "success" : "fail";
        return result;
    }

    @GetMapping("/queryWrapper")
    public List<MeiteUser> userList(MeiteUser user) {

        QueryWrapper<MeiteUser> queryWrapper = new QueryWrapper<MeiteUser>();
        String userName = user.getUserName();
        //等于
      /*  if (!StringUtils.isEmpty(userName)) {
            queryWrapper.eq("user_name", user.getUserName());
        }*/
        queryWrapper.eq(!StringUtils.isEmpty(user.getUserName()), "user_name", user.getUserName());
        //大于
        queryWrapper.gt(user.getUserAge() != null, "user_age", user.getUserAge());
        //between
        queryWrapper.between("user_age", 1, 34);
        //like
        queryWrapper.like(!StringUtils.isEmpty(user.getUserAddres()), "user_addres", user.getUserAddres());
        //in
        //orderbyDesc
        queryWrapper.orderByDesc("create_time");
        queryWrapper.orderByDesc("user_age");
        List<MeiteUser> userList = meiteUserMapper.selectList(queryWrapper);
        return userList;
    }

    /**
     * 多条件修改
     * @param user
     * @return
     */
    @GetMapping("/updateUserWrapper")
    public synchronized String updateUserWrapper(MeiteUser user) {
        UpdateWrapper<MeiteUser> userUpdateWrapper = new UpdateWrapper<>();

        Integer userAge = user.getUserAge();
        if (userAge != null) {
            userUpdateWrapper.eq("user_age", userAge);
        }
        return meiteUserMapper.update(user, userUpdateWrapper) > 0 ? "success" : "fail";
    }

    /**
     * 逻辑删除
     * @param userId
     * @return
     */

    @GetMapping("/deleteById")
    public String deleteById(Integer userId) {
        return meiteUserMapper.deleteById(userId) > 0 ? "success" : "fail";
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @GetMapping("/findByPageUserList")
    public List<MeiteUser> findByPageUserList(Page<MeiteUser> page) {
        QueryWrapper<MeiteUser> userQueryWrapper = new QueryWrapper<>();
        Page<MeiteUser> pageResult = meiteUserMapper.selectPage(page, userQueryWrapper);
        return pageResult.getRecords();

    }


    /**
     * 乐观锁
     *
     * @return
     */
    @GetMapping("/optimisticLockUser")
    public String optimisticLock(MeiteUser userEntity) {
        long userId =userEntity.getUserId();
        // 标记该线程是否修改成功
        Integer resultCount = 0;
        while (resultCount <= 0) {
            // 1.根据userid 查找到对应的VERION版本号码 获取当前数据的版本号码
            MeiteUser dbUserEntity = meiteUserMapper.selectById(userId);
            if (dbUserEntity == null) {
                return "未查询到该用户";
            }
            // 2.做update操作的时候，放入该版本号码  乐观锁
            userEntity.setVersion(dbUserEntity.getVersion());
            resultCount = meiteUserMapper.updateById(userEntity);
        }
        return resultCount > 0 ? "success" : "fail";
    }

}
