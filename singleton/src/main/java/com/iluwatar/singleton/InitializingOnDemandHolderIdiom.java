/*
 * The MIT License
 * Copyright © 2014-2021 Ilkka Seppälä
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
 * <p>The Initialize-on-demand-holder idiom is a secure way of creating a lazy initialized singleton
 * object in Java.</p>
 *
 * <p>按需加载的方式，懒汉</p>
 *
 * <p>The technique is as lazy as possible and works in all known versions of Java. It takes
 * advantage of language guarantees about class initialization, and will therefore work correctly
 * in all Java-compliant compilers and virtual machines.</p>
 *
 * <p>The inner class is referenced no earlier (and therefore loaded no earlier by the class loader)
 * than the moment that getInstance() is called. Thus, this solution is thread-safe without
 * requiring special language constructs (i.e. volatile or synchronized).</p>
 *
 * <p>提供了一个不依赖 java 版本和一些关键字的方式来实现线程安全的单例模式</p>
 */
public final class InitializingOnDemandHolderIdiom {

  /**
   * Private constructor.
   *
   * 私有构造函数，因此没有人可以实例化该类。
   */
  private InitializingOnDemandHolderIdiom() {
  }

  /**
   * Singleton instance.
   *
   * 单例实例化。
   * @return Singleton instance
   */
  public static InitializingOnDemandHolderIdiom getInstance() {
    return HelperHolder.INSTANCE;
  }

  /**
   * Provides the lazy-loaded Singleton instance.
   *
   * 提供延迟加载的单例实例。
   * 内部类可以延时加载。如果直接使用静态变量，因为加载子类等其它原因对实例进行了初始化，而此时并不需要该类的实例，造成了资源的浪费。
   */
  private static class HelperHolder {
    /**
     * static 强调只有一份，final 说明是一个常量
     */
    private static final InitializingOnDemandHolderIdiom INSTANCE =
        new InitializingOnDemandHolderIdiom();
  }
}
