package models;

public class Message {
    private String message;
    private Throwable cause;
    private User user;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public Message(User user, String message){
        this.message = message;
        this.user = user;
    }

    public Message(Throwable cause, String message){
        this.cause = cause;
        this.message = message;
    }



    @Override
    public String toString(){
        if (user == null){
            return message + cause.getMessage();
        }
        return user.getUsername() + " : " + message;
    }
}
