package pl.nadberezny.flink.java;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import pl.nadberezny.flink.java.source.EventsSource;

public final class PlaygroundJobBuilder {

    public static void build(StreamExecutionEnvironment env) {
        env.getConfig().disableGenericTypes();

        env.addSource(new EventsSource()).print();
    }
}
