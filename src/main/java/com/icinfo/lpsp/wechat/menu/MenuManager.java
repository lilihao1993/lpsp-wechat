package com.icinfo.lpsp.wechat.menu;

import com.icinfo.lpsp.wechat.base.BaseResult;
import com.icinfo.lpsp.wechat.menu.bean.*;
import com.icinfo.lpsp.wechat.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 菜单管理器
 * Created by yushunwei on 2016/8/14.
 */
public class MenuManager {

    private static Logger logger = LoggerFactory.getLogger(MenuManager.class);

    /**
     * 菜单创建
     *
     * @throws Exception
     */
    public static void menuCreate() throws Exception {
        Menu menu = new Menu();
        //创建跳转URL按钮1

        ClickButton   button = new ClickButton();
        button.setName("今日热点");
        button.setType("click");
        button.setKey("ArticleMessage");
        //创建点击事件按钮1
        ClickButton clickButton = new ClickButton();
        clickButton.setName("历史今天");
        clickButton.setType("click");
        clickButton.setKey("HistoryToday");
        //创建点击事件按钮2
        ClickButton clickButton1 = new ClickButton();
        clickButton1.setName("现代诗歌");
        clickButton1.setType("click");
        clickButton1.setKey("ModernPoetry");
        //创建点击事件3
        ClickButton clickButton2 = new ClickButton();
        clickButton2.setName("今日天气");
        clickButton2.setType("click");
        clickButton2.setKey("Weather");

        //二级菜单
        ComplexButton complexButton = new ComplexButton();
        complexButton.setName("更多内容");
        complexButton.setSub_button(new Button[]{clickButton,clickButton1,clickButton2});

        menu.setButton(new Button[]{button,complexButton});
        BaseResult result = MenuAPI.menuCreate(TokenManager.getToken().getAccess_token(), menu);
        if (result.isSuccess()) {
            logger.info("菜单创建成功！");
        } else {
            logger.error("菜单创建失败:{}", result.getErrcode() + "<->" + result.getErrmsg());
        }
    }

    public static void main(String[] args) {
        try {
            menuCreate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
