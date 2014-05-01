package com.handos.dbcontext;

import com.alibaba.fastjson.JSON;
import com.handos.dbcontext.exception.DBContextInitException;

/**
 * Created by jimmylee on 5/1/14.
 */
public class TestClass {
    public static void main(String[] args) {

        DBObject obj=new DBObject("");
        obj.put("good","good");
        obj.put("fuck","fuck");
        String jsonString= JSON.toJSONString(obj.getKeyMap());
        System.out.println(jsonString);
    }

}
