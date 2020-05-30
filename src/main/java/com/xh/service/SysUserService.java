package com.xh.service;

import com.xh.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author xiaohe
 * @since 2019-06-04
 */
public interface SysUserService extends IService<SysUser> {

    SysUser findUserByFirstDb(long id);

    SysUser findUserBySecondDb(long id);

    void inserUserByFirstDb(SysUser user);

    void inserUserBySecondDb(SysUser user);

    List<SysUser> findAllUsers();

    List<SysUser> findAllUsersByFirstDb();

    List<SysUser> findAllUsersBySecondDb();

}
