package process;

import model.DataCenter;
import model.Server;
import model.ServerOutput;

import java.util.ArrayList;
import java.util.List;

public class SimpleProcessor implements Processor {

    @Override
    public List<ServerOutput> process(DataCenter dataCenter) {

        int poolIterator = 0;
        int row = 0;
        int slot = 0;

        ArrayList<ServerOutput> serverOutputs = new ArrayList<>();


        for (Server server : dataCenter.servers) {

            if (slot + server.size <dataCenter.line1.nbSlot ) {
                row +=1;
                slot = 0;
            }
            serverOutputs.add(new ServerOutput(row, slot, poolIterator % dataCenter.line1.nbPool, true));
            slot += server.size;
        }

        System.out.println(serverOutputs);
        return serverOutputs;
    }



}
