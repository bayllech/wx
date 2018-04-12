package cn.bayllech.corpid;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpUserService;
import me.chanjar.weixin.cp.bean.WxCpUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bei.qi
 * @date 2018/4/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WxUserTest {

    @Autowired
    private WxCpService wxCpService;

    @Test
    public void createdUserTest() throws WxErrorException {
        WxCpUserService wxCpUserService = wxCpService.getUserService();
        WxCpUser user = new WxCpUser();
        user.setUserId("2");
        user.setName("测试1");
        user.setDepartIds(new Integer[] { 4 });
//        user.setEmail("demo.user@ddd.com");
//        user.setGender(WxCpUser.Gender.FEMALE);
        user.setMobile("13011908977");
//        user.setPosition("userPosition");
//        user.setTelephone("021-556987");
//        user.addExtAttr("爱好", "旅游");
        wxCpUserService.create(user);

//        List<WxCpUser> list = wxCpUserService.listByDepartment(1,true,0);
//        for (WxCpUser wxCpUser : list) {
//            System.out.println(wxCpUser);
//        }
    }

}
