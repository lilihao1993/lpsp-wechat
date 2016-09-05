package com.icinfo.lpsp.wechat.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icinfo.lpsp.wechat.base.BaseResult;
import com.icinfo.lpsp.wechat.token.TokenManager;
import com.icinfo.lpsp.wechat.user.bean.Tag;
import com.icinfo.lpsp.wechat.user.bean.TagListResult;
import com.icinfo.lpsp.wechat.user.bean.UserTagList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述：用户管理
 */
public class UserManage {
    public static void main(String[] args) throws Exception {
        String token = TokenManager.getToken().getAccess_token();
        //创建标签
//        creatTag(token);
        //获取标签列表
        getTags(token);
        //修改标签
//        modifyTag(token);
        //删除标签
//        deleteTag(token);
        //批量为用户打标签
//        batchtagging(token);
        //获取用户身上的标签列表
//        getidlist(token);
    }


    /**
     * 描述：创建标签
     * @throws Exception
     */
    public static void creatTag(String token)throws Exception{
        Tag tagResult = UserManageAPI.creatTag(token,"中山日");
        System.out.println(tagResult.getId()+":"+tagResult.getName());

    }

    /**
     * 描述：获取标签列表
     * @param token
     * @throws Exception
     */
    public static void getTags(String token) throws Exception{
        Tag[] tags =  UserManageAPI.getTags(token);
        for (Tag  tag :tags) {
            System.out.println(tag.toString());
        }
    }

    /**
     * 描述：修改标签
     * @param token
     * @throws Exception
     */
    public static void modifyTag(String token)throws Exception{
       Tag tag =  UserManageAPI.modifyTag(token,"100","星-tag");
       String errcode = tag.getErrcode();
        if("0".equals(errcode)){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败："+errcode);
        }
        System.out.println("------------修改后------------");
        getTags(token);
    }

    /**
     * 描述：删除标签
     * @param token
     * @throws Exception
     */
    public static void deleteTag(String token)throws Exception{
        Tag  tag = UserManageAPI.deleteTag(token,"103");
        String errcode = tag.getErrcode();
        if("0".equals(errcode)){
            System.out.println("删除成功");
        }else{
            System.out.println("删除失败："+errcode);
        }
        System.out.println("------------删除后----------------");
        getTags(token);
    }


    /**
     * 描述： 批量为用户打标签
     * @param token
     * @throws Exception
     */
    public static void batchtagging(String token) throws Exception{
        List<String> list = new ArrayList();
        list.add("ohwKTwqOlrW1Z44-MLWPAWfuPlRw");
        list.add("ohwKTwrlvXLucUTWDQ6uD7OJCIeE");
        list.add("ohwKTwvPA54WOodDPDDpMbF0LjfY");
        BaseResult baseResult=  UserManageAPI.batchTag(token,list,"104");
        String errcode = baseResult.getErrcode();
        if("0".equals(errcode)){
            System.out.println("打标签成功");
        }else{
            System.out.println("打标签失败："+errcode);
        }
    }

    /**
     * 描述：获取用户身上的标签列表
     * @param token
     * @throws Exception
     */
    public static void getidlist(String token)throws Exception{
        UserTagList userTagList = UserManageAPI.getUserTag(token,"ohwKTwqOlrW1Z44-MLWPAWfuPlRw");
        List<String> list = userTagList.getTagid_list();
        for (String str:list) {
            System.out.println(str);
        }
    }
}
