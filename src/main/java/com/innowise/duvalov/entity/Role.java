package com.innowise.duvalov.entity;

import lombok.Getter;

@Getter
public enum Role {
    Client(0),
    Admin(1),

    UNSUPPORTED_INDEX(-1);

    Role(int roleNumber) {
        this.roleNumber = roleNumber;
    }
    private final int roleNumber;

    public static Role getRoleByNumber(int roleNumber){
        for (Role role : Role.values()){
            if(role.roleNumber == roleNumber){
                return role;
            }
        }
        return UNSUPPORTED_INDEX;
    }
}
