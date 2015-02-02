package oop;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventBusTest {

    @Test
    public void testAddListener() throws Exception {
        EventBus bus = new EventBus();
        assertEquals(0, bus.receivers.size());
        bus.addListener("HalloEvent", new EventListener() {
            @Override
            public void receive(Event event) {
                
            }
        });
        assertEquals(1, bus.receivers.size());
    }

    @Test
    public void testEmit() throws Exception {
        EventBus bus = new EventBus();
        TestEventListener eventListener = new TestEventListener();
        bus.addListener("TestEvent", eventListener);
        bus.emit(new Event("TestEvent"));
        assertEquals(1, eventListener.counter);
    }

    @Test
    public void testEmitWithPayload() throws Exception {
        EventBus bus = new EventBus();
        TestEventListener eventListener = new TestEventListener();
        TestEventListener notReacting = new TestEventListener();
        bus.addListener("TestEvent", eventListener);
        bus.addListener("NoReactionEvent", notReacting);
        String payLoad = "holdrio";
        bus.emit(new Event("TestEvent", payLoad));
        assertEquals(1, eventListener.counter);
        assertEquals(0, notReacting.counter);
        assertSame(payLoad, eventListener.payLoad);
    }
    
    public static class TestEventListener implements EventListener {
        
        protected int counter = 0;
        protected Object payLoad = null;
        
        @Override
        public void receive(Event event) {
            payLoad = event.getPayload();
            counter++;
        }
    }
}