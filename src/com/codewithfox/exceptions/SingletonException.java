package com.codewithfox.exceptions;

public class SingletonException extends RuntimeException {
  public SingletonException(String errorMsg) {
    super(errorMsg);
  }
}
