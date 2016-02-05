package _2015.process;

import _2015.model.DataCenter;
import _2015.model.Server;
import _2015.model.ServerOutput;
import _2015.model.SlotUnavalable;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.compare;

public class SimpleProcessor implements Processor {

    @Override
    public List<ServerOutput> process(DataCenter dataCenter) {

        int poolIterator = 0;
        int row = 0;
        int slot = 0;

        dataCenter.servers.sort((o1, o2) -> -compare(o1.size, o2.size));

        ArrayList<ServerOutput> serverOutputs = new ArrayList<>();
        int i = 0;
        int serveurRestant = dataCenter.line1.server;

        for (int m = 0; m < 10; m++) {
             row = 0;
             slot = 0;

            for (; i < dataCenter.servers.size();) {
                Server server = dataCenter.servers.get(i);

                for (SlotUnavalable slotUnavalable : dataCenter.slotUnavalables) {
                    if (row != slotUnavalable.row) {
                        continue;
                    }
                    if (slot >= slotUnavalable.slot && slot <= slotUnavalable.slot + server.size) {
                        slot = slotUnavalable.slot + 1;
                    }
                }

                if (slot + server.size > dataCenter.line1.nbSlot) {
                    row += 1;
                    slot = 0;
                }

                if (row > dataCenter.line1.row - 1) {
                    break;
                }

                serverOutputs.add(new ServerOutput(row, slot, poolIterator % dataCenter.line1.nbPool, true, server.index, server.capacity));
                i++;
                for (int k = slot; k < slot + server.size; k++) {
                    dataCenter.slotUnavalables.add(new SlotUnavalable(row, k));
                }
                serveurRestant -= 1;

                slot += server.size;
                poolIterator += 1;
            }


        }

        System.out.println(dataCenter.slotUnavalables);

        for (; i < dataCenter.servers.size(); i++) {
            Server server = dataCenter.servers.get(i);
            serverOutputs.add(new ServerOutput(row, slot, poolIterator % dataCenter.line1.nbPool, false, server.index, server.capacity));
        }



        System.out.println(serverOutputs);
        return serverOutputs;
    }


}
