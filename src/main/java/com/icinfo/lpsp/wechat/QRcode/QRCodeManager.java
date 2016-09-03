package com.icinfo.lpsp.wechat.QRcode;

import com.icinfo.lpsp.wechat.token.TokenManager;

import java.util.Map;

/**
 * 描述：二维码管理
 */
public class QRCodeManager {


    /**
     * 描述：创建二维码
     *
     * @throws Exception
     */
    public static void creatQRCode() throws Exception {
        //创建临时二维码ticket
        Map<String,String> map = QRCodeAPI.createInterimCode(TokenManager.getToken().getAccess_token(), "565656", "QR_SCENE", "1234567891235678912345678912345");
        System.out.println(map.get("ticket")+":"+map.get("url"));
    }

    public static void main(String[] args) throws Exception {
        creatQRCode();
    }


}
