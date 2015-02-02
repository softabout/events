package oop;

public class CallAgency {
    
    protected StatisticsLog callAgencyLog = new StatisticsLog();
    
    public void registerAgency(EventBus bus) {
        bus.addListener("IncomingCall", callAgencyLog);
    }
}
