package com.mbavellar.singletons;

import com.mbavellar.interfaces.Singleton;

public final class LazyInitWithDCL implements Singleton {
  
  // The volatile keyword ensures that multiple threads handle
  // the instance variable correctly when it is being initialized.
  private static volatile LazyInitWithDCL _instance;
  
  private LazyInitWithDCL() {
    if (_instance != null)
      throw new IllegalStateException("Tried to access the constructor illigally!");
  }
  
  public static LazyInitWithDCL getInstance() {
    if (_instance == null)
      synchronized (LazyInitWithDCL.class) {
        if (_instance == null) // Double-checking for null
          _instance = new LazyInitWithDCL();
      }
    return _instance;
  }
}