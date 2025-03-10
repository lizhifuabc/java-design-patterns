/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.singleton;

/**
 * <p>Double check locking.</p>
 * <p>双检锁/双重校验锁</p>
 * <p>http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html</p>
 *
 * <p>Broken under Java 1.4.</p>
 *
 * @author mortezaadi@gmail.com
 */
public final class ThreadSafeDoubleCheckLocking {

  private static volatile ThreadSafeDoubleCheckLocking instance;

  /**
   * private constructor to prevent client from instantiating.
   * 防止客户端实例化的私有构造函数。
   */
  private ThreadSafeDoubleCheckLocking() {
    // to prevent instantiating by Reflection call
    // 防止通过反射调用实例化
    if (instance != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * Public accessor.
   *
   * @return an instance of the class.
   */
  public static ThreadSafeDoubleCheckLocking getInstance() {
    // local variable increases performance by 25 percent
    // Joshua Bloch "Effective Java, Second Edition", p. 283-284
    // volatile 关键字的原因，使用局部变量会提高性能
    var result = instance;
    // Check if singleton instance is initialized.
    // If it is initialized then we can return the instance.
    if (result == null) {
      // It is not initialized but we cannot be sure because some other thread might have
      // initialized it in the meanwhile.
      // So to make sure we need to lock on an object to get mutual exclusion.
      // 并发下，此时判断是不准确的，所以进行加锁 synchronized
      synchronized (ThreadSafeDoubleCheckLocking.class) {
        // Again assign the instance to local variable to check if it was initialized by some
        // other thread while current thread was blocked to enter the locked zone.
        // If it was initialized then we can return the previously created instance
        // just like the previous null check.
        // 再次对局部变量 result 赋值，因为并发下，有可能多个线程进入了等待
        // 此时进行再次判断，保障只有一个实例被初始化
        result = instance;
        if (result == null) {
          // The instance is still not initialized so we can safely
          // (no other thread can enter this zone)
          // create an instance and make it our singleton instance.
          instance = result = new ThreadSafeDoubleCheckLocking();
        }
      }
    }
    return result;
  }
}
