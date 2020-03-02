package util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public interface HttpTools {
    static JSONObject doHttpGet(String urlAddr) {
        return doHttp(urlAddr, true);
    }

    static JSONObject doHttpPost(String urlAddr) {
        return doHttp(urlAddr, false);
    }

    static JSONObject doHttp(String urlAddr, boolean method) {
        JSONObject result = null;
        BufferedReader br = null;

        try {
            URL url = new URL(urlAddr);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.setRequestMethod(method ? "GET" : "POST");
            connection.connect();
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            StringBuilder sb = new StringBuilder();
            String temp = null;

            while((temp = br.readLine()) != null) {
                sb.append(temp);
            }

            result = JSONObject.parseObject(sb.toString());
        } catch (IOException var16) {
            var16.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException var15) {
                    var15.printStackTrace();
                }
            }
        }
        return result;
    }
}
