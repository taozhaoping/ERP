package com.zh.core.util;

import org.slf4j.Logger;

import com.zh.core.exception.ProjectException;

public class LoggerUtil {

	/**
	 * 输出日记并抛处agile异常
	 * @param LOGGER
	 * @param str
	 * @throws AgileException
	 */
	public static void error(Logger LOGGER , String str) throws ProjectException
	{
		LOGGER.error(str);
		throw new ProjectException(str);
	}
}
