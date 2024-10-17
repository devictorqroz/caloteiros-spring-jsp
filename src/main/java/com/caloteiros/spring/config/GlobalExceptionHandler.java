package com.caloteiros.spring.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralException(Exception ex, Model model) {
        ModelAndView mv = new ModelAndView("error/error-default");
        model.addAttribute("error", "Erro");
        model.addAttribute("message", "Ocorreu um erro no servidor.");
        return mv;
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ModelAndView handle404(NoResourceFoundException ex) {
        ModelAndView mv = new ModelAndView("error/error-404");
        mv.addObject("error", "Página não encontrada");
        mv.addObject("message", "A URL solicitada não existe.");
        return mv;
    }

    @ExceptionHandler(DataAccessException.class)
    public ModelAndView handleDatabaseException(DataAccessException ex) {
        ModelAndView mv = new ModelAndView("error/error-sql");
        mv.addObject("error", "SQL Error");
        mv.addObject("message", "Erro com a operação no banco de dados, verifique a transação.");
        return mv;
    }

}
