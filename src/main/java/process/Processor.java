package process;

import model.DataCenter;
import model.ServerOutput;

import java.util.List;

public interface Processor {

    List<ServerOutput> process(DataCenter dataCenter);


}
