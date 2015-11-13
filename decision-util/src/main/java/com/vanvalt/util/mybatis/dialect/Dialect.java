package com.vanvalt.util.mybatis.dialect;

public abstract class Dialect
{
    public static enum Type
    {
        MYSQL, ORACLE, DB2, MSSQL58, MSSQL12,POSTGRESQL
    }

    public abstract String getLimitString(String sql, int skipResults,
            int maxResults);

}