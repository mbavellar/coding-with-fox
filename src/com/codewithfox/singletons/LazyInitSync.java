package com.codewithfox.singletons;

import com.codewithfox.interfaces.Singleton;

public final class LazyInitSync implements Singleton {
  
  private static LazyInitSync _instance;
  
  private LazyInitSync() { }
  
  public static synchronized LazyInitSync getInstance() {
    if (_instance == null)
      _instance = new LazyInitSync();
    return _instance;
  }
}