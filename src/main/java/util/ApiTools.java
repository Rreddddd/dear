package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pojo.WXConfig;

public interface ApiTools {

    static String getIpLocate(String ip) {
        JSONObject jsonObject = HttpTools.doHttpGet("http://opendata.baidu.com/api.php?query=" + ip + "&co=&resource_id=6006&t=1412300361645&ie=utf8&oe=utf8");
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        return jsonArray.size() == 0 ? "" : jsonArray.getJSONObject(0).getString("location");
    }

    static String getWxSessionKey(String code){
        JSONObject jsonObject = HttpTools.doHttpGet("https://api.weixin.qq.com/sns/jscode2session?appid=" + WXConfig.APP_ID + "&secret=" + WXConfig.APP_SECRET + "&js_code=" + code + "&grant_type=authorization_code");
        return jsonObject.getString("session_key");
    }
}
