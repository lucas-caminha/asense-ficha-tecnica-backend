package com.br.FichaTecnicaApi.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.FichaTecnicaApi.exception.BusinessException;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	public ResponseEntity<ErrorInfo> businessExceptionHandler(HttpServletRequest req, BusinessException e) {
		ErrorInfo errorInfo = new ErrorInfo(req.getRequestURL().toString(), e.getMessage());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorInfo);
	}
	
}
