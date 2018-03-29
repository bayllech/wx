package cn.bayllech.corpid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CorpidApplicationTests {

	@Test
	public void contextLoads() {
		String corpid = "CorpID";
		String secret = "Secret";
		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + corpid + "&corpsecret=" + secret;
		String jsonStr = WeChatHTTPClient.get(url);//发起HTTP请求，获取返回的JSON字符串
		Map<String, Object> map = JSONObject.parseObject(jsonStr);//解析JSON字符串
		String accessToken = map.get("access_token").toString();//获取access_token
	}

}
