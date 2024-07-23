package com.ilog.lib.constant;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN("ADMIN"), SUPER_ADMIN("SUPER_ADMIN"), USER("USER"), GUEST("GUEST");

    private String value;

    Role(String value){
        this.value = value;
    }


    public boolean isAdmin(){
        return value.contains("ADMIN");
    }

}
