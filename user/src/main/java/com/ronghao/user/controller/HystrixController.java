package com.ronghao.user.controller;

import com.ronghao.common.vo.ResultMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {
    private static Long MAX_SLEEP_TIME = 5000L;

    @GetMapping("/timeout")
    public ResultMessage timeout() {
        Long sleeptime = (long) (MAX_SLEEP_TIME * Math.random());
        try {
            Thread.sleep(sleeptime);
        } catch (Exception e) {
            System.out.println("执行异常");
        }
        return new ResultMessage(true, "执行时间" + sleeptime);
    }

    @GetMapping("/exp/{msg}")
    public ResultMessage exp(@PathVariable("msg") String msg) {
        if ("spring".equals(msg)) {
            return new ResultMessage(true, msg);
        } else {
            throw new RuntimeException("出现异常，请检查参数msg是否为Spring");
        }
    }
}