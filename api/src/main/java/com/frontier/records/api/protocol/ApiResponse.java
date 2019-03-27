package com.frontier.records.api.protocol;

import java.io.Serializable;
import lombok.Getter;
import lombok.ToString;

@SuppressWarnings("CheckStyle")
@ToString
@Getter
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 572658916920532531L;

    public static final ApiResponse EMPTY = new ApiResponse<>(null);

    private boolean successful;
    private String message;
    private T result;

    public ApiResponse(T result) {
        this.successful = true;
        this.message = null;
        this.result = result;
    }

    public ApiResponse(boolean successful, String message, T result) {
        this.successful = successful;
        this.message = message;
        this.result = result;
    }
}
