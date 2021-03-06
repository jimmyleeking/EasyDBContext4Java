package com.handos.util;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by jimmylee on 5/1/14.
 */
public class PropertyUtil {

    private static PropertyUtil propertyUtil;



    /**
     * 私有的单例方法
     * @return
     */
    private static PropertyUtil getInstance()
    {
        if(propertyUtil ==null)
        {
            propertyUtil =new PropertyUtil();

        }
        return propertyUtil;
    }



    /**
     * 读取配置文件注入到实体
     * @param uri 文件名称和地址
     * @param entity
     */
    public static  void loadProperty(String uri,Object entity){
        PropertyUtil propertyUtil=getInstance();
        Properties properties=new Properties();
        Class<?> entityClass=entity.getClass();
        InputStream stream = null;
        try {
            stream = propertyUtil.getClass().getClassLoader().getResourceAsStream(uri);
            properties.load(stream);
            Iterator<Object> iterator = properties.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();

                Method method=entityClass.getMethod(String.format("set%s",key),new Class[]{String.class});
                if(method!=null)
                {

                    method.invoke(entity,properties.getProperty(key).trim());
                }


            }
            stream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            properties.clear();
        }
    }







}
