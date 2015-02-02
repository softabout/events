package oop;

public class Event {
    
    private String name;
    private Object payload;


    public Event(String name, Object payload) {
        this.name = name;
        this.payload = payload;
    }

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object getPayload() {
        return payload;
    }
}
