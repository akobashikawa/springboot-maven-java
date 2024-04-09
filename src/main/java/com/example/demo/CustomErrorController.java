package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());
            model.addAttribute("statusCode", statusCode);

            Object errorMessage = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
            model.addAttribute("errorMessage", errorMessage);

            Object exceptionObject = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
            String stackTrace = exceptionObject != null ? ((Throwable) exceptionObject).getMessage() : "-";
            model.addAttribute("stackTrace", stackTrace);
        }

        return "error";
    }

}
