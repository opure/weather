package com.vanvalt.util.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class RequestBody {
	/**
	 * 日志.
	 */
	private static Logger logger = Logger.getLogger(RequestBody.class);
	private static final String UTF_8 = "utf-8";
	public RequestBody() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 获得requestp的http主体.
	 * 
	 * @param request http请求
	 * @return string http请求内容
	 * @throws IOException
	 */
	public static final String getBodyRequest(final HttpServletRequest request)
			throws IOException {
		
		request.setCharacterEncoding(UTF_8); 
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(
						inputStream, "UTF-8"));
				char[] charBuffer = new char[1024];
				
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			} else {
				stringBuilder.append("");
			}
			
			logger.debug(stringBuilder.toString());
			
		} catch (IOException e) {
			throw e;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					throw e;
				}
			}
		}

		return stringBuilder.toString();
	}

}
