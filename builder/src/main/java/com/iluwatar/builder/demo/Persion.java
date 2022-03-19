package com.iluwatar.builder.demo;

/**
 * 人
 *
 * @author lizhifu
 * @date 2022/3/19
 */
public final class Persion {
    private final Sex sex;
    private final String name;
    private final Profession profession;
    private Persion(Builder builder){
        this.sex = builder.sex;
        this.name = builder.name;
        this.profession = builder.profession;
    }
    public static class Builder {
        private final Sex sex;
        private final String name;
        private Profession profession;

        public Builder(Sex sex,String name){
            this.sex = sex;
            this.name = name;
        }
        public Builder withProfession(Profession profession) {
            this.profession = profession;
            return this;
        }
        public Persion builder(){
            return new Persion(this);
        }
    }
}
