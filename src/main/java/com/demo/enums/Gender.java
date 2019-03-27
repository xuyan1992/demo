package com.demo.enums;

/**
 * Created by Administrator on 2019/2/18.
 */
public enum Gender {
    MALE(1,"MALE"),
    FEMALE(2,"FEMALE");

    private Integer code;
    private String name;
    private Gender(int code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static Gender parseName(String name){
        for(Gender g: Gender.values()){
            if(g.name.equalsIgnoreCase(name)){
                return  g;
            }
        }
        return null;
    }
}
