package com.mbavellar;

import com.mbavellar.singletons.EagerInit;
import com.mbavellar.singletons.EagerInitWithStaticBlock;
import com.mbavellar.singletons.EagerEnum;
import com.mbavellar.interfaces.Singleton;
import com.mbavellar.singletons.LazyInit;
import com.mbavellar.singletons.LazyInitWithDCL;
import com.mbavellar.singletons.LazyInitWithInnerClass;
import com.mbavellar.singletons.LazyInitSync;
import com.mbavellar.utils.Metrics;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
  
  public static void main(String[] args) {
//    lazyInit();
//    lazyInitSync();
//    lazyInitWithDCL();
//    lazyInitWithInnerClass();
//    eagerInit();
//    eagerInitWithStaticBlock();
//    eagerEnum();
//    serializationProblem(EagerEnum.getInstance());
//    reflectionAttack(EagerEnum.getInstance());
  }
  
  private static void reflectionAttack(Singleton singleton) {
    runSingleton(singleton);
    try {
      var attack = singleton.getClass().getDeclaredConstructor();
      attack.setAccessible(true);
      var Secondinstance = attack.newInstance();
      System.out.println(Secondinstance);
    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }
  
  private static void serializationProblem(Singleton instance) {
    serialize(instance);
    deserialize(instance);
  }
  
  private static void eagerEnum() {
    runSingleton(EagerEnum.getInstance());
  }
  
  private static void eagerInitWithStaticBlock() {
    runSingleton(EagerInitWithStaticBlock.getInstance());
  }
  
  private static void eagerInit() {
    runSingleton(EagerInit.getInstance());
  }
  
  private static void lazyInitWithInnerClass() {
    runSingleton(LazyInitWithInnerClass.getInstance());
  }
  
  private static void lazyInitWithDCL() {
    runSingleton(LazyInitWithDCL.getInstance());
  }
  
  private static void lazyInitSync() {
    runSingleton(LazyInitSync.getInstance());
  }
  
  private static void lazyInit() {
    runSingleton(LazyInit.getInstance());
  }
  
  private static <T extends Singleton> void runSingleton(T singleton) {
    Metrics.setStartingTime();
    Runnable runnable = () -> {
      System.out.println(singleton);
    };
    
    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
    }
    Metrics.printResults();
  }
  
  public static <T extends Singleton> void serialize(T singleton) {
    System.out.print("Singleton before being serialized: ");
    System.out.println(singleton);
    
    try (ObjectOutputStream oos = new ObjectOutputStream(
      new FileOutputStream(singleton.getClass().getSimpleName() + ".obj"))) {
      
      oos.writeObject(singleton);
      System.out.println("Serialization done.");
      
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
  
  public static <T extends Singleton> void deserialize(T singleton) {
    
    try (ObjectInputStream ois = new ObjectInputStream(
      new FileInputStream(singleton.getClass().getSimpleName() + ".obj"))) {
      
      System.out.print("Singleton after being deserialized: ");
      System.out.println(singleton.castToSinglton(ois.readObject()));
      
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
}