package com.handos.dbcontext;

import com.alibaba.fastjson.JSON;
import com.handos.IDBContext;
import com.handos.dbcontext.client.EasyClient;
import com.handos.dbcontext.client.RestAPI;
import com.handos.dbcontext.exception.DBContextException;
import com.handos.util.TextUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * Created by jimmylee on 5/2/14.
 */
class DBContextImpl implements IDBContext {
    /**
     * easyClient客户端
     */
    private  EasyClient easyClient;

    public DBContextImpl(EasyClient easyClient) {

        this.easyClient = easyClient;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    private  EasyClient getEasyClient(){
        return easyClient;
    }

    /**
     * 插入数据库
     * @param obj
     * @return 返回插入的键值
     */
    public String insert(Object obj) {
        Class<?> objClass=obj.getClass();
        String tableName=objClass.getSimpleName();
        String entityString= JSON.toJSONString(obj);
        return insert(tableName,entityString);
    }
    /**
     * 插入DBObject对象
     * @param obj
     * @return
     */
    public  String insert(DBObject obj) throws DBContextException {
        String entityString= JSON.toJSONString(obj.getKeyMap());
        if(TextUtil.isNullOrEmpty(obj.getTableName()))
        {
            throw new DBContextException("tableName is null or empty");
        }
        return insert(obj.getTableName(),entityString);
    }
    /**
     * 插入JSON字符串
     * @param JSONString
     * @return
     */
    private  String insert(String tableName,String JSONString){
        EasyClient client=getEasyClient();

        RestAPI restApi=client.getRestApi();
        String operationUri=String.format(restApi.getInsertUri(),tableName);
        String uri=String.format("%s%s", restApi.getBaseUrl(), operationUri);
        HttpPost httpPost=client.getHttpPost(uri);
        HttpResponse httpResponse=null;
        try {
            StringEntity input = new StringEntity(JSONString);
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


}
