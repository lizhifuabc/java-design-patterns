package com.iluwatar.builder.demo;

/**
 * PersionApp
 *
 * @author lizhifu
 * @date 2022/3/19
 */
public class PersionApp02 {
    public static void main(String[] args) {
        My my = new My(new MyConfigBuilder());
        my.init();
        my.persion();
    }
}
