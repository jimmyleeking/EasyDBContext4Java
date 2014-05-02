package com.handos.easycloudlog;

import com.handos.dbcontext.DBContextFactory;

/**
 * Created by jimmylee on 5/2/14.
 */
public class CloudLog {

    private CloudLog(){

    }
    private static ILog log =new LogImpl(DBContextFactory.getDBContext());

    public static void debug(String tag, String content) {
         log.debug(tag,content);
    }

    public static void debug(String tag, String content, Throwable tr) {
        log.debug(tag,content,tr);
    }


    public static void error(String tag, String content) {
        log.error(tag,content);

    }

    public static void error(String tag, String content, Throwable tr) {
        log.error(tag,content,tr);
    }

    public static void info(String tag, String content) {
        log.info(tag,content);
    }


    public static void info(String tag, String content, Throwable tr) {
        log.info(tag,content,tr);
    }


    public static void verbose(String tag, String content) {
        log.verbose(tag,content);
    }


    public static void verbose(String tag, String content, Throwable tr) {
        log.verbose(tag,content,tr);
    }


    public static void warn(String tag, String content) {
        log.warn(tag,content);
    }


    public static void warn(String tag, String content, Throwable tr) {
        log.warn(tag,content,tr);
    }


}
