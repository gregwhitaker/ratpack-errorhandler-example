package com.github.gregwhitaker.ratpackerrorhandler.example.core.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Throwables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ratpack.error.internal.ErrorHandler;
import ratpack.handling.Context;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Error handler responsible for capturing all errors within the application and
 * rendering a standardized error response message.
 */
public class GlobalErrorHandler implements ErrorHandler {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalErrorHandler.class);

    private final ObjectMapper mapper;

    public GlobalErrorHandler() {
        this.mapper = new ObjectMapper();
        this.mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public void error(Context context, int statusCode) throws Exception {
        context.getResponse().status(statusCode).send();
    }

    @Override
    public void error(Context context, Throwable throwable) throws Exception {
        if (throwable instanceof BaseException) {
            LOG.info("Server error");
            context.getResponse().send();
        } else {
            ErrorResponse error = new ErrorResponse(500, "An error occurred. Please contact support.");

            // Expose sensitive information if running in development mode
            if (context.getServerConfig().isDevelopment()) {
                error.setErrorDetail(throwable.getMessage());
                error.setStacktrace(Throwables.getStackTraceAsString(throwable));
            }

            context.getResponse().status(500);
            context.getResponse().send(mapper.writeValueAsString(error));
        }
    }

    /**
     * Error response
     */
    @JsonPropertyOrder(value = {
            "id",
            "status",
            "statusMessage",
            "errorCode",
            "errorMessage",
            "errorDetail",
            "errorDetailUrl",
            "stacktrace"
    })
    private static class ErrorResponse implements Serializable {
        private static final long serialVersionUID = -9089646869966970667L;

        private String id;
        private int status;
        private String errorCode;
        private String errorMessage;
        private String errorDetail;
        private String errorDetailUrl;
        private String stacktrace;


        ErrorResponse(int status, String errorMessage) {
            this.id = UUID.randomUUID().toString();
            this.status = status;
            this.errorMessage = errorMessage;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        @JsonProperty("statusMessage")
        public String getStatusMessage() {
            return HttpStatusMessage.of(status);
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

        public String getStacktrace() {
            return stacktrace;
        }

        public void setStacktrace(String stacktrace) {
            this.stacktrace = stacktrace;
        }
    }

    /**
     * Field-level error response
     */
    @JsonPropertyOrder(value = {
            "id",
            "status",
            "statusMessage",
            "errorCode",
            "errorMessage",
            "errorDetail",
            "errorDetailUrl",
            "fieldErrors",
            "stacktrace"
    })
    private static class FieldErrorResponse implements Serializable {
        private static final long serialVersionUID = 171077544021179023L;

        private String id;
        private int status;
        private String errorCode;
        private String errorMessage;
        private String errorDetail;
        private String errorDetailUrl;
        private List<FieldError> fieldErrors;
        private String stacktrace;

        public FieldErrorResponse(int status, String errorMessage) {
            this.id = UUID.randomUUID().toString();
            this.status = status;
            this.errorMessage = errorMessage;
        }

        public synchronized void addFieldError(FieldError fieldError) {
            if (fieldErrors == null) {
                fieldErrors = new ArrayList<>();
            }

            fieldErrors.add(fieldError);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        @JsonProperty("statusMessage")
        public String getStatusMessage() {
            return HttpStatusMessage.of(status);
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

        public List<FieldError> getFieldErrors() {
            return fieldErrors;
        }

        public void setFieldErrors(List<FieldError> fieldErrors) {
            this.fieldErrors = fieldErrors;
        }

        public String getStacktrace() {
            return stacktrace;
        }

        public void setStacktrace(String stacktrace) {
            this.stacktrace = stacktrace;
        }
    }

    /**
     * Field-level error details
     */
    private static class FieldError implements Serializable {
        private static final long serialVersionUID = 4451792396257629282L;

        private String field;
        private String errorCode;
        private String errorMessage;
        private String errorDetail;
        private String errorDetailUrl;

        public FieldError(String field) {
            this.field = field;
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
