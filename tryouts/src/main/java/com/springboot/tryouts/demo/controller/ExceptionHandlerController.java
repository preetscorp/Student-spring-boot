package com.springboot.tryouts.demo.controller;

import java.nio.file.AccessDeniedException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.springboot.tryouts.demo.exception.CourseNotFoundException;
import com.springboot.tryouts.demo.model.CustomErrorResponse;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value= CourseNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleCourseNotFound(CourseNotFoundException ex) {
		CustomErrorResponse error = new CustomErrorResponse(HttpStatus.NOT_FOUND.ordinal(), ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.ordinal()); error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<CustomErrorResponse> handleSpringAccessDeniedException(AccessDeniedException ex,
			WebRequest request) {
		CustomErrorResponse error = new CustomErrorResponse(HttpStatus.UNAUTHORIZED.ordinal(),
				ex.getMessage());
		error.setStatus(HttpStatus.UNAUTHORIZED.ordinal()); error.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}
		
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorResponse> handleAllException(Exception ex, WebRequest request) {
		CustomErrorResponse error = new CustomErrorResponse(500,ex.getMessage());
		error.setStatus(HttpStatus.UNAUTHORIZED.ordinal()); error.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
