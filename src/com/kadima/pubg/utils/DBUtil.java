package com.kadima.pubg.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

public class DBUtil {
    private static QueryRunner runner = new QueryRunner(new ComboPooledDataSource());

    public static QueryRunner getQueryRunner() {
        return runner;
    }
}
