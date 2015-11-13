package com.vanvalt.util.mybatis.dialect;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

@Intercepts( { @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor
{
    // 日志对象
    protected static Logger log = Logger.getLogger(PaginationInterceptor.class);
    private static final DefaultObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    /*
     * (non-Javadoc)
     * @see
     * org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin
     * .Invocation)
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable
    {
        StatementHandler statementHandler = (StatementHandler) invocation
                .getTarget();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,DEFAULT_OBJECT_FACTORY,DEFAULT_OBJECT_WRAPPER_FACTORY);

        RowBounds rowBounds = (RowBounds) metaStatementHandler
                .getValue("delegate.rowBounds");
        if (rowBounds == null || rowBounds == RowBounds.DEFAULT)
        {
            return invocation.proceed();
        }

        String originalSql = (String) metaStatementHandler
                .getValue("delegate.boundSql.sql");

        Configuration configuration = (Configuration) metaStatementHandler
                .getValue("delegate.configuration");

        Dialect.Type databaseType = null;
        try
        {
            databaseType = Dialect.Type.valueOf(configuration.getVariables()
                    .getProperty("dialect").toUpperCase());
        }
        catch (Exception e)
        {
            // ignore
        }
        if (databaseType == null)
        {
            throw new RuntimeException(
                    "the value of the dialect property in configuration.xml is not defined : "
                            + configuration.getVariables().getProperty(
                                    "dialect"));
        }
        Dialect dialect = null;
        switch (databaseType)
        {
        case ORACLE:
            dialect = new OracleDialect();
            break;
        case DB2:
            dialect = new DB2Dialect();
            break;
        case MYSQL:
            dialect = new MysqlDialect();
            break;
        case MSSQL58:
            dialect = new Mssql58Dialect();
            break;
        case MSSQL12:
            dialect = new Mssql12Dialect();
            break;
        case POSTGRESQL:
        	dialect = new PostgresqlDialect();
        	break;
           
        default:
            break;
        }

        metaStatementHandler.setValue("delegate.boundSql.sql", dialect
                .getLimitString(originalSql, rowBounds.getOffset(), rowBounds
                        .getLimit()));
        metaStatementHandler.setValue("delegate.rowBounds.offset",
                RowBounds.NO_ROW_OFFSET);
        metaStatementHandler.setValue("delegate.rowBounds.limit",
                RowBounds.NO_ROW_LIMIT);
        if (log.isDebugEnabled())
        {
            BoundSql boundSql = statementHandler.getBoundSql();
            log.debug("生成分页SQL : \n" + boundSql.getSql());
        }
        return invocation.proceed();
    }

    /*
     * (non-Javadoc)
     * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
     */
    @Override
    public Object plugin(Object target)
    {
        return Plugin.wrap(target, this);
    }

    /*
     * (non-Javadoc)
     * @see
     * org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
     */
    @Override
    public void setProperties(Properties arg0)
    {
        // TODO Auto-generated method stub

    }

}