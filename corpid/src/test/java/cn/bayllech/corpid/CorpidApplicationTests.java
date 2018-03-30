package cn.bayllech.corpid;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CorpidApplicationTests {

    Logger logger = LoggerFactory.getLogger(CorpidApplicationTests.class);

    @Autowired
    WxCpService service;

    @Test
    public void contextLoads() throws IOException, WxErrorException {
        /*WxCpInMemoryConfigStorage config = new WxCpInMemoryConfigStorage();
        config.setCorpId("...");      // 设置微信企业号的appid
        config.setCorpSecret("...");  // 设置微信企业号的app corpSecret
        config.setAgentId("...");     // 设置微信企业号应用ID
        config.setToken("...");       // 设置微信企业号应用的token
        config.setAesKey("...");      // 设置微信企业号应用的EncodingAESKey

        WxCpServiceImpl wxCpService = new WxCpServiceImpl();
        wxCpService.setWxCpConfigStorage(config);

        String userId = "...";
        WxCpMessage message = WxCpMessage.TEXT().agentId("...").toUser(userId).content("Hello World").build();
        wxCpService.messageSend(message);*/

        /*OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=wxbd4ffb1ca4a804de&corpsecret=ZFH8vO4J2Gd1dSv5ckg_D7PkhtFuVB4ewPFU78uYLQ4")
                .build();
        Response response = httpClient.newCall(request).execute();

        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);*/

		/*Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        System.out.println(response.body().string());*/
//        Map<String, Object> map = (Map<String, Object>) JSON.parse(response.body().string());
        /*Map<String, Object> map = JSON.parseObject(response.body().string());
        if (map.containsKey("access_token")) {
            System.out.println("AccessToken: " + map.get("access_token"));
        } else {
            logger.error("获取微信AccessToken异常:{}", map.get("errcode"));
        }*/
        /*String data = "{\n" +
                "   \"touser\" : \"bayllech\",\n" +
                "   \"msgtype\" : \"text\",\n" +
                "   \"agentid\" : 1,\n" +
                "   \"text\" : {\n" +
                "       \"content\" : \"你的快递已到，请携带工卡前往邮件中心领取。\\n出发前可查看<a href=\\\"http://work.weixin.qq.com\\\">邮件中心视频实况</a>，聪明避开排队。\"\n" +
                "   },\n" +
                "   \"safe\":0\n" +
                "}";

        String result = service.post("https://qyapi.weixin.qq.com/cgi-bin/message/send", data);
        System.out.println(result);*/


    }

}
