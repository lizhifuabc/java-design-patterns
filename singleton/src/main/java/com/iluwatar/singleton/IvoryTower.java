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
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 *
 * 类加载时就初始化实例，避免了多线程同步问题。天然线程安全。
 */
public final class IvoryTower {

  /**
   * Private constructor so nobody can instantiate the class.
   *
   * 私有构造函数，因此没有人可以实例化该类。
   */
  private IvoryTower() {
  }

  /**
   * Static to class instance of the class.
   */
  private static final IvoryTower INSTANCE = new IvoryTower();

  /**
   * To be called by user to obtain instance of the class.
   *
   * 获取类的实例。
   * @return instance of the singleton.
   */
  public static IvoryTower getInstance() {
    return INSTANCE;
  }
}
