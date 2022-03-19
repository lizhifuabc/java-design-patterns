package com.iluwatar.builder.demo;

/**
 * PersionApp
 *
 * @author lizhifu
 * @date 2022/3/19
 */
public class PersionApp {
    public static void main(String[] args) {
        Persion persion = new Persion.Builder(Sex.MAN,"小明")
                .withProfession(Profession.IT)
                .builder();
        System.out.println(persion.toString());
    }
}
