package com.codingwithfox.utils;

public final class Metrics {
  private static long start;
  
  private Metrics() {}
  
  public static void setStartingTime() {
    setStart(System.nanoTime());
  }
  
  private static String getExecutionTime() {
    return (System.nanoTime() - getStart()) / 1_000 + " microseconds.";
  }
  
  private static String getTotalMemoryUsed() {
    return String.format("%.2f KB", (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024.0);
  }
  
  public static void printResults() {
    System.out.println(getExecutionTime());
    System.out.println(getTotalMemoryUsed());
  }
  
  private static long getStart() { return Metrics.start; }
  private static void setStart(long start) { Metrics.start = start; }
}

