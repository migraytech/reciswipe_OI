package com.reciswipe.recipe.server.controller;

import com.reciswipe.recipe.helpers.ErrorCode;
import com.reciswipe.recipe.helpers.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.reciswipe.recipe.helpers.Logger.log;


@Controller
@RestControllerAdvice
public abstract class AbstractController {

    public static final JsonResult result = new JsonResult();

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody JsonResult handlerMessageException(Exception e, HttpStatus httpStatus) {
        final JsonResult response = new JsonResult();
        log(getClass(), "handleNotFoundException....");
        response.setResult(false);
        response.setErrorMessage(e.getMessage());
        response.setErrorCode(ErrorCode.GENERIC_OR_UNKNOWN);
        response.setErrorCode(httpStatus.value());
        log(getClass(),e.getMessage()+ "[HTTPS STATUS]: {}"+httpStatus.value());
        return response;
    }

    ///TODO
    //  Check the code of Crossyn for example

}

