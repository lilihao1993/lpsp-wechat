package com.icinfo.lpsp.wechat.customservice;

import com.icinfo.lpsp.wechat.token.TokenManager;

/**
 * 描述：客服API管理
 */
public class CustomServiceManager {

    public static void main(String[] args) throws Exception {
        CustomServiceAPI.customServiceAdd(TokenManager.getToken().getAccess_token(),"llh@gh_8670544f2965","黎力豪","llh1993824");
    }
}
