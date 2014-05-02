package com.handos.easycloudlog;

import com.handos.IDBContext;

/**
 * Created by jimmylee on 5/2/14.
 */
class LogImpl implements ILog {


    /**
     * 记录等级
     */
    private enum LogLevel{
        Debug,
        Error,
        Verbose,
        warn,
        Info
    }

    /**
     * 记录实体
     */
    private class TagEntity{
        String levelName;
        String tagName;
        String exceptionMessage;

    }

    private IDBContext dbContext;
    public LogImpl(IDBContext dbContext) {
        this.dbContext = dbContext;
    }

    @Override
    public void debug(String tag, String content) {
        TagEntity entity=new TagEntity();


    }

    @Override
    public void debug(String tag, String content, Throwable tr) {

    }

    @Override
    public void error(String tag, String content) {

    }

    @Override
    public void error(String tag, String content, Throwable tr) {

    }

    @Override
    public void info(String tag, String content) {

    }

    @Override
    public void info(String tag, String content, Throwable tr) {

    }

    @Override
    public void verbose(String tag, String content) {

    }

    @Override
    public void verbose(String tag, String content, Throwable tr) {

    }

    @Override
    public void warn(String tag, String content) {

    }

    @Override
    public void warn(String tag, String content, Throwable tr) {

    }

    @Override
    public void warn(String tag, Throwable tr) {

    }
}
