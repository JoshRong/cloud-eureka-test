package com.ronghao.product;

import com.ronghao.common.vo.ResultMessage;

public interface UserFacade {
    public ResultMessage timeout();
    public ResultMessage exp(String msg);
}
