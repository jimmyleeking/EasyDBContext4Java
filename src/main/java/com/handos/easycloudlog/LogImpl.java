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
        String content;
        String exceptionMessage;

    }

    private IDBContext dbContext;
    public LogImpl(IDBContext dbContext) {
        this.dbContext = dbContext;
    }

    private void log(LogLevel level, String tag, String content, Throwable tr)
    {
        TagEntity entity=new TagEntity();
        entity.levelName=level.name();
        entity.tagName=tag;
        entity.content=content;
        entity.exceptionMessage=tr.getMessage();
        dbContext.insert(entity);
    }

    @Override
    public void debug(String tag, String content) {
        this.debug(tag,content,null);
    }

    @Override
    public void debug(String tag, String content, Throwable tr) {
        this.log(LogLevel.Debug,tag,content,tr);
    }

    @Override
    public void error(String tag, String content) {
        this.error(tag,content,null);

    }

    @Override
    public void error(String tag, String content, Throwable tr) {
        this.log(LogLevel.Error,tag,content,tr);
    }

    @Override
    public void info(String tag, String content) {
        this.info(tag,content,null);
    }

    @Override
    public void info(String tag, String content, Throwable tr) {
        this.log(LogLevel.Info,tag,content,tr);
    }

    @Override
    public void verbose(String tag, String content) {
       this.verbose(tag,content,null);
    }

    @Override
    public void verbose(String tag, String content, Throwable tr) {
        this.log(LogLevel.Verbose,tag,content,tr);
    }

    @Override
    public void warn(String tag, String content) {
        this.warn(tag,content,null);
    }

    @Override
    public void warn(String tag, String content, Throwable tr) {
       this.warn(tag,content,null);
    }


}
