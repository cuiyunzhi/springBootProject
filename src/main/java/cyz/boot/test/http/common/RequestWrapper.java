package cyz.boot.test.http.common;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequestWrapper extends HttpServletRequestWrapper {
	private final Logger log = LoggerFactory.getLogger(RequestWrapper.class);
	private final byte[] body;

	public static final String CONTENT_TYPE_FILE = "multipart/form-data";
	
	public RequestWrapper(HttpServletRequest request) {
		super(request);
		log.info("Received request type: "  +  request.getContentType());
		log.info("Received request url: "  +  request.getRequestURI() );
		if(request.getContentType()!=null && request.getContentType().indexOf(CONTENT_TYPE_FILE)>-1){
			body = null;
			return;
		}
		body = HttpHelper.getRequestBody(request).getBytes(Charset.forName("UTF-8"));
		String requestBody = new String(body);
		log.info("Received request: "  + requestBody );
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}
	@Override
	public ServletInputStream getInputStream() throws IOException {

		final ByteArrayInputStream bais = new ByteArrayInputStream(body);

		return new ServletInputStream() {

			@Override
			public int read() throws IOException {
				return bais.read();
			}

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener readListener) {

			}
		};
	}

}
