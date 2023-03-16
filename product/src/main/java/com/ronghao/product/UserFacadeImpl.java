package com.ronghao.product;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ronghao.common.vo.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class UserFacadeImpl implements UserFacade {

    @Autowired
    private RestTemplate restTemplate = null;

    @Override
//    @HystrixCommand(fallbackMethod = "fallback1")
    public ResultMessage timeout() {
        String url = "http://USER/hystrix/timeout";
        return restTemplate.getForObject(url, ResultMessage.class);

    }

    @Override
//    @HystrixCommand(fallbackMethod = "fallback2")
    public ResultMessage exp(String msg) {
        String url = "http://USER/hystrix/exp/{msg}";
        return restTemplate.getForObject(url, ResultMessage.class, msg);
    }

    public ResultMessage fallback1() {
        return new ResultMessage(false, "超时了");
    }

    public ResultMessage fallback2(String msg) {
        return new ResultMessage(false, "调用产生异常了，参数：" + msg);
    }
}