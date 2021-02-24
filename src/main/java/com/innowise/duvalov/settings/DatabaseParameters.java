package com.innowise.duvalov.settings;

import lombok.Getter;

@Getter
public enum DatabaseParameters {
    MAX_LOGIN(25),
    MAX_PASS(100),
    MAX_EMAIL(65);

    private int size;

    DatabaseParameters(int size) {
        this.size = size;
    }
}
