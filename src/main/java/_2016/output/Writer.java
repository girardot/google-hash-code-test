package _2016.output;

import _2016.model.Drone;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Writer {

    public void write(List<Drone> drones, OutputStreamWriter outputStream) throws IOException {
        try (OutputStreamWriter writer = outputStream) {
            Integer reduce = drones.stream().map(d -> d.instructions.size()).reduce(0, Integer::sum);
            writer.write(reduce + "\n");
            for (Drone drone : drones) {
                drone.write(writer);
            }
        }

    }
}
