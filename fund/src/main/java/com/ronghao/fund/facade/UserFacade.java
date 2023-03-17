package com.ronghao.fund.facade;

import com.ronghao.common.vo.ResultMessage;
import com.ronghao.common.vo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@FeignClient("user")
public interface UserFacade {

    @GetMapping("/user/info/{id}")
    UserInfo getUser(@PathVariable("id") Long id);

    @PutMapping("/user/info")
    UserInfo putUser(@RequestBody UserInfo userInfo);

    /**
     * 根据id数组获取用户列表
     * @param ids -- 数组
     * @return 用户列表
     */
    @GetMapping("/user/infoes2")
    public ResponseEntity<List<UserInfo>> findUsers2(
            // @RequestParam代表请求参数
            @RequestParam("ids") Long []ids);

    /**
     * 删除用户信息，使用请求头传参
     * @param id -- 用户编号
     * @return 成败结果
     */
    @DeleteMapping("/user/info")
    public ResultMessage deleteUser(
            // @RequestHeader代表请求头传参
            @RequestHeader("id") Long id);

    /**
     * 传递文件流
     * @param file -- 文件流
     * @return 成败结果
     */
    @RequestMapping(value = "/user/upload",
            // MediaType.MULTIPART_FORM_DATA_VALUE
            // 说明提交一个"multipart/form-data"类型的表单
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultMessage uploadFile(
            // @RequestPart代表传递文件流
            @RequestPart("file") MultipartFile file);

}
