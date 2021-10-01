package com.reciswipe.auth.server.controller;


import com.reciswipe.auth.config.JwtTokenUtil;
import com.reciswipe.auth.helpers.ErrorCode;
import com.reciswipe.auth.helpers.JsonLogic;
import com.reciswipe.auth.helpers.JsonResult;
import com.reciswipe.auth.server.domain.JwtResponse;
import com.reciswipe.auth.server.domain.User;
import com.reciswipe.auth.service.AuthService;
import com.reciswipe.auth.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.reciswipe.auth.helpers.Logger.log;

@RequestMapping("auth")
@RestController
public class AuthController extends AbstractController {


    @Autowired
    private AuthService authService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //TODO
    // create signIn and signUp on the platform.
    @PostMapping(value = "/signUp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResult> createUser(@RequestBody String json) {
        log(User.class, "User.. trying to login ");
        try {
            final User user = (User) JsonLogic.getObject(User.class, json);
            final User createdUser = authService.create(user);
            if (userValidator.validCreateUser(createdUser)) {
                result.setResult(true);
                result.setItem(userValidator.sanitize(createdUser));
                result.setMessage("User is successfully created");
                return new ResponseEntity<>(result, HttpStatus.OK);
            }
            else {
                result.setResult(false);
                result.setMessage("Failed to signUp with User.");
                result.setErrorCode(ErrorCode.FAILED_CREATING_USER);
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            log(getClass(), "Failed to signUp with User");
            return new ResponseEntity<>(handlerMessageException(e, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/signIn",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JsonResult> login(@RequestBody String json){
        log(getClass().getName(), "User is trying to signIn......");
        try {
            final User user = (User) JsonLogic.getObject(User.class,json);
            log(getClass().getName(), "AUTHENTICATE THE USER:.....");
            authenticate(user.getUsername(), user.getPassword());
            log(getClass().getName(), "ENTERING:.....");
            User loginUser = authService.login(user);
            if(userValidator.validLoginUser(loginUser)){
                final UserDetails userDetails = authService.loadUserByUsername(loginUser.getUsername());
                final String token = jwtTokenUtil.generateToken(userDetails);
                result.setResult(true);
                result.setItem(new JwtResponse(token));
                result.setMessage("User is logged in successfully");
                return new ResponseEntity<>(result,HttpStatus.OK);
            }
            else {
                result.setResult(false);
                result.setMessage("Failed to signIn with User.");
                result.setErrorCode(ErrorCode.FAILED_LOG_IN);
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        }
        catch (Exception e){
            return new ResponseEntity<>(handlerMessageException(e, HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
        }
    }

    //TODO
    // create logOut on the platform.
    @GetMapping(value = "/logout")
    public ResponseEntity<JsonResult> logoutPage(HttpServletRequest request, HttpServletResponse response) {
        log(getClass(), "User is trying to logout......");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JsonResult result = new JsonResult();
        try {
            if (auth != null) {
                result.setResult(true);
                result.setMessage("User is successfully logout");
                request.logout();
                new SecurityContextLogoutHandler().logout(request, response, auth);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                result.setResult(false);
                result.setMessage("Failed to logout.");
                result.setErrorCode(ErrorCode.FAILED_LOG_OUT);
                return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            result.setResult(false);
            result.setMessage("Failed to logout.");
            result.setErrorCode(ErrorCode.FAILED_LOG_OUT);
            result.setErrorMessage(e.toString());
            log(this.getClass(), e.getMessage());
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    //TODO
    // create JWT Classes and config package for authorization of this service.
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {

            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}
