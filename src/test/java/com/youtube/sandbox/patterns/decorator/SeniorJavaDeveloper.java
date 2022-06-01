package com.youtube.sandbox.patterns.decorator;

public class SeniorJavaDeveloper extends DeveloperDecorator {

    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }

    public String makeCodeReview(){
        return "Making code review";
    }

    @Override
    public String makeJob() {
        return makeJob() + makeCodeReview();
    }
}
