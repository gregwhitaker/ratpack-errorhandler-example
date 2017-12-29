package com.github.gregwhitaker.ratpackerrorhandler.example.core.error;

public class UnsupportedActiveFlagException extends BaseFieldException {

    public UnsupportedActiveFlagException() {
        super(400, "4321", "Validation Exception");
        addField("active", "4321-1","Value must be either 'true' or 'false'.");
    }
}
