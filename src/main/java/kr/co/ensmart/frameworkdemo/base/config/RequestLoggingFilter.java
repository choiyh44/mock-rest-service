package kr.co.ensmart.frameworkdemo.base.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.AbstractRequestLoggingFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RequestLoggingFilter extends AbstractRequestLoggingFilter {
	@Override
	protected void beforeRequest(HttpServletRequest request, String message) {
        log.info(message);
	}

	@Override
	protected void afterRequest(HttpServletRequest request, String message) {
		log.info(message);
	}

}
