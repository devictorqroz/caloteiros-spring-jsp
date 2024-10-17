package com.caloteiros.spring.config;

import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ModelAndView handleGeneralException(RuntimeException ex, Model model) {
        ModelAndView mv = new ModelAndView("error/default-error");
        model.addAttribute("error", "Erro");
        model.addAttribute("message", "Ocorreu um erro no servidor.");
        return mv;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ModelAndView handle404(NoResourceFoundException ex) {
        ModelAndView mv = new ModelAndView("error/http-error");
        mv.addObject("error", "Página não encontrada");
        mv.addObject("message", "A URL solicitada não existe.");
        return mv;
    }

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDatabaseException(DataAccessException ex) {
        ModelAndView mv = new ModelAndView("error/sql-error");
        mv.addObject("error", "SQL Error");
        mv.addObject("message", "Erro com a operação no banco de dados, verifique a transação.");
        return mv;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView handleBadRequest(MethodArgumentNotValidException ex) {
        ModelAndView mv = new ModelAndView("error/http-error");
        mv.addObject("error", "400 - Requisição inválida");
        mv.addObject("message", "Os dados fornecidos são inválidos.");
        return mv;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handleNotFound(NoHandlerFoundException ex) {
        ModelAndView mv = new ModelAndView("error/http-error");
        mv.addObject("error", "404 - Recurso não encontrado");
        mv.addObject("message", "A página que você está procurando não existe.");
        return mv;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView handleMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        ModelAndView mv = new ModelAndView("error/http-error");
        mv.addObject("error", "405 - Método HTTP não suportado");
        mv.addObject("message", "O método " + ex.getMethod() + " não é permitido para esta requisição.");
        return mv;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleInternalServerError(Exception ex) {
        ModelAndView mv = new ModelAndView("error/http-error");
        mv.addObject("error", "500 - Erro interno do servidor");
        mv.addObject("message", "Ocorreu um erro inesperado. Por favor, tente novamente mais tarde.");
        return mv;
    }

}
