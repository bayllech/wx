package cn.bayllech.corpid.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Administrator
 * @date 2018/3/29
 */

@Controller
@RequestMapping
public class MainController {

    @RequestMapping
    @ResponseBody
    public String index() {
        return "Hello";
    }
}
