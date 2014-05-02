package com.handos.dbcontext.client;

import com.handos.util.PropertyUtil;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by jimmylee on 5/1/14.
 */
public class EasyClient implements IClient {

    /**
     * 默认RESTAPI配置文件
     */
    private static final String DEFAULT_REST_API_FILE_NAME="restapi.properties";
    /**
     * AVOS的标示头
     */
    public static final String X_AVOSCloud_Application_Id="X-AVOSCloud-Application-Id";
    /**
     * AVOS的标示头
     */
    public static final String X_AVOSCloud_Application_Key="X-AVOSCloud-Application-Key";


    private static EasyClient easyClient;

    private HttpClient httpClient=null;


    private RestAPI restApi;

    public RestAPI getRestApi() {
        return restApi;
    }

    /**
     * 获取实例
     * @return
     * @throws Exception
     */
    synchronized public static EasyClient getInstance() {
        //读取配置文件
        if(easyClient==null){
            easyClient=new EasyClient();
            easyClient.httpClient= new DefaultHttpClient();
            easyClient.restApi=new RestAPI();
            PropertyUtil.loadProperty(DEFAULT_REST_API_FILE_NAME,easyClient.restApi);
        }


        return easyClient;
    }



    /**
     * 获取Post
     * @return
     */
    public HttpPost getHttpPost(){
        HttpPost httpPost=new HttpPost();
        this.setHeader(httpPost);
        return httpPost;
    }

    /**
     *
     * @param uri
     * @return
     */
    public HttpPost getHttpPost(String uri){
        HttpPost httpPost=new HttpPost(uri);
        this.setHeader(httpPost);
        return httpPost;
    }


    /**
     * 获取Get
     * @return
     */
    public HttpGet getHttpGet(){
        HttpGet httpGet=new HttpGet();
        this.setHeader(httpGet);
        return httpGet;
    }

    /**
     * 执行调用
     * @param request
     * @return
     * @throws IOException
     */
    public HttpResponse execute(HttpUriRequest request) throws IOException {
        return httpClient.execute(request);
    }


    /**私有方法**/


    /**
     * 设置请求标头
     * @param httpRequest
     */
    private void setHeader(HttpRequest httpRequest)
    {
        httpRequest.addHeader(X_AVOSCloud_Application_Id, restApi.getApplicationId());
        httpRequest.addHeader(X_AVOSCloud_Application_Key, restApi.getApplicationKey());
        httpRequest.setHeader("Content-type", "application/json");
    }


}
