package com.sun.mytaskcenter.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HttpUtils
 * @Description: TODO
 * @Author zcm
 * @Date 2019-12-04
 * @Version V1.0
 **/
public class HttpUtils {

    private RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(60000000).setConnectTimeout(600000)
            .setConnectionRequestTimeout(15000000).build();

    private static HttpUtils instance = null;

    private HttpUtils(){

    }

    public static HttpUtils getInstance(){
        if (null == instance){
            instance = new HttpUtils();
        }
        return instance;
    }


    public String sendHttpPost(String httpUrl){
        HttpPost httpPost = new HttpPost(httpUrl);
        return sendHttpPost(httpPost);
    }

    public String sendHttpPost(String httpUrl,String params){
        HttpPost httpPost = new HttpPost(httpUrl);
        try {
            StringEntity entity = new StringEntity(params);
            entity.setContentType("application/x-www-");
            httpPost.setEntity(entity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }

    public String sendHttpPost(String httpUrl, Map<String,String> maps){
        HttpPost httpPost = new HttpPost(httpUrl);

        List<NameValuePair> nameValuePairList  = new ArrayList<NameValuePair>();

        for (String key : maps.keySet()){
            nameValuePairList.add(new BasicNameValuePair(key,maps.get(key)));
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
        }catch (Exception e){
            e.printStackTrace();
        }

        return sendHttpPost(httpPost);
    }

    public String sendHttpPostWithJson(String httpUrl,String jsonStr){
        HttpPost httpPost = new HttpPost(httpUrl);

        try {
        StringEntity entity = new StringEntity(jsonStr,"UTF-8");
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        }catch (Exception e){
            e.printStackTrace();
        }

        return sendHttpPost(httpPost);
    }


    private String sendHttpPost(HttpPost httpPost){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity httpEntity = null;
        String responseContent = null;
        try {
            //httpclient
            httpClient = HttpClients.createDefault();
            httpPost.setConfig(requestConfig);
            //exec
            response = httpClient.execute(httpPost);
            httpEntity = response.getEntity();
            responseContent = EntityUtils.toString(httpEntity,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (response != null){
                        response.close();
                }
                if (httpClient != null){
                    httpClient.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return responseContent;

    }

    public String sendHttpGet(String httpUrl,String param){
        HttpGet httpGet = new HttpGet(httpUrl);

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;

        try {
            //client
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);

            //exec
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (response != null){
                    response.close();
                }
                if (httpClient != null){
                    httpClient.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return responseContent;
    }



    public String sendHttpGet(String httpUrl){
        HttpGet httpGet = new HttpGet(httpUrl);
        return sendHttpGet(httpGet);
    }

    private String sendHttpGet(HttpGet httpGet){
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;

        try {
            //client
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            //exec
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (response != null){
                    response.close();
                }
                if (httpClient != null){
                    httpClient.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return responseContent;
    }

}
