package config.utils;

import cn.hutool.json.JSONObject;
import config.doMain.MessageInfo;

/**
 * 消息解析工具类
 */
public class JsonUtils {

    /**
     * 解析消息并转换为对象
     * @param msg 消息
     * @return MessageInfo
     */
    public static MessageInfo toMessage(String msg){
        return new JSONObject(msg).toBean(MessageInfo.class);
    }
}
