package com.demo2do.core.web.ajax;

/**
 * Status object of a ajax call
 */
public class Status {

    private String code;

    private String message;

    /**
     * default constructor
     */
    public Status() {

    }

    /**
     * constructor using code
     *
     * @param code
     */
    public Status(String code) {
        this.code = code;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
