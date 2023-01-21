package br.com.controlefinanceiro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.controlefinanceiro.controller.exception.ApiErros;

@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException .class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErros hendleValidationErros(MethodArgumentNotValidException ex) {
		BindingResult br = ex.getBindingResult();
			List<String> messages = br.getAllErrors()
			.stream()
			.map(objectErro -> objectErro.getDefaultMessage())
			.collect(Collectors.toList());
			return new ApiErros(messages);
	}
	
	@ExceptionHandler(ResponseStatusException.class) 
	public ResponseEntity<ApiErros> hendleResponseStatusException(ResponseStatusException ex) {
		String mensagemErro = ex.getMessage();
		HttpStatus codigoStatus = ex.getStatus();
		ApiErros apiErro = new ApiErros(mensagemErro);
		return new ResponseEntity<ApiErros>(apiErro,codigoStatus);
	}
}
