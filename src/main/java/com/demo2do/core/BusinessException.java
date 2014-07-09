package com.demo2do.core;

/**
 * Business Exception
 */
public class BusinessException extends RuntimeException {

    private String targetURL;

    /**
     * default constructor
     *
     * @param message
     */
    public BusinessException(String message) {
        super(message);
    }

    /**
     * full constructor
     *
     * @param message
     * @param targetURL
     */
    public BusinessException(String message, String targetURL) {
        super(message);
        this.targetURL = targetURL;
    }

    /**
     * @return the targetURL
     */
    public String getTargetURL() {
        return targetURL;
    }

}

