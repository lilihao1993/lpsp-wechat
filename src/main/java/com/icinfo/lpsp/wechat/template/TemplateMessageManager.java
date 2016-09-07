package com.icinfo.lpsp.wechat.template;

import com.icinfo.lpsp.wechat.template.bean.Data;
import com.icinfo.lpsp.wechat.template.bean.Template;
import com.icinfo.lpsp.wechat.template.bean.Templatel;
import com.icinfo.lpsp.wechat.token.TokenManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *描述：模版管理
 */
public class TemplateMessageManager {

    public static void main(String[] args) throws Exception {
            text1(TokenManager.getToken().getAccess_token());
    }

    public static void text1(String access_token)throws Exception{
        //1设置所属行业
//       String hy =  TemplateMessageAPI.setIndustry(access_token,"31","41");
//        System.out.println(hy);

        //2获取设置的行业信息
        String IndustryInfo  = TemplateMessageAPI.getIndustry(access_token);
        System.out.println(IndustryInfo);

        //3获取模版id   此方法测试号不可用
        String templateId = TemplateMessageAPI.getTemplateId(access_token,"TM00041");
        System.out.println(templateId);

        //4获取模版列表
        String templateList = TemplateMessageAPI.getTemplateList(access_token);
        System.out.println(templateList);

        //5发送模版
        Template template = new Template();
        template.setTouser("ohwKTwqOlrW1Z44-MLWPAWfuPlRw");
        template.setTemplate_id("mRoFwA-0C33n9MPomAqE_L3EMNwliOSou8PFV-yJNoA");
        template.setUrl("www.50ldsh.com");
        Templatel templatel = new Templatel();
        templatel.setFirst(new Data("尊敬的会员，您的资料变更成功","#173177"));
        templatel.setKeyword1(new Data("0000 0000","#173177"));
        templatel.setKeyword2(new Data("李XX","#173177"));
        templatel.setKeyword3(new Data("1234567890",""));
        templatel.setKeyword4(new Data(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),"#173177"));
        templatel.setRemark(new Data("感谢您的使用","#173177"));
        template.setData(templatel);
        String result = TemplateMessageAPI.sendTemplate(access_token,template);
        System.out.println(result);
    }
}
