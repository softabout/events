package oop;

import org.junit.Test;
import static org.junit.Assert.*;

public class CallAgencyTest {
    
    @Test
    public void test() throws Exception {
        EventBus bus = new EventBus();
        CallAgency callAgency = new CallAgency();
        callAgency.registerAgency(bus);
        LocalCallCenter hamburg = new LocalCallCenter("040");
        hamburg.registerLocalCallCenter(bus);
        LocalCallCenter berlin = new LocalCallCenter("030");
        berlin.registerLocalCallCenter(bus);
        
        bus.emit(new Event("IncomingCall", "030/1234"));
        assertEquals(1, callAgency.callAgencyLog.numbersReceived.size());
        assertEquals(1, berlin.localCallCenterLog.numbersReceived.size());
        assertEquals(0, hamburg.localCallCenterLog.numbersReceived.size());
    } 
        
}
