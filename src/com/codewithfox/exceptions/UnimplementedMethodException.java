package com.codewithfox.exceptions;

public class UnimplementedMethodException extends RuntimeException {
  public UnimplementedMethodException(String errorMessage) {
    super(errorMessage);
  }
}
