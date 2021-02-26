package com.innowise.duvalov.config;

import lombok.Getter;

@Getter
public enum UserInputConfig {
    MAX_LOGIN(25),
    MAX_PASS(100),
    MAX_EMAIL(65),
    HASH_PASS_ITERATIONS(256);

    private int value;

    UserInputConfig(int value) {
        this.value = value;
    }
}
