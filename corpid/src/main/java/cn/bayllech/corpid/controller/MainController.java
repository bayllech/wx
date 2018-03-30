package cn.bayllech.corpid.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2018/3/29
 */

@RestController
@RequestMapping
public class MainController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    WxCpService service;

    @RequestMapping
    public String index() throws WxErrorException {
        System.out.println(service.getAccessToken());

        String userId = "bayllech";
        WxCpMessage message = WxCpMessage.TEXT().agentId(service.getWxCpConfigStorage().getAgentId()).toUser(userId).content("Hello World").build();
        service.messageSend(message);

        logger.debug("Access_token: {}",service.getAccessToken());
        return service.getAccessToken();
    }
}
