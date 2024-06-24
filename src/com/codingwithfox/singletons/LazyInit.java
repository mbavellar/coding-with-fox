package com.codingwithfox.singletons;

import com.codingwithfox.interfaces.Singleton;

import java.io.Serial;

public final class LazyInit implements Singleton {
  
  private static LazyInit _instance;
  
  private LazyInit() {
//    if (_instance != null)
//      throw new IllegalStateException("Access to constructor is denied because an instance already exists.");
    Singleton.checkDoubleInstance(_instance);
  }
  
  public static LazyInit getInstance() {
    if (_instance == null)
      _instance = new LazyInit();
    return _instance;
  }
  
  @Serial
  private Object readResolve() {
    return getInstance();
  }
}