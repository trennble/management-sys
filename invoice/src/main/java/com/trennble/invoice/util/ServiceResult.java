package com.trennble.invoice.util;

public class ServiceResult<T> {

    public static final int STATE_SUCCESS = 0;
    public static final int STATE_APP_EXCEPTION = 1;
    public static final int STATE_EXCEPTION = 2;
    public static final int STATE_NO_SESSION = 3;

    public static ServiceResult<String> noSession = new ServiceResult<>("Session失效，请重新登录!", STATE_NO_SESSION, false);

    private T result;

    private boolean success;

    private int state;

    public ServiceResult() {
    }

    public ServiceResult(T result, int state) {
        this.result = result;
        this.state = state;
    }


    public ServiceResult(T result, int state, boolean success) {
        super();
        this.result = result;
        this.success = success;
        this.state = state;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static <T> ServiceResult<T> success(T result) {
        return new ServiceResult<>(result, STATE_SUCCESS, true);
    }

    public static <T> ServiceResult<T> fail(T result) {
        return new ServiceResult<>(result, STATE_EXCEPTION, false);
    }

}
