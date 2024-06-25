package com.mbavellar.singletons;

import com.mbavellar.exceptions.SingletonException;
import com.mbavellar.interfaces.Singleton;

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