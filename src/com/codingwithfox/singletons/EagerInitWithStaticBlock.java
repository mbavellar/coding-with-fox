package com.codingwithfox.singletons;

import com.codingwithfox.exceptions.SingletonException;
import com.codingwithfox.interfaces.Singleton;

public final class EagerInitWithStaticBlock implements Singleton {
  private static final EagerInitWithStaticBlock INSTANCE;
  static {
    try {
      INSTANCE = new EagerInitWithStaticBlock();
    } catch (Exception e) {
      // log error
      throw new SingletonException(e.getMessage());
    }
  }
  
  private EagerInitWithStaticBlock() { }
  
  public static EagerInitWithStaticBlock getInstance() { return INSTANCE; }
}