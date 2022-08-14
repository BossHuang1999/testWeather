package test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Map;

import static org.junit.Assert.*;

public class myBaidu {
    public static void main(String[] args) {
        myBaidu mb = new myBaidu();
        mb.mypos();
        System.out.println("东西呢");
    }


    @Test
    public void mypos(){
        String ak = "BmSQlo36k0PZ5GjLpgEtGmiTnPDYIaV7";
        String address = "江宁万达广场";
        String httpUrl = "http://api.map.baidu.com/geocoding/v3/?address="+address+"&output=json&ak=" + ak;
        StringBuilder json = new StringBuilder();
        try {
            URL url = new URL(httpUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
//        System.out.println(json.toString());

        String data = json.toString();
        if (data != null && !"".equals(data)) {
            Map map = JSON.parseObject(data, Map.class);
            if ("0".equals(map.getOrDefault("status", "500").toString())) {
                Map childMap = (Map) map.get("result");
                Map posMap = (Map) childMap.get("location");
                double lng = Double.parseDouble(posMap.getOrDefault("lng", "0").toString()); // 经度
                double lat = Double.parseDouble(posMap.getOrDefault("lat", "0").toString()); // 纬度
                DecimalFormat df = new DecimalFormat("#.######");
                String lngStr = df.format(lng);
                String latStr = df.format(lat);
                String result = lngStr + "," + latStr;
                System.out.println(address+"经纬度为：");
                System.out.println(result);
                assertEquals(result,"118.8573,31.959617");
                assertEquals(result,"115.8573,31.959617");
            }
        }
    }

}


