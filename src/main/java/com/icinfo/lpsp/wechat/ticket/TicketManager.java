package com.icinfo.lpsp.wechat.ticket;

import com.icinfo.lpsp.wechat.token.Token;
import com.icinfo.lpsp.wechat.token.TokenManager;

/**
 * 微信js-sdk调用临时凭证 中控服务器
 * Created by yushunwei on 2016/8/14.
 */
public class TicketManager {

    // js-sdk调用临时凭证
    private static Ticket ticket;

    /**
     * 获取ticket
     *
     * @return 返回ticket
     * @throws Exception
     */
    public static Ticket getTicket() throws Exception {
        // 如果ticket 为空，则直接获取后返回
        if (ticket == null) {
            refreshTicket();
            return ticket;
        }

        // 如果ticket已经失效，则刷新ticket
        if (System.currentTimeMillis() >= ticket.getExpires_in()) {
            refreshTicket();
        }

        return ticket;
    }

    /**
     * 刷新ticket
     *
     * @throws Exception
     */
    public static void refreshTicket() throws Exception {
        Token token = TokenManager.getToken();
        ticket = TicketAPI.getTicket(token.getAccess_token());
        // 直接计算超时时间并存储，提前100秒
        ticket.setExpires_in(System.currentTimeMillis() + 7100 * 1000);
    }
}
