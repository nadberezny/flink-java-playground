package pl.nadberezny.flink.java.source;

import org.apache.flink.streaming.api.functions.source.FromElementsFunction;
import pl.nadberezny.flink.java.serde.pojo.Event;

import java.util.List;

public final class EventsSource extends FromElementsFunction<Event> {

    public static List<Event> getElements() {
        return List.of(new Event("id1", List.of("tag1")));
    }

    public EventsSource() {
        super(getElements());
    }
}
