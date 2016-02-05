package _2015.process;

import _2015.model.DataCenter;
import _2015.model.ServerOutput;

import java.util.List;

public interface Processor {

    List<ServerOutput> process(DataCenter dataCenter);


}
