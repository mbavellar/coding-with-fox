package com.codingwithfox.exceptions;

public class UnimplementedMethodException extends RuntimeException {
  public UnimplementedMethodException(String errorMessage) {
    super(errorMessage);
  }
}
