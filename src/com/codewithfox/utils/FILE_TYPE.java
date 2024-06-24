package com.codewithfox.utils;

public enum FILE_TYPE {
  OBJECT(".obj"),
  DATA(".dat"),
  BIN(".bin");
  private String type;
  FILE_TYPE(String type) {
    this.type = type;
  }
  
  @Override
  public String toString() {
    return type;
  }
}
