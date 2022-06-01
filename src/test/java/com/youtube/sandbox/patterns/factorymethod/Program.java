package com.youtube.sandbox.patterns.factorymethod;

public class Program {

    public static void main(String[] args) {
        DeveloperFactory factory = new DeveloperFactory();
        Developer developer = factory.getDeveloper("JavaDeveloper");
        developer.writeCode();
    }
}
