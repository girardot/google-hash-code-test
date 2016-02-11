package _2016.output;

import _2016.model.Drone;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    public void write(List<Drone> drones, String pathname) throws IOException {
        try (FileWriter writer = new FileWriter(new File(pathname))) {

            Integer reduce = drones.stream().map(Drone::numberInstructions).reduce(0, Integer::sum);
            writer.write(reduce + "\n");
            for (Drone drone : drones) {
                drone.write(writer);
            }
        }

    }
}
