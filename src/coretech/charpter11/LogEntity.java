package coretech.charpter11;

import java.util.Date;

public class LogEntity {
    private LogLevel level;
    private Date date;
    private String message;
    private Throwable exception;

    public LogEntity() {
        super();
    }

    @Override
    public String toString() {
        return new LogEntityStringBuilder()
                .level(this.level)
                .date(this.date)
                .mesg(this.message)
                .exceptionStackTrace(this.exception)
                .build();
    }

    public LogEntity(LogLevel level, String message, Throwable exception) {
        super();
        this.level = level;
        this.date = new Date();
        this.message = message;
        this.exception = exception;
    }

    public LogEntity(LogLevel level, Date date, String message, Throwable exception) {
        super();
        this.level = level;
        this.date = date;
        this.message = message;
        this.exception = exception;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public static class LogEntityStringBuilder {
        private String logEntityString;

        public LogEntityStringBuilder() {
            this.logEntityString = "{";
        }

        public LogEntityStringBuilder level(LogLevel level) {
            this.logEntityString += "\n\t\"level\":\"" + level.toString() + "\",";
            return this;
        }

        public LogEntityStringBuilder date(Date date) {
            this.logEntityString += "\n\t\"time\":\"" + date.toString() + "\",";
            return this;
        }

        public LogEntityStringBuilder mesg(String message) {
            this.logEntityString += "\n\t\"message\":\"" + message + "\",";
            return this;
        }

        public LogEntityStringBuilder exceptionStackTrace(Throwable e) {
            this.logEntityString += "\n\t\"exception\":\"" + e.getClass().getName() + " " + e.getMessage() + "\",";
            this.logEntityString += "\n\t\"stackTrace\":[";
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (int i = 0; i < stackTraceElements.length; i++) {
                this.logEntityString += "\n\t\t\"" + stackTraceElements[i].toString() + "\",";
            }
            endProcess("\n\t", "],");
            return this;
        }

        public String endProcess(String formatSpace, String endTag) {
            int lastIndex = this.logEntityString.length() - 1;
            if (this.logEntityString.charAt(lastIndex) == ',') {
                this.logEntityString = this.logEntityString.substring(0, lastIndex) + formatSpace + endTag;
            } else {
                this.logEntityString = this.logEntityString + endTag;
            }
            return this.logEntityString;
        }

        /*
         * Here is a bug in the following code: If return the expression directory, the new value with endTag hasn't
         * assigned to the logEntityString variable actually. so, when finish the method call, you will find that the
         * logEntityString didn't changed as you expected. public String endProcess(String formatSpace, String endTag) {
         * int lastIndex = this.logEntityString.length() - 1; if (this.logEntityString.charAt(lastIndex) == ',') {
         * return this.logEntityString.substring(0, lastIndex) + formatSpace + endTag; } else { return
         * this.logEntityString + endTag; } }
         */

        public String build() {
            return endProcess("\n", "}").replace("\\", "\\\\");
        }
    }
}
