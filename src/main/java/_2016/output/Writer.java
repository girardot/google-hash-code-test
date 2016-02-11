package _2016.output;

import _2016.model.Drone;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {

    public void write(List<Drone> drones) throws IOException {
        try (PrintWriter writer = new PrintWriter(System.out)) {

            Integer reduce = drones.stream().map(Drone::numberInstructions).reduce(0, Integer::sum);
            writer.write(reduce + "\n");
            for (Drone drone : drones) {
                drone.write(writer);
            }
        }

    }
}
