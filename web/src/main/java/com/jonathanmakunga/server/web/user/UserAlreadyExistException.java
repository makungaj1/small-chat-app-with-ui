package com.jonathanmakunga.server.web.user;

public class UserAlreadyExistException extends Error {
    public UserAlreadyExistException(String msg) {
        super(msg);
    }
    public UserAlreadyExistException() {
        super("User already exist.");
    }
}
