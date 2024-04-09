package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController  {
    
    // Si se usa, tiene preferencia sobre CustomErrorController
    // @ExceptionHandler(Exception.class)
    // public ModelAndView handleException(Exception ex) {
    //     ModelAndView modelAndView = new ModelAndView("error");
    //     modelAndView.addObject("errorMessage", ex.getMessage());
    //     return modelAndView;
    // }

}
