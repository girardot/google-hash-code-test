package _2015.input;

import com.google.common.collect.Lists;
import _2015.model.DataCenter;
import _2015.model.Line1;
import _2015.model.Server;
import _2015.model.SlotUnavalable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputReader {

    public DataCenter parse(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));

        String s = scanner.nextLine();
        String[] split = s.split(" ");
        Line1 line1 = new Line1(parseInt(split[0]), parseInt(split[1]), parseInt(split[2]), parseInt(split[3]), parseInt(split[4]));

        ArrayList<SlotUnavalable> slotUnavalable = Lists.newArrayList();
        for (int i = 0; i < line1.slotUnavable; i++) {
            String line = scanner.nextLine();

            String[] split1 = line.split(" ");
            slotUnavalable.add(new SlotUnavalable(parseInt(split1[0]), parseInt(split1[1])));
        }

        ArrayList<Server> servers = Lists.newArrayList();
        for (int i = 0; i < line1.server; i++) {
            String line = scanner.nextLine();
            String[] split1 = line.split(" ");
            servers.add(new Server(Integer.parseInt(split1[0]), parseInt(split1[1]), i));
        }

        return new DataCenter(line1, servers, slotUnavalable);
    }

}
