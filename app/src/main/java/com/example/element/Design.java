package com.example.element;

public class Design {
    private String cause;
    private String explanation;

    public Design(String cause, String explanation) {
        this.cause = cause;
        this.explanation = explanation;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

}
