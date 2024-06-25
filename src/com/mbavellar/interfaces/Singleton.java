package com.mbavellar.interfaces;

import com.mbavellar.singletons.EagerInit;
import com.mbavellar.singletons.EagerInitWithStaticBlock;
import com.mbavellar.singletons.EagerEnum;
import com.mbavellar.utils.FILE_TYPE;
import com.mbavellar.singletons.LazyInit;
import com.mbavellar.singletons.LazyInitWithDCL;
import com.mbavellar.singletons.LazyInitWithInnerClass;
import com.mbavellar.singletons.LazyInitSync;

import java.io.*;

public interface Singleton extends Serializable {
  
  /**
   * Serializes this instance @this and saves it as the provided type in the provided folder
   * or in the #src folder should none be provided.
   * Files are named over the class name.
   * @param path the filepath where the file should be saved. #src if none is provided.
   * @param type the extension type of the file to be saved, such as .obj, .dat, .bin.
   */
  default void selfSerialize(String path, FILE_TYPE type) {
    
    System.out.print("Singleton before being serialized: ");
    System.out.println(this);
    
    try (ObjectOutputStream oos = new ObjectOutputStream(
      new FileOutputStream(path + this.getClass().getSimpleName() + type))) {
      
      oos.writeObject(this);
      
      System.out.println("Serialization done.");
      
    } catch (IOException e) { System.out.println(e.getMessage()); }
  }
  
  /**
   * Calls the overloaded version selfSerializable with
   * @path="" and
   * @FILE_TYPE.OBJECT as it will be saved as .obj.
   */
  default void selfSerialize() {
    selfSerialize("", FILE_TYPE.OBJECT);
  }
  
  /**
   * Deserializes this instance @this and casts it to its orinial type.
   * If no path is provided, the #src folder will be used as default.
   * Files are named over the class name.
   * @param path the filepath where the file should be saved. #src if none is provided.
   * @param type the extension type of the file to be saved, such as .obj, .dat, .bin.
   */
  default void selfDeserialize(String path, FILE_TYPE type) {
    
    try (ObjectInputStream ois = new ObjectInputStream(
      new FileInputStream(this.getClass().getSimpleName() + ".obj"))) {
      
      var singleton = castToSinglton(ois.readObject());
      System.out.print("Singleton after being deserialized: ");
      System.out.println(singleton);
      
    } catch (IOException | ClassNotFoundException e) { System.out.println(e.getMessage()); }
  }
  
  /**
   * Calls the overloaded version selfDeserializable with
   * @path="" and
   * @FILE_TYPE.OBJECT as it will be saved as .obj.
   */
  default void selfDeserialize() {
    selfDeserialize("", FILE_TYPE.OBJECT);
  }
  
  default Singleton castToSinglton(Object obj) {
    return switch (obj) {
      case LazyInit lazy -> lazy;
      case LazyInitSync syncLazy -> syncLazy;
      case LazyInitWithDCL lazyDoubleLock -> lazyDoubleLock;
      case LazyInitWithInnerClass lazyInnerClass -> lazyInnerClass;
      case EagerInit eager -> eager;
      case EagerInitWithStaticBlock eagerWithStaticBlock -> eagerWithStaticBlock;
      case EagerEnum enumSingleton -> enumSingleton;
      default -> throw new IllegalArgumentException("Object in file is not of type Singleton: " + obj.getClass().getName());
    };
  }
  
  static void checkDoubleInstance(Singleton instance) {
    if (instance != null)
      throw new IllegalStateException("Access to constructor is denied because an instance already exists.");
  }
}
