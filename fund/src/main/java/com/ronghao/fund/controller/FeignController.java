package com.ronghao.fund.controller;

import com.ronghao.common.vo.UserInfo;
import com.ronghao.fund.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private UserFacade userFacade = null;

    @GetMapping("/user/{id}")
    public UserInfo getUser(@PathVariable("id") Long id) {
        UserInfo user = userFacade.getUser(id);
        return user;
    }


    @GetMapping("/user/{id}/{userName}/{note}")
    public UserInfo updatgeUser(@PathVariable("id") Long id,
                                @PathVariable("userName") String userName,
                                @PathVariable("note") String note) {
        UserInfo userInfo = new UserInfo(id, userName, note);
        return userFacade.putUser(userInfo);
    }


}