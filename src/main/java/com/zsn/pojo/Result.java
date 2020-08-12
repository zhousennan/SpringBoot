package com.zsn.pojo;

public class Result<T> {
    private int status;
    private String massage;
    private T object;

    public Result() {
    }

    public Result(int status, String massage, T object) {
        this.status = status;
        this.massage = massage;
        this.object = object;
    }

    public Result(int status, String massage) {
        this.status = status;
        this.massage = massage;
    }

    public Result(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public enum ResultStatus{
       SUCCESS(200),FAILD(500) ;
        public int status;
        ResultStatus(int status) {
            this.status = status;
        }
    }

}
