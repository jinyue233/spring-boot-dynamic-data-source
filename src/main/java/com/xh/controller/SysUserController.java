package com.xh.controller;


import com.xh.datasource.CurDataSource;
import com.xh.datasource.DataSourceNames;
import com.xh.entity.SysUser;
import com.xh.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author xiaohe
 * @since 2019-06-04
 */
@RestController
@RequestMapping("/sys-user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/db1/{id}")
    @CurDataSource(name = DataSourceNames.FIRST)
    SysUser findUserByFirstDb(@PathVariable long id) {
        return sysUserService.findUserByFirstDb(id);
    }

    @GetMapping("/db2/{id}")
    @CurDataSource(name = DataSourceNames.SECOND)
    SysUser findUserBySecondDb(@PathVariable long id) {
        return sysUserService.findUserBySecondDb(id);
    }

    @GetMapping("/db1/insertUser")
    @CurDataSource(name = DataSourceNames.FIRST)
    public void inserUserByFirstDb() {
        SysUser user = new SysUser(7711L, "111", "111", "111", "111",
                "111",1,111L, null);
        sysUserService.inserUserByFirstDb(user);
    }

    @GetMapping("/db2/insertUser")
    @CurDataSource(name = DataSourceNames.SECOND)
    public void inserUserBySecondDb() {
        SysUser user = new SysUser(772L, "222", "222", "222", "222",
                "222",2,222L, null);
        sysUserService.inserUserBySecondDb(user);
    }

    @GetMapping("/db/findAllUsers")
    public List<SysUser> findAllUsers() {

        List<SysUser> sysUsers = new ArrayList<>();
        sysUsers.addAll(sysUserService.findAllUsersByFirstDb());
        sysUsers.addAll(sysUserService.findAllUsersBySecondDb());
        return sysUsers;

        // return sysUserService.findAllUsers();
    }

    @GetMapping("/db/findAllUser2")
    public List<SysUser> findAllUsers2() {
        List<SysUser> sysUsers = new ArrayList<>();
        sysUsers.addAll(sysUserService.findAllUsersByFirstDb());
        sysUsers.addAll(sysUserService.findAllUsersBySecondDb());
        return sysUsers;
    }
}
