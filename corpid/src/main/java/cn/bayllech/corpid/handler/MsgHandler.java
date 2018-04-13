package cn.bayllech.corpid.handler;

import cn.bayllech.corpid.builder.TextBuilder;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.cp.api.WxCpService;
import me.chanjar.weixin.cp.bean.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.WxCpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * * @author Binary Wang(https://github.com/binarywang)
 */
@Component
public class MsgHandler extends AbstractHandler {

  @Override
  public WxCpXmlOutMessage handle(WxCpXmlMessage wxMessage,
                                  Map<String, Object> context, WxCpService weixinService,
                                  WxSessionManager sessionManager) {

    if (wxMessage.getMsgType().equals(WxConsts.XmlMsgType.TEXT)) {
      //TODO 可以选择将消息保存到本地
    }

    //TODO 组装回复消息
//    System.out.println("content: " + wxMessage.getContent());
//    String content = "收到信息内容：" + JsonUtils.toJson(wxMessage);
    String content;
    switch (wxMessage.getContent()) {
      case "Hello":
        content = "world!";
        break;
      case "你好":
        content = "我很好，她还还吗";
        break;
      default:
        content = "已收到消息内容：" + wxMessage.getContent();
    }


    return new TextBuilder().build(content, wxMessage, weixinService);

  }

}
