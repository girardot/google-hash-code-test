package _2015.output;

import _2015.model.ServerOutput;

import java.util.List;

import static java.lang.Integer.compare;

public class Writer {

    public void write(List<ServerOutput> serverOutputs) {

        serverOutputs.sort((o1, o2) -> compare(o1.index, o2.index));

        for (ServerOutput serverOutput : serverOutputs) {
            System.out.println(serverOutput.print());
        }
    }
}
