package com.github.gregwhitaker.ratpackerrorhandler.example.core.error;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFieldException extends Throwable {
    private int status;
    private String errorCode;
    private String errorMessage;
    private String errorDetail;
    private String errorDetailUrl;
    private List<FieldExceptionDetail> fieldErrors;

    public BaseFieldException(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public BaseFieldException(int status, String errorMessage, List<FieldExceptionDetail> fieldErrors) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.fieldErrors = fieldErrors;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage, List<FieldExceptionDetail> fieldErrors) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.fieldErrors = fieldErrors;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage, String errorDetail) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage, String errorDetail, List<FieldExceptionDetail> fieldErrors) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
        this.fieldErrors = fieldErrors;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage, String errorDetail, String errorDetailUrl) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
        this.errorDetailUrl = errorDetailUrl;
    }

    public BaseFieldException(int status, String errorCode, String errorMessage, String errorDetail, String errorDetailUrl, List<FieldExceptionDetail> fieldErrors) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
        this.errorDetailUrl = errorDetailUrl;
        this.fieldErrors = fieldErrors;
    }

    public synchronized void addFieldExceptionDetail(String field, String fieldErrorMessage) {
        if (fieldErrors == null) {
            this.fieldErrors = new ArrayList<>();
        }

        this.fieldErrors.add(new FieldExceptionDetail(field, fieldErrorMessage));
    }

    public synchronized void addFieldExceptionDetail(String field, String fieldErrorCode, String fieldErrorMessage) {
        if (fieldErrors == null) {
            this.fieldErrors = new ArrayList<>();
        }

        FieldExceptionDetail fieldExceptionDetail = new FieldExceptionDetail(field, fieldErrorMessage);
        fieldExceptionDetail.setErrorCode(fieldErrorCode);

        this.fieldErrors.add(fieldExceptionDetail);
    }

    public synchronized void addFieldExceptionDetail(String field, String fieldErrorCode, String fieldErrorMessage, String fieldErrorDetail) {
        if (fieldErrors == null) {
            this.fieldErrors = new ArrayList<>();
        }

        FieldExceptionDetail fieldExceptionDetail = new FieldExceptionDetail(field, fieldErrorMessage);
        fieldExceptionDetail.setErrorCode(fieldErrorCode);
        fieldExceptionDetail.setErrorDetail(fieldErrorDetail);

        this.fieldErrors.add(fieldExceptionDetail);
    }

    public synchronized void addFieldExceptionDetail(String field, String fieldErrorCode, String fieldErrorMessage, String fieldErrorDetail, String fieldErrorDetailUrl) {
        if (fieldErrors == null) {
            this.fieldErrors = new ArrayList<>();
        }

        FieldExceptionDetail fieldExceptionDetail = new FieldExceptionDetail(field, fieldErrorMessage);
        fieldExceptionDetail.setErrorCode(fieldErrorCode);
        fieldExceptionDetail.setErrorDetail(fieldErrorDetail);
        fieldExceptionDetail.setErrorDetailUrl(fieldErrorDetailUrl);

        this.fieldErrors.add(fieldExceptionDetail);
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
