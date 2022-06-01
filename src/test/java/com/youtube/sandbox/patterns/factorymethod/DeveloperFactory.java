package com.youtube.sandbox.patterns.factorymethod;

public class DeveloperFactory {

    public Developer getDeveloper(String devType) {
        if(devType.equals("JavaDeveloper")) {
            return new JavaDeveloper();
        } if (devType.equals("CppDeveloper")) {
            return new CppDeveloper();
        } else {
            throw new RuntimeException("Unknown developer type");
        }
    }
}
