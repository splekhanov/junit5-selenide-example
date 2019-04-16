package com.youtube.exceptions;

public class PageNotLoadedException extends RuntimeException {

    public PageNotLoadedException(String message) {
        super(message);
    }
}
