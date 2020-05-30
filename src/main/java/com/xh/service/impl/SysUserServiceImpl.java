package com.xh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xh.datasource.CurDataSource;
import com.xh.datasource.DataSourceNames;
import com.xh.entity.SysUser;
import com.xh.mapper.SysUserMapper;
import com.xh.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author xiaohe
 * @since 2019-06-04
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public SysUser findUserByFirstDb(long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    public SysUser findUserBySecondDb(long id) {
        return this.baseMapper.selectById(id);
    }

    public List<SysUser> findAllUsers() {
        List<SysUser> sysUsers = new ArrayList<>();
        sysUsers.addAll(findAllUsersByFirstDb());
        sysUsers.addAll(findAllUsersBySecondDb());
        return sysUsers;
    }

    @CurDataSource(name = DataSourceNames.FIRST)
    public List<SysUser> findAllUsersByFirstDb() {
        return this.baseMapper.selectByMap(new HashMap<>());
    }

    @CurDataSource(name = DataSourceNames.SECOND)
    public List<SysUser> findAllUsersBySecondDb() {
        return this.baseMapper.selectByMap(new HashMap<>());
    }

    @Transactional
    @Override
    public void inserUserByFirstDb(SysUser user) {

        this.baseMapper.insert(user);
        /*int i = 1 / 0;*/
    }

    @Transactional
    @Override
    public void inserUserBySecondDb(SysUser user) {
        this.baseMapper.insert(user);
    }

}
