package com.daemon.common;

public enum Model {
    HUAWEI(0),
    OPPO(1),
    VIVO(2),
    XIAO(3),
    MEIZU(4),
    SAMSUNG(5);
    
    public int model;

    Model(int i2) {
        this.model = i2;
    }

    public int getModel() {
        return this.model;
    }
}
