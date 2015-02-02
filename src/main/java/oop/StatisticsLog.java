package oop;

import java.util.ArrayList;
import java.util.List;

public class StatisticsLog implements EventListener {
    
    protected List<String> numbersReceived = new ArrayList<String>();
    
    @Override
    public void receive(Event event) {
        this.numbersReceived.add(event.getPayload().toString());
    }
}
