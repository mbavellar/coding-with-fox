package com.mbavellar.singletons;

import com.mbavellar.interfaces.Singleton;

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