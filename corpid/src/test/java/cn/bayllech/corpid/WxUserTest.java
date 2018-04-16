package cn.bayllech.corpid;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpDepartmentService;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.api.WxCpUserService;
import me.chanjar.weixin.cp.bean.WxCpDepart;
import me.chanjar.weixin.cp.bean.WxCpUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

    @Test
    public void message() {
        /*String msgSignature = request.getParameter("msg_signature");
        String nonce = request.getParameter("nonce");
        String timestamp = request.getParameter("timestamp");
        String echostr = request.getParameter("echostr");

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        if (StringUtils.isNotBlank(echostr)) {
            if (!wxCpService.checkSignature(msgSignature, timestamp, nonce, echostr)) {
                // 消息签名不正确，说明不是公众平台发过来的消息
                response.getWriter().println("非法请求");
                return;
            }
            WxCpCryptUtil cryptUtil = new WxCpCryptUtil(wxCpConfigStorage);
            String plainText = cryptUtil.decrypt(echostr);
            // 企业号应用在开启回调模式的时候，会传递加密echostr给服务器，需要解密并echo才能接入成功
            response.getWriter().println(plainText);
            return;
        }

// 如果没有echostr，则说明传递过来的用户消息，在解密方法里会自动验证消息是否合法
        WxCpXmlMessage inMessage = WxCpXmlMessage.fromEncryptedXml(request.getInputStream(), wxCpConfigStorage, timestamp, nonce, msgSignature);

        WxCpXmlOutMessage outMessage = wxCpMessageRouter.route(inMessage);

        if (outMessage != null) {
            // 将需要同步回复的消息加密，然后再返回给微信平台
            response.getWriter().write(outMessage.toEncryptedXml(wxCpConfigStorage));
        }*/
    }

    @Test
    public void departTest() throws WxErrorException {
        WxCpDepartmentService wxCpDepartmentService = wxCpService.getDepartmentService();
        List<WxCpDepart> departList = wxCpDepartmentService.list(null);
        for (WxCpDepart wxCpDepart : departList) {
            System.out.println(wxCpDepart);
        }
    }

}
