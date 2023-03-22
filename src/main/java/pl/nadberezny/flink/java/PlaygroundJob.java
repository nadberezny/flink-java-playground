package pl.nadberezny.flink.java;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class PlaygroundJob {

    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        PlaygroundJobBuilder.build(env);
        env.execute();
    }
}
