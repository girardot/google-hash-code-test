package _2015.score;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import _2015.model.DataCenter;
import _2015.model.ServerOutput;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ScoreProcessor {

    public static int computeScore(DataCenter dataCenter, List<ServerOutput> serverOutputs) {
        int score = Integer.MAX_VALUE;

        for (int row = 0; row < dataCenter.line1.row; row++) {
            Multimap<Integer, ServerOutput> pools = ArrayListMultimap.create();
            for (ServerOutput serverOutput : serverOutputs) {
                if (serverOutput.row != row) {
                    pools.put(serverOutput.pool, serverOutput);
                }
            }

            for (Integer pool : pools.keySet()) {
                Collection<ServerOutput> serverOutputs1 = pools.get(pool);
                Optional<Integer> reduce = serverOutputs1.stream().map(c -> c.capacity).reduce((s1, s2) -> s1 + s2);
                if (reduce.get() < score) {
                    score = reduce.get();
                }
            }
        }
        return score;
    }

}
