package com.codingwithfox.exceptions;

public class SingletonException extends RuntimeException {
  public SingletonException(String errorMsg) {
    super(errorMsg);
  }
}
