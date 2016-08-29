package com.icinfo.lpsp.wechat.message.resolver;

import com.icinfo.lpsp.wechat.common.utils.XMLUtils;
import com.icinfo.lpsp.wechat.message.bean.Music;
import com.icinfo.lpsp.wechat.message.bean.MusicMessage;
import com.icinfo.lpsp.wechat.message.bean.TextMessage;
import com.icinfo.lpsp.wechat.message.business.Dispatch;
import com.icinfo.lpsp.wechat.message.business.TextService;
import com.icinfo.lpsp.wechat.message.business.dto.MusicSong;

import java.util.HashMap;

/**
 * 文本消息解析器
 * Created by yushunwei on 2016/8/14.
 */
public class TextMessageResolver extends BaseResolver implements IResolver {

    /**
     * 文本消息处理，回复文本消息
     *
     * @param message 需要处理的原始消息
     * @return 回复的文本消息
     * @throws Exception
     */
    @Override
    public String resolve(HashMap<String, String> message) throws Exception {
        String content = message.get("Content");
        if (content.equals("音乐")){
            return musicTitle(message);
        }
        if (content.startsWith("音乐")) {
            return music(message);
        }
        TextMessage respMessage = new TextMessage();
        setBaseMessage(respMessage, message);
        respMessage.setMsgType(MESSAGE_TEXT);
        respMessage.setContent(TextService.responseTest(message.get("Content")));
        return XMLUtils.parseXml(respMessage);
    }


    /**
     * 描述：回复音乐信息
     * @return
     * @throws Exception
     */
    public String musicTitle(HashMap<String, String> message) throws Exception{
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("音乐:数字\n")
                     .append("1-新歌榜  2-热歌榜\n")
                     .append("11-摇滚榜  12-爵士\n")
                     .append("16-流行   21-欧美金曲榜\n")
                     .append("22-经典老歌榜  23-情歌对唱榜\n")
                     .append("24-影视金曲榜  25-网络歌曲榜\n");
        TextMessage respMessage = new TextMessage();
        setBaseMessage(respMessage, message);
        respMessage.setMsgType(MESSAGE_TEXT);
        respMessage.setContent(stringBuilder.toString());
        return XMLUtils.parseXml(respMessage);
    }
    /**
     * 描述：返回音乐信息
     *
     * @param message
     * @return
     * @throws Exception
     */
    public String music(HashMap<String, String> message) throws Exception {
        char nr =message.get("Content").charAt(3);
        System.out.println(nr);
        MusicSong musicSong = Dispatch.responseMusic(String.valueOf(nr));
        //获取音乐播放地址
        String url = Dispatch.responseMusic1(musicSong.getSong_id());
        MusicMessage respMessage = new MusicMessage();
        setBaseMessage(respMessage, message);
        respMessage.setMsgType(MESSAGE_MUSIC);
        Music music = new Music();
        music.setTitle(musicSong.getTitle());
        music.setDescription(musicSong.getAuthor());
        music.setMusicUrl(url);
        music.setHQMusicUrl(url);
        respMessage.setMusic(music);
        String content = XMLUtils.parseXml(respMessage);
        System.out.println(content);
        return content;
    }
}
