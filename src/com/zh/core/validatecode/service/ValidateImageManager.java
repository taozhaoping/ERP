/**
 * Copyright 2010-12-01 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2010-12-01
 */
package com.zh.core.validatecode.service;

import java.io.ByteArrayOutputStream;

/**
 * 生成图形验证码的接口
 * @author Flouny.Caesar
 *
 */
public interface ValidateImageManager {
	
	/* 默认验证字符串 */
	public static final String DEFAULT_VALIDATE_CODE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	
	/* 默认绘制干扰线的类型（不绘制干扰线） */
	public static final int DISTURB_TYPE_DEFAULT = 0;
	
	/* 绘制单一色调的干扰线 */
	public static final int DISTURB_TYPE_SIMPLE = 1;
	
	/* 绘制复杂的干扰线 */
	public static final int DISTURB_TYPE_COMPLEX = 2;
	
	/**
	 * 生成验证图片并返回验证码
	 * @param disturbType 绘制干扰线的类型
	 * 					  0：不绘制干扰线
	 * 					  1：绘制单一色调的干扰线
	 *                    2：绘制复杂的干扰线
	 * @param fontSize 图形上验证码字体的大小
	 * @param bos 字节流，用于返回生成的图形验证码字节流，并显示于前台
	 * @param width 图形的宽度
	 * @param height 图形的高度
	 * @param validateCode 默认的验证码编码
	 * @param codeLength 验证码字符长度
	 * @return 返回生成好的验证码字符
	 */
	public String createValidateCode(int disturbType, int fontSize, ByteArrayOutputStream bos, int width, int height, String validateCode, int codeLength);
}