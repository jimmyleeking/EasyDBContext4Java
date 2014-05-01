package com.handos.dbcontext;

import com.alibaba.fastjson.JSON;
import com.handos.dbcontext.client.EasyClient;
import com.handos.dbcontext.client.RestApi;
import com.handos.dbcontext.exception.DBContextInitException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by jimmylee on 5/1/14.
 */
public class EasyDBContext{

    /**
     * easyClient客户端
     */
    private static EasyClient easyClient;


    /**
     * 初始化
     */
    public static void init(){
        easyClient=EasyClient.getInstance();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    private static EasyClient getEasyClient() throws DBContextInitException {
        if(easyClient==null)
        {
            throw new DBContextInitException("Please call init method first");
        }
        return easyClient;
    }

    /**
     * 插入数据库
     * @param obj
     * @return 返回插入的键值
     */
    public static String insert(Object obj) throws DBContextInitException {

        EasyClient client=getEasyClient();
        Class<?> objClass=obj.getClass();
        String className=objClass.getSimpleName();
        RestApi restApi=client.getRestApi();
        String operationUri=String.format(restApi.getInsertUri(),className);
        String uri=String.format("%s%s", restApi.getBaseUrl(), operationUri);
        HttpPost httpPost=client.getHttpPost(uri);
        HttpResponse httpResponse=null;
        try {
            String entityString= JSON.toJSONString(obj);
            StringEntity input = new StringEntity(entityString);
            httpPost.setEntity(input);
            httpResponse = client.execute(httpPost);

            BufferedReader rd = new BufferedReader (new InputStreamReader(httpResponse.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 查询
     * @param strWhere
     * @return
     */
    public static <T> List<T> query(String strWhere){
            return null;
    }

    /**
     * 更新
     * @param obj
     * @return
     */
    public static <T> long update(T obj){
        return -1;
    }

    /**
     * 删除
     * @return
     */
    public static long delete(){
        return -1;
    }

}
