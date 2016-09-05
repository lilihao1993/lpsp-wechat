package com.icinfo.lpsp.wechat.material;

import com.icinfo.lpsp.wechat.material.model.NewsMaterialList;
import com.icinfo.lpsp.wechat.material.model.OtherMaterialList;
import com.icinfo.lpsp.wechat.token.TokenManager;

/**
 * 描述:获取永久图文列表
 */
public class SelectNewsList {

    public static void main(String[] args) throws Exception {
//        OtherMaterialList otherMaterialList = MaterialManager.getForeverOtherMaterialsList(TokenManager.getToken().getAccess_token(),"news","1","3");
//        System.out.println(otherMaterialList.toString());
        NewsMaterialList newsMaterialList = MaterialManager.getForeverNewsMaterialsList(TokenManager.getToken().getAccess_token(),"news","1","3");
        System.out.println(newsMaterialList.toString());
    }
}
