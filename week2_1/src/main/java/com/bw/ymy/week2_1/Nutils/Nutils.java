package com.bw.ymy.week2_1.Nutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Nutils {


    public  static  String getRequest(String urlstr)
    {
        String result="";

        try {
            URL url=new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //网络请求方式
            urlConnection.setRequestMethod("GET");
            //读取超时
            urlConnection.setReadTimeout(5000);
            //连接超时
            urlConnection.setConnectTimeout(5000);
            //请求码
            int responseCode = urlConnection.getResponseCode();
            //判断请求码
            if(responseCode==200)
            {
                result=stringeam(urlConnection.getInputStream());


            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  result;
    }

    //字符流
    private static String stringeam(InputStream inputStream)throws IOException {

        InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder=new StringBuilder();
        for (String tmp=bufferedReader.readLine();tmp!=null;tmp=bufferedReader.readLine())
        {
            stringBuilder.append(tmp);
        }
        return  stringBuilder.toString();
    }
}
