package _2017.output;

import _2017.model.FakeModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    public void write(List<FakeModel> models, String pathname) throws IOException {
        try (FileWriter writer = new FileWriter(new File(pathname))) {

            Integer nbInstruction = 1;
            writer.write(nbInstruction + "\n");
            for (FakeModel model : models) {
                model.write(writer);
            }
        }

    }
}
