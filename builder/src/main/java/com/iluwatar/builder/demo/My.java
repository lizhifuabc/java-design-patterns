package com.iluwatar.builder.demo;

/**
 * My
 *
 * @author lizhifu
 * @date 2022/3/19
 */
public class My {
    private PersionComputerConfigBuilder persionComputerConfigBuilder;
    public My(PersionComputerConfigBuilder persionComputerConfigBuilder){
        this.persionComputerConfigBuilder = persionComputerConfigBuilder;
    }
    public void persion(){
        persionComputerConfigBuilder.setName();
        persionComputerConfigBuilder.setName();
    }
    public Persion02 init(){
        return persionComputerConfigBuilder.getPersion02();
    }
}
