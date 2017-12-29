package com.github.gregwhitaker.ratpackerrorhandler.example.core.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.error.internal.ErrorHandler;
import ratpack.handling.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GlobalErrorHandler implements ErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalErrorHandler.class);

    public GlobalErrorHandler() {
        // TODO: Configure Jackson here
    }

    @Override
    public void error(Context context, int statusCode) throws Exception {
        context.getResponse().status(statusCode).send();
    }

    @Override
    public void error(Context context, Throwable throwable) throws Exception {
        if (throwable instanceof BaseException) {
            LOG.info("Server error");
        } else {
            context.getResponse().status(500);
        }

        context.getResponse().send();
    }

    /**
     * Error response
     */
    private static class ErrorResponse implements Serializable {
        private static final long serialVersionUID = -9089646869966970667L;

        private int status;         // HTTP status code
        private String code;        // Error code
        private String message;     // Error message
        private String detail;      // Detailed error message
        private String help;        // Help URL

        ErrorResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getHelp() {
            return help;
        }

        public void setHelp(String help) {
            this.help = help;
        }
    }

    /**
     * Field-level error response
     */
    private static class FieldErrorResponse implements Serializable {
        private static final long serialVersionUID = 171077544021179023L;

        private int status;                     // HTTP status code
        private String code;                    // Error code
        private String message;                 // Error message
        private String detail;                  // Detailed error message
        private String help;                    // Help URL
        private List<FieldError> fieldErrors;   // Field-level error details

        public FieldErrorResponse(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public synchronized void addFieldError(FieldError fieldError) {
            if (fieldErrors == null) {
                fieldErrors = new ArrayList<>();
            }

            fieldErrors.add(fieldError);
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getHelp() {
            return help;
        }

        public void setHelp(String help) {
            this.help = help;
        }

        public List<FieldError> getFieldErrors() {
            return fieldErrors;
        }

        public void setFieldErrors(List<FieldError> fieldErrors) {
            this.fieldErrors = fieldErrors;
        }
    }

    /**
     * Field-level error details
     */
    private static class FieldError implements Serializable {
        private static final long serialVersionUID = 4451792396257629282L;

        private String field;       // Field name
        private String code;        // Error code
        private String message;     // Error message
        private String detail;      // Detailed error message
        private String help;        // Help URL

        public FieldError(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getHelp() {
            return help;
        }

        public void setHelp(String help) {
            this.help = help;
        }
    }
}
