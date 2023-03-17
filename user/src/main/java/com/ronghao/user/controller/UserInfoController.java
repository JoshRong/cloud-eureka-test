package com.ronghao.user.controller;


import com.ronghao.common.vo.ResultMessage;
import com.ronghao.common.vo.UserInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {

    /**
     * 模拟获取用户信息
     *
     * @param id -- 用户编号
     * @return 用户信息
     */
    @GetMapping("/info/{id}")
    @ResponseBody
    public UserInfo getUser(@PathVariable("id") Long id) {
        UserInfo userInfo = new UserInfo(1L, "user_name_" + id, "note_" + id);
        return userInfo;
    }

    @PutMapping("/info")
    public UserInfo putUser(@RequestBody UserInfo userInfo) {
        return userInfo;
    }

    public ResponseEntity<List<UserInfo>> findUser2(@RequestParam("ids") Long[] ids) {
        List<UserInfo> userInfoList = new ArrayList<>();
        for (Long id : ids) {
            UserInfo userInfo = new UserInfo(id, "user_name_" + id, "note_" + id);
            userInfoList.add(userInfo);
        }
        ResponseEntity<List<UserInfo>> response = new ResponseEntity<>(userInfoList, HttpStatus.OK);
        return response;
    }

    public ResultMessage deleteUSer(@RequestHeader("id") Long id) {
        boolean success = id != null;
        String msg = success ? "传递成功" : "传递失败";
        return new ResultMessage(success, msg);
    }

    public ResultMessage uploadFile(@RequestPart("file") MultipartFile file) {
        boolean success = file != null && file.getSize() > 0;
        String message = success ? "文件传递成功" : "文件传递失败";
        return new ResultMessage(success, message);

    }

}