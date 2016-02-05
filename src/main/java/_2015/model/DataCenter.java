package _2015.model;

import java.util.List;

public class DataCenter {

    public final Line1 line1;
    public final List<Server> servers;
    public final List<SlotUnavalable> slotUnavalables;

    public DataCenter(Line1 line1, List<Server> servers, List<SlotUnavalable> slotUnavalables) {
        this.line1 = line1;
        this.servers = servers;
        this.slotUnavalables = slotUnavalables;
    }

    @Override
    public String toString() {
        return "DataCenter{" +
                "line1=" + line1 +
                ", slotUnavalables=" + slotUnavalables +
                ", servers=" + servers +
                '}';
    }

}
