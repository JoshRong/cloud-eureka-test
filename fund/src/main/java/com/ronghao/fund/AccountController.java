package com.ronghao.fund;

import com.ronghao.common.vo.ResultMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/fund")
public class AccountController {

    @PostMapping("/account/balance/{userId}/{amount}")
    public ResultMessage deductingBalance(@PathVariable("userId") Long userId, @PathVariable("amount") Double amount, HttpServletRequest request) {
        String message = "端口【" + request.getServerPort() + "】扣减成功";
        ResultMessage resultMessage = new ResultMessage(true, message);
        return resultMessage;
    }
}