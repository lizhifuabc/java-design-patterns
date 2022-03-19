package com.iluwatar.builder.demo;

/**
 * MyConfigBuilder
 *
 * @author lizhifu
 * @date 2022/3/19
 */
public class MyConfigBuilder implements PersionComputerConfigBuilder{
    private Persion02 persion02;

    public MyConfigBuilder(){
        this.persion02 = new Persion02();
    }
    @Override
    public void setSex() {
        persion02.setSex(Sex.MAN);
    }

    @Override
    public void setName() {
        persion02.setName("小明");
    }

    @Override
    public Persion02 getPersion02() {
        return persion02;
    }
}
