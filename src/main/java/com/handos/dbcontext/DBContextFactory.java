package com.handos.dbcontext;

import com.handos.IDBContext;
import com.handos.IDBContextFactory;
import com.handos.dbcontext.client.EasyClient;
import com.handos.dbcontext.client.IClient;

/**
 * Created by jimmylee on 5/2/14.
 */
public class DBContextFactory implements IDBContextFactory{

    private static IDBContext dbContext;
    /**
     * 获取最新的
     * @return
     */
    public static IDBContext getDBContext(){
        if(dbContext==null)
        {
            EasyClient easyClient=EasyClient.getInstance();
            dbContext=new DBContextImpl(easyClient);
        }
        return dbContext;
    }
}
