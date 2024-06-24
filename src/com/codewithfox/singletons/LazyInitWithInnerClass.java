package com.codewithfox.singletons;

import com.codewithfox.interfaces.Singleton;

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