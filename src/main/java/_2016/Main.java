package _2016;

import _2016.input.InputReader;
import _2016.model.Drone;
import _2016.model.Instruction;
import _2016.model.InstructionType;
import _2016.model.World;
import _2016.output.Writer;
import _2016.process.SimpleProcessor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static _2016.score.ScoreProcessor.computeScore;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader inputReader = new InputReader();
        String[] fileNames = {"busy_day.in", "redundancy.in", "mother_of_all_warehouses.in"};
        for (String fileName : fileNames) {
            World world = inputReader.parse("/" + fileName);
            System.out.println(world);

            SimpleProcessor simpleProcessor = new SimpleProcessor();

            List<Drone> drones = simpleProcessor.process(world);

            int weight = 0;
            ArrayList<Instruction> instructions = new ArrayList<>();
            ArrayList<Instruction> delivers = new ArrayList<>();

            for (Drone drone : drones) {
                for (Instruction instruction : drone.instructions  ) {
                    if (instruction.instructionType == InstructionType.LOAD) {
                        int tmpWeight = weight + world.productTypeWeigh[instruction.productType];

                        if (tmpWeight < world.maxPayLoad) {
                            instructions.add(instruction);
                            weight = tmpWeight;
                        }
                        else {
                            instructions.addAll(delivers);
                            weight = 0;
                            delivers.clear();
                        }

                    }
                    else {
                        delivers.add(instruction);
                    }
                }
            }

            System.out.println("Score => " + computeScore(world, drones));
            Writer writer = new Writer();
            writer.write(drones, "output_" + fileName);
        }

    }

}
