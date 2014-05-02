package com.handos.easycloudlog;

/**
 * Created by jimmylee on 5/2/14.
 */
public interface ILog {

    void debug(String tag, String content);

    void debug(String tag, String content, Throwable tr);

    void error(String tag, String content);

    void error(String tag, String content, Throwable tr);

    void info(String tag, String content);

    void info(String tag, String content, Throwable tr);

    void verbose(String tag, String content);

    void verbose(String tag, String content, Throwable tr);

    void warn(String tag, String content);

    void warn(String tag, String content, Throwable tr);

    void warn(String tag, Throwable tr);

}
