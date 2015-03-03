package com.zh.core.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 自定义异常处理类
 * @author Administrator
 *
 */
public class ProjectException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3623092817211403634L;

	private String manager;

	private Throwable exception;

	public ProjectException() {
		initCause(null);
	}

	public ProjectException(String message, Throwable cause) {
		super(message, cause);
		initCause(cause);
		this.manager = message;
		this.exception = cause;
	}

	public ProjectException(String message) {
		super(message);
		initCause(null);
		this.manager = message;
	}
	

	public ProjectException(Throwable cause) {
		initCause(cause);
		this.exception = cause;
	}
	

	public static ProjectException createException(String str)
	{
		return new ProjectException(str);
	}

	public String getMessage() {
		return exception.getMessage();
	}

	public void printStackTrace() {
		printStackTrace(System.err);
	}

	public void printStackTrace(PrintStream stream) {
		printStackTrace(new PrintStream(stream));
	}

	public void printStackTrace(PrintWriter writer) {
		super.printStackTrace(writer);
		if (getException() != null) {
			getException().printStackTrace(writer);
		}
		writer.flush();
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Throwable getException() {
		return exception;
	}

	public void setException(Throwable exception) {
		this.exception = exception;
	}

}
