package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface ApiTools {

    static String getIpLocate(String ip) {
        JSONObject jsonObject = HttpTools.doHttpGet("http://opendata.baidu.com/api.php?query=" + ip + "&co=&resource_id=6006&t=1412300361645&ie=utf8&oe=utf8");
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        return jsonArray.size() == 0 ? "" : jsonArray.getJSONObject(0).getString("location");
    }
}
