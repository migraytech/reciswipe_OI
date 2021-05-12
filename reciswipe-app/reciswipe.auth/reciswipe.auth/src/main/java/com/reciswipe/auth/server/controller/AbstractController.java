package com.reciswipe.auth.server.controller;


import com.reciswipe.auth.helpers.ErrorCode;
import com.reciswipe.auth.helpers.JsonResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.reciswipe.auth.helpers.Logger.log;


@Controller
@RestControllerAdvice
public abstract class AbstractController {

    public static JsonResult result = new JsonResult();

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    JsonResult handlerMessageException(Exception e, HttpStatus httpStatus) {
        final JsonResult response = new JsonResult();
        log(getClass(), "handleNotFoundException....");
        response.setResult(false);
        response.setErrorMessage(e.getMessage());

        response.setErrorCode(ErrorCode.GENERIC_OR_UNKNOWN);
        response.setErrorCode(httpStatus.value());
        log(getClass(),e.getMessage()+ "[HTTPS STATUS]:{ }"+httpStatus.value());
        return response;
    }

    ///TODO
    //  Check the code of Crossyn for example

    // check on the HttpSatus code 401 in the future.

}

