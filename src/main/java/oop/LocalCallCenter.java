package oop;

public class LocalCallCenter {

    protected StatisticsLog localCallCenterLog = null;

    public LocalCallCenter(String reactTo) {
        this.localCallCenterLog = new LocalCallCenterStatiticsLog(reactTo);
    }

    public void registerLocalCallCenter(EventBus bus) {
        bus.addListener("IncomingCall", localCallCenterLog);
    }
    
    private static class LocalCallCenterStatiticsLog extends StatisticsLog {
        private String filter;

        public LocalCallCenterStatiticsLog(String filter) {
            this.filter = filter;
        }

        @Override
        public void receive(Event event) {
            if (event.getPayload().toString().startsWith(this.filter)) {
                super.receive(event);
            }
        }
    } 
}
