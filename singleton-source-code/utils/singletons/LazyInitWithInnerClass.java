package com.codingwithfox.singletons;

import com.codingwithfox.interfaces.Singleton;

public final class LazyInitWithInnerClass implements Singleton {
  
  private LazyInitWithInnerClass() { }
  
  private static final class InstanceHolder {
    private static final LazyInitWithInnerClass INSTANCE =
      new LazyInitWithInnerClass();
  }
  
  public static LazyInitWithInnerClass getInstance() {
    return InstanceHolder.INSTANCE;
  }
}