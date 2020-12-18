package de.zlucic.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String messsage;
    private String details;

    public ExceptionResponse(Date timestamp, String messsage, String details) {
        this.timestamp = timestamp;
        this.messsage = messsage;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMesssage() {
        return messsage;
    }

    public String getDetails() {
        return details;
    }
}
