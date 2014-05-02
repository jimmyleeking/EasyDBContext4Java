package com.handos.dbcontext;
import com.handos.dbcontext.exception.DBContextException;
import java.util.List;
/**
 * Created by jimmylee on 5/1/14.
 */
public class EasyDBContext {

    private static DBContextImpl dbContext= (DBContextImpl) DBContextFactory.getDBContext();
    /**
     * 插入数据库
     * @param obj
     * @return 返回插入的键值
     */
    public static String insert(Object obj) {
        return dbContext.insert(obj);
    }
    /**
     * 插入DBObject对象
     * @param obj
     * @return
     */
    public static String insert(DBObject obj) throws DBContextException {

        return dbContext.insert(obj);
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
