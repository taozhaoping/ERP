package com.zh.core.execl.util;

import java.io.File;
import com.zh.core.exception.ProjectException;

public class ExeclUtil {

	/**
	 * 是否是2003的excel，返回true是2003
	 * @param filePath
	 * @return
	 */
	public static boolean isExcel2003(String filePath){
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	/**
	 * 是否是2007的excel，返回true是2007
	 * @param filePath
	 * @return
	 */
	public static boolean isExcel2007(String filePath){
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
	
	/**
	 * 验证excel文件
	 * @param filePath
	 * @return
	 */
	public static void validateExcel(String filePath){
		/** 检查文件名是否为空或者是否是Excel格式的文件 */
		if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath)))
		{
			throw new ProjectException("文件名不是excel格式");
		}

		/** 检查文件是否存在 */
		File file = new File(filePath);
		if (file == null || !file.exists())
		{
			throw new ProjectException("文件不存在");
		}
	}
}
