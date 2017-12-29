package com.github.gregwhitaker.ratpackerrorhandler.example.core.error;

import java.util.List;

public abstract class BaseFieldException extends Throwable {
    private int status = 500;
    private String errorCode;
    private String errorMessage = "An error occurred. Please contact support.";
    private String errorDetail;
    private String errorDetailUrl;
    private List<FieldExceptionDetail> fieldErrors;

    public BaseFieldException() {
        // Noop
    }

    public BaseFieldException(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage, String errorDetail) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage, String errorDetail, String errorDetailUrl) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
        this.errorDetailUrl = errorDetailUrl;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public String getErrorDetailUrl() {
        return errorDetailUrl;
    }

    public void setErrorDetailUrl(String errorDetailUrl) {
        this.errorDetailUrl = errorDetailUrl;
    }

    public List<FieldExceptionDetail> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldExceptionDetail> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }

    public static class FieldExceptionDetail {
        private String field;
        private String errorCode;
        private String errorMessage;
        private String errorDetail;
        private String errorDetailUrl;

        public FieldExceptionDetail(String field, String errorMessage) {
            this.field = field;
            this.errorMessage = errorMessage;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorDetail() {
            return errorDetail;
        }

        public void setErrorDetail(String errorDetail) {
            this.errorDetail = errorDetail;
        }

        public String getErrorDetailUrl() {
            return errorDetailUrl;
        }

        public void setErrorDetailUrl(String errorDetailUrl) {
            this.errorDetailUrl = errorDetailUrl;
        }
    }
}
