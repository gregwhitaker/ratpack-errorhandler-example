package com.github.gregwhitaker.ratpackerrorhandler.example.core.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.error.internal.ErrorHandler;
import ratpack.handling.Context;

import java.util.ArrayList;
import java.util.List;

public class GlobalErrorHandler implements ErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalErrorHandler.class);

    public GlobalErrorHandler() {
        // TODO: Configure Jackson here
    }

    @Override
    public void error(Context context, int statusCode) throws Exception {
        LOG.debug("Client error");
    }

    @Override
    public void error(Context context, Throwable throwable) throws Exception {
        LOG.debug("Server error");
    }

    /**
     *
     */
    private static class ErrorResponse {
        private int status;
        private String code;
        private String message;
        private String detail;
        private String help;

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
     *
     */
    private static class FieldErrorResponse {
        private int status;
        private String code;
        private String message;
        private String detail;
        private String help;
        private List<FieldError> fieldErrors;

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
     *
     */
    private static class FieldError {
        private String field;
        private String code;
        private String message;
        private String detail;
        private String help;

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
