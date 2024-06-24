package com.codewithfox.singletons;

import com.codewithfox.interfaces.Singleton;
import java.io.Serial;

public final class EagerInit implements Singleton {
  
  private static final EagerInit INSTANCE = new EagerInit();
  
  private EagerInit() {
    Singleton.checkDoubleInstance(INSTANCE);
  }
  
  public static EagerInit getInstance() {
    return INSTANCE;
  }
  
  @Serial
  private Object readResolve() {
    return getInstance();
  }
}