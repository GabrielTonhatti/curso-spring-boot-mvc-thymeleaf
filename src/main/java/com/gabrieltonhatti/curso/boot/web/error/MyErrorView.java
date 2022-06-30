package com.gabrieltonhatti.curso.boot.web.error;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class MyErrorView implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
        ModelAndView model = new ModelAndView("/error");
        model.addObject("status", status.value());

        switch (status.value()) {
            case 404 -> {
                model.addObject("error", "Página não encontrada");
                model.addObject("message", "A URL para a página '" + map.get("path") + "' não existe");
            }
            case 500 -> {
                model.addObject("error", "Ocorreu um erro interno no servidor");
                model.addObject("message", "Ocorreu um erro inexperado, tente novamente mais tarde.");
            }
            default -> {
                model.addObject("error", map.get("error"));
                model.addObject("message", map.get("message"));
            }
        }

        return model;
    }
}
