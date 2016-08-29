package com.icinfo.lpsp.wechat.schedule;

import com.icinfo.lpsp.wechat.ticket.TicketManager;
import com.icinfo.lpsp.wechat.token.TokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by yushunwei on 2016/7/21.
 */
@Component
public class ScheduledTasks {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 每7000秒刷新微信相关凭证
     * @throws Exception
     */
    @Scheduled(fixedRate = 7000 * 1000)
    public void refreshTokenAndTicket() throws Exception {
        // 刷新access_token
        TokenManager.refreshToken();
        // 刷新js-sdk临时ticket
        TicketManager.refreshTicket();
        logger.info("微信access_token和js-sdk临时凭证刷新成功！");
    }
}
