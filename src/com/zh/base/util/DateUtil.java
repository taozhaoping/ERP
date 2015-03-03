/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.zh.base.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtil {
	private static org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory
			.getLog(DateUtil.class);

	/**
	 * Return true if the "Created" value is before the current time minus the
	 * timeToLive argument, and if the Created value is not "in the future".
	 * 
	 * @param timeToLive
	 *            the value in seconds for the validity of the Created time
	 * @param futureTimeToLive
	 *            the value in seconds for the future validity of the Created
	 *            time
	 * @return true if the Date is before (now-timeToLive), false otherwise
	 */
	public static boolean verifyCreated(Date createdDate, int timeToLive,
			int futureTimeToLive) {
		if (createdDate == null) {
			return true;
		}

		Date validCreation = new Date();
		long currentTime = validCreation.getTime();
		if (futureTimeToLive > 0) {
			validCreation.setTime(currentTime
					+ ((long) futureTimeToLive * 1000L));
		}
		//创建时间比当前时间还晚
		// Check to see if the created time is in the future
		if (createdDate.after(validCreation)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Validation of Created: The message was created in the future!");
			}
			return false;
		}

		// Calculate the time that is allowed for the message to travel
		currentTime -= ((long) timeToLive * 1000L);
		validCreation.setTime(currentTime);

		// Validate the time it took the message to travel
		if (createdDate.before(validCreation)) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("Validation of Created: The message was created too long ago");
			}
			return false;
		}

		if (LOG.isDebugEnabled()) {
			LOG.debug("Validation of Created: Everything is ok");
		}
		return true;
	}

	/**
	 * 创建时间
	 */
	public static String getCreated() {
		DateFormat zulu = null;
		zulu = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		zulu.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		Date currentTime = new Date();
		return zulu.format(currentTime);
	}
	
	
	/***
	 * 根据字符串解析日期
	 * @param created
	 * @return
	 * @throws ParseException
	 */
	public static Date getDate(String created) throws ParseException {
		DateFormat zulu = null;
		zulu = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		zulu.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		return zulu.parse(created);
	}
	
	

}
