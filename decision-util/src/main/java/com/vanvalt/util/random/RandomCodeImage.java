package com.vanvalt.util.random;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class RandomCodeImage {

	public static ImageCode getImage() throws IOException {

		Random random = new Random();

		int width = 55, height = 25;

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// 取得Graphics对象，用来绘制图片
		Graphics g = image.getGraphics();
		// 绘制图片背景和文字,释放Graphics对象所占用的资源。
		g.setColor(Color.WHITE);
		// 设置内容生成的位置
		g.fillRect(0, 0, width, height);
		// 设置内容的字体和大小
		g.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		// 设置内容的颜色：主要为生成图片背景的线条
		g.setColor(Color.WHITE);

		// // 图片背景上随机生成155条线条，避免通过图片识别破解验证码
		// for (int i = 0; i < 155; i++) {
		// int x = random.nextInt(width);
		// int y = random.nextInt(height);
		// int xl = random.nextInt(12);
		// int yl = random.nextInt(12);
		// g.drawLine(x, y, x + xl, y + yl);
		// }

		// 生成四位的随机数,生成一个数，写一个
		// String[] s = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
		// "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
		// "X", "Y", "Z" };
		String[] s = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		String content = "";
		for (int i = 0; i < 4; i++) {
			String rand = "";
			if (random.nextBoolean()) {
				rand = String.valueOf(random.nextInt(10));
			} else {
				int index = random.nextInt(10);
				rand = s[index];
			}
			content += rand;
			g.setColor(Color.RED);
			g.drawString(rand, 13 * i + 6, 16);
		}

		// 释放此图形的上下文以及它使用的所有系统资源，类似于关闭流
		g.dispose();

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);

		ImageIO.write(image, "JPEG", imageOut);

		imageOut.close();
		return new ImageCode(content, new ByteArrayInputStream(output.toByteArray()));
	}

	protected static Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255) fc = 255;
		if (bc > 255) bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

}
