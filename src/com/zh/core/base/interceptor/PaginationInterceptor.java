package com.zh.core.base.interceptor;

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
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.zh.core.base.model.Dialect;
import com.zh.core.base.model.OracleDialect;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {

	private final static Logger LOGGER = LoggerFactory
			.getLogger(PaginationInterceptor.class);

	@Override
	public Object intercept(Invocation invocation) throws Throwable {

		if (LOGGER.isDebugEnabled()) {

			LOGGER.debug("Start generating paging !");

		}

		StatementHandler statementHandler = (StatementHandler) invocation
				.getTarget();

		BoundSql boundSql = statementHandler.getBoundSql();

		MetaObject metaStatementHandler = SystemMetaObject
				.forObject(statementHandler);

		RowBounds rowBounds = (RowBounds) metaStatementHandler
				.getValue("delegate.rowBounds");

		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {

			return invocation.proceed();

		}

		Configuration configuration = (Configuration) metaStatementHandler
				.getValue("delegate.configuration");

		Dialect.Type databaseType = null;

		try {

			databaseType = Dialect.Type.valueOf(configuration.getVariables()
					.getProperty("dialect").toUpperCase());

		} catch (Exception e) {

			LOGGER.error("myibatais conf not dialect property type!");

		}

		if (databaseType == null) {
			String message = "the value of the dialect property in configuration.xml is not defined : "
					+ configuration.getVariables().getProperty("dialect");
			LOGGER.error(message);
			throw new RuntimeException(message);

		}

		Dialect dialect = null;

		switch (databaseType) {

		case ORACLE:

			dialect = new OracleDialect();
			break;
		case MYSQL:
			dialect = new OracleDialect();
			break;
		}

		String originalSql = (String) metaStatementHandler
				.getValue("delegate.boundSql.sql");

		metaStatementHandler.setValue("delegate.boundSql.sql", dialect
				.getLimitString(originalSql, rowBounds.getOffset(),
						rowBounds.getLimit()));

		metaStatementHandler.setValue("delegate.rowBounds.offset",
				RowBounds.NO_ROW_OFFSET);

		metaStatementHandler.setValue("delegate.rowBounds.limit",
				RowBounds.NO_ROW_LIMIT);

		if (LOGGER.isDebugEnabled()) {

			LOGGER.debug("生成分页SQL : " + boundSql.getSql());

		}

		return invocation.proceed();

	}

	@Override
	public Object plugin(Object target) {

		return Plugin.wrap(target, this);

	}

	@Override
	public void setProperties(Properties properties) {

	}

}