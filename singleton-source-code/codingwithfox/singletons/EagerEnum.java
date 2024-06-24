package com.codingwithfox.singletons;

import com.codingwithfox.interfaces.Singleton;

public enum EagerEnum implements Singleton {
  INSTANCE;
  
  EagerEnum() { }
  
  // This method is not necessary is there isn't any logic
  // in it. However, it was added for conciseness.
  public static EagerEnum getInstance() {
    return INSTANCE;
  }
  
  @Override
  public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
  }
}