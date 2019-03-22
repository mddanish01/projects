package com.tsys.retail.exception;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.tsys.retail.controller.BillController;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  final Logger logger = LoggerFactory.getLogger(BillController.class);

	private ResponseEntity<Object> customizeErrorMessage(Exception ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setStatus(status.value());
		errorDetail.setTitle(ex.getClass().getName());
		errorDetail.setDetail(ex.getMessage());
		errorDetail.setDeveloperMessage(ex.getClass().getName());
		return handleExceptionInternal(ex, errorDetail, headers, status, request);
	}


	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return customizeErrorMessage(ex, headers, status, request);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manve,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return customizeErrorMessage(manve, headers, status, request);
	}

	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<ErrorDetail> handleResourceNotFoundException(Exception rnfe, HttpServletRequest request) {

		ErrorDetail errorDetail = new ErrorDetail();
		errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
		errorDetail.setTitle("Custom Exception");
		errorDetail.setDetail(rnfe.getMessage());
		errorDetail.setDeveloperMessage(rnfe.getClass().getName());
		return new ResponseEntity<>(errorDetail, null, HttpStatus.NOT_FOUND);

	}

}
