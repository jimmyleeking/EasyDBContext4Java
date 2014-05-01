package com.handos.dbcontext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jimmylee on 5/1/14.
 */
public class DBObject {

    /**
     * 数据表名
     */
    private String tableName;

    public String getTableName() {
        return tableName;
    }
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * 键值
     */
    private Map<String,Object> map=new HashMap<String, Object>();

    /**
     *
     * @param key
     * @param value
     */
    public void put(String key,Object value)
    {
        this.map.put(key,value);
    }
}
