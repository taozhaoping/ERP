/**
 * Copyright 2005-2010 Flouny.Caesar.com
 * All rights reserved.
 * 
 * @project
 * @author Flouny.Caesar
 * @version 1.0
 * @data 2010-12-01
 */
package com.zh.core.validatecode.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import com.zh.core.validatecode.service.ValidateImageManager;


/**
 * 生成图形验证码的实现
 * @author Flouny.Caesar
 *
 */
@Component("validateImageManager")
public class ValidateImageManagerImpl implements ValidateImageManager {
	
	private Logger LOG = Logger.getLogger(ValidateImageManagerImpl.class);

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
	public String createValidateCode(int disturbType, int fontSize, ByteArrayOutputStream bos, int width, int height, String validateCode, int codeLength) {
		BufferedImage bImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = bImg.createGraphics();
		Random random = new Random();
		
		if (null == validateCode || validateCode.isEmpty()) {
			validateCode = DEFAULT_VALIDATE_CODE;
		}
		
		if (fontSize >= height) {
			fontSize = height - 1;
		}
		
		drawOutline(g, width, height);
		switch (disturbType) {
			case DISTURB_TYPE_SIMPLE : drawSimpleDisturb(g, random, width, height);
				break;
			case DISTURB_TYPE_COMPLEX : drawDisturb(g, random, width, height);
				break;
			default : break;
		}
		
		String code = drawCode(g, random, validateCode, codeLength, width, height, fontSize);
		g.dispose();
		try {
			ImageOutputStream imOut = ImageIO.createImageOutputStream(bos);
			ImageIO.write(bImg, "JPEG", imOut);
			imOut.close();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			
			return null;
		}
		
		return code;
	}
	
	/**
	 * 绘制边框
	 * @param g
	 * @param width
	 * @param height
	 */
	private static void drawOutline(Graphics2D g, int width, int height) {
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.drawRect(0, 0, width - 1, height - 1);
	}
	
	/**
	 * 绘制比较复杂的干扰线
	 * @param g
	 * @param random
	 * @param width
	 * @param height
	 */
	private static void drawDisturb(Graphics2D g, Random random, int width, int height) {
		int x, y, x1, y1;
		for (int i = 0; i < width; i++) {
			x = random.nextInt(width);
			y = random.nextInt(height);
			x1 = random.nextInt(12);
			y1 = random.nextInt(12);
			g.setColor(getRandomColor(random, 120, 255));
			g.drawLine(x, y, x + x1, y + y1);
			g.fillArc(x, y, x1, y1, random.nextInt(360), random.nextInt(360));
		}
	}
	
	/**
	 * 绘制简单的干扰线
	 * @param g
	 * @param random
	 * @param width
	 * @param height
	 */
	private static void drawSimpleDisturb(Graphics2D g, Random random, int width, int height) {
		g.setColor(getRandomColor(random, 160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
	}
	
	/**
	 * 取得随机颜色
	 * @param random
	 * @param pMin
	 * @param pMax
	 * @return
	 */
	private static Color getRandomColor(Random random, int pMin, int pMax) {
		pMax = (Math.abs(pMax) > 255 ? 255 : Math.abs(pMax));
		pMin = (Math.abs(pMin) > 255 ? 255 : Math.abs(pMin));
		
		int r = pMin + random.nextInt(Math.abs(pMax - pMin));
		int g = pMin + random.nextInt(Math.abs(pMax - pMin));
		int b = pMin + random.nextInt(Math.abs(pMax - pMin));
		
		return new Color(r, g, b);
	}
	
	/**
	 * 绘制验证码
	 * @param g
	 * @param random
	 * @param validateCode
	 * @param codeLength
	 * @param width
	 * @param height
	 * @param fontSize
	 * @return
	 */
	private static String drawCode(Graphics2D g, Random random, String validateCode, int codeLength, int width, int height, int fontSize) {
		int validateCodeLength = validateCode.length();
		Font font1 = new Font("Verdana", Font.PLAIN, fontSize);
		Font font2 = new Font("serif", Font.PLAIN, fontSize);
		
		StringBuffer sb = new StringBuffer();
		int x, y;
		
		for (int i = 0; i < codeLength; i++) {
			x = (width / codeLength - 1) * i + random.nextInt(width / (codeLength * 2));
			y = random.nextInt(height - fontSize) + fontSize;
			sb.append(getRandomChar(validateCode, validateCodeLength, random));
			g.setColor(getRandomColor(random, 70, 150));
			
			if (sb.substring(i).getBytes().length > 1) {
				g.setFont(font2);
			} else {
				g.setFont(font1);
			}
			
			g.drawString(sb.substring(i), x, y);
		}
		
		return sb.toString();
	}
	
	/**
	 * 取得随机字符
	 * @param validateCode
	 * @param validateCodeLength
	 * @param random
	 * @return
	 */
	private static char getRandomChar(String validateCode, int validateCodeLength, Random random) {
		
		return validateCode.charAt(random.nextInt(validateCodeLength));
	}
}