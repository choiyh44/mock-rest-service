package kr.co.ensmart.frameworkdemo.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestLoggingFilterConfig {
	
	@Bean
	public RequestLoggingFilter globalErrorLoggingFilter() {
		RequestLoggingFilter filter = new RequestLoggingFilter();
		filter.setIncludeClientInfo(true);
		filter.setIncludeHeaders(true);
		filter.setIncludePayload(true);
		filter.setIncludeQueryString(true);
		filter.setMaxPayloadLength(10000);
		return filter;
	}

}
