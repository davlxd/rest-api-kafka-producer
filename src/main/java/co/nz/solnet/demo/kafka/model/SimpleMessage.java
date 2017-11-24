package co.nz.solnet.demo.kafka.model;

public class SimpleMessage {
    private String message;

    public SimpleMessage() {
    }

    public SimpleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SimpleMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
