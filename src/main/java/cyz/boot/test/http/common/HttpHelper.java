package cyz.boot.test.http.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;


public class HttpHelper {
	/**
	 * 获取请求Body
	 * 
	 * @param request
	 * @return
	 */
	public static String getRequestBody(HttpServletRequest request) {
		String method = request.getMethod();
		if ("GET".equals(method)) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader reader = null;
		try {
			inputStream = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String line = "";
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
