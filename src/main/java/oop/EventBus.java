package oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {
    
    protected Map<String, List<EventListener>> receivers = new HashMap<String, List<EventListener>>(); 
    
    public void addListener(String eventName, EventListener eventListener) {
        if (!receivers.containsKey(eventName))  {
            receivers.put(eventName, new ArrayList<EventListener>());
        }
        receivers.get(eventName).add(eventListener);
    }
    
    public void emit(Event event) {
        if (receivers.containsKey(event.getName())) {
            for (EventListener eventListener : receivers.get(event.getName())) {
                eventListener.receive(event);
            }
        }
    }
}
