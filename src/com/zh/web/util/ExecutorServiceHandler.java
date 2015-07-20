package com.zh.web.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceHandler {
	private static ExecutorService instance;

	public static synchronized ExecutorService getInstance() {
		if (instance == null) {
			instance = Executors.newCachedThreadPool();
		}
		return instance;
	}
}
