package cn.bayllech.corpid.controller;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.cp.api.WxCpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 * @date 2018/3/29
 */

@RestController
@RequestMapping
public class MainController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    private Map<String, String> map = new HashMap<>();

    @Autowired
    private WxCpService service;

    @RequestMapping
    public String index(HttpServletRequest request, HttpServletResponse response) throws WxErrorException, IOException {
        System.out.println(service.getAccessToken());
        return service.getAccessToken();

/*        String userId = "bayllech";
        WxCpMessage message = WxCpMessage.TcEXT().agentId(service.getWxCpConfigStorage().getAgentId()).toUser(userId).content("Hello World").build();
        service.messageSend(message);*/

        /*logger.debug("Access_token: {}",service.getAccessToken());
        return service.getAccessToken();*/
    }

    @RequestMapping("/m/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws WxErrorException {
        ModelAndView modelAndView = new ModelAndView();
        String code = request.getParameter("code");
        String[] res = this.service.getOauth2Service().getUserInfo(code);
        System.out.println("code: " + code);
        System.out.println("res: " + Arrays.toString(res));


        modelAndView.setViewName("index");
        modelAndView.addObject("message","Welcome to Spring Boot & Thymeleaf");
        return modelAndView;
    }

    @RequestMapping("/m/index")
    public void oauth2(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /*WxCpOAuth2Service oAuth2Service = service.getOauth2Service();
        String redirectUri = "http://" + request.getServerName()
                + ":"
                + request.getServerPort()
                + "/m/login";
        System.out.println(redirectUri);
        String url = oAuth2Service.buildAuthorizationUrl(URLEncoder.encode(redirectUri,"utf-8"),"200");
        System.out.println(url);*/

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        String code = request.getParameter("code");
        try {
            response.getWriter().println("<h1>code</h1>");
            response.getWriter().println(code);

            String[] res = this.service.getOauth2Service().getUserInfo(code);
            response.getWriter().println("<h1>result</h1>");
            response.getWriter().println(Arrays.toString(res));
        } catch (WxErrorException e) {
            e.printStackTrace();
        }

        response.getWriter().flush();
        response.getWriter().close();

    }

    @RequestMapping("/index")
    public String login(String username,String password) {
        String result;
        if (map.containsKey(username) && password.equals(map.get(username))) {
            result = "您绑定，无需再次绑定";
        } else {
            map.put(username, password);
            result = "恭喜您，绑定成功";
        }

        return result;
    }
}
