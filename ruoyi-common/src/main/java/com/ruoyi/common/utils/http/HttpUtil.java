package com.ruoyi.common.utils.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by fengfeng on 2020/7/8.
 */
public class HttpUtil {



    public static String goGet(String cookie, String urlPath, String proxy, String port) {
        return goGet(cookie,urlPath,proxy,port,2000,2000);

    }

    public static String goGet(String cookie, String urlPath, String proxy, String port,Integer connTimeout,Integer readTimeout) {
        HttpURLConnection
                conn = null;
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            if(cookie!=null) {
                conn.setRequestProperty("Cookie", cookie);
            }
            if(connTimeout!=null){
                conn.setConnectTimeout(connTimeout);
            }
            if(readTimeout!=null){
                conn.setReadTimeout(readTimeout);
            }
            conn.setDoInput(true);
            conn.setDoOutput(false);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String msg = sb.toString();
//            conn.getInputStream().close();
            url = null;
            return msg;
        } catch (Exception ex) {
            return ex.getLocalizedMessage();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            conn = null;
        }

    }

    public static String goPostJson(String cookie,String data, String urlPath, String proxy, String port) {
        String context  = "application/json;charset=UTF-8";
       return doPost(cookie,data,urlPath,context,proxy,port);

    }

    public static String doPost(String cookie, String data, String urlPath, String context, String proxy, String port) {
        HttpURLConnection
                conn = null;
        if(context == null){
            context = "application/json;charset=UTF-8";
        }
        try {
            URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            if(cookie!=null) {
                conn.setRequestProperty("Cookie", cookie);
            }
            conn.setRequestProperty("Content-Type",context);
            conn.setDoOutput(true);

            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(data.getBytes("utf-8"));
            outputStream.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String msg = sb.toString();
            conn.getInputStream().close();
            url = null;
            return msg;
        } catch (Exception ex) {
            return ex.getLocalizedMessage();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            conn = null;
        }
    }
}
