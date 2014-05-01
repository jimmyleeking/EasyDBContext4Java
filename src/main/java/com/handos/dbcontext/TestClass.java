package com.handos.dbcontext;

import com.handos.dbcontext.exception.DBContextInitException;

/**
 * Created by jimmylee on 5/1/14.
 */
public class TestClass {
    public static void main(String[] args) {
        System.out.println("start to testing");
        EasyDBContext.init();
        Good good=new Good();
        good.setName("Hello Kitty");
        good.setAge("1000");
        try {
            EasyDBContext.insert(good);
        } catch (DBContextInitException e) {
            e.printStackTrace();
        }
    }

}
