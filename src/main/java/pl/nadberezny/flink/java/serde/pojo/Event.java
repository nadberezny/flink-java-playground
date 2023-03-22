package pl.nadberezny.flink.java.serde.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.flink.api.common.typeinfo.TypeInfo;

import java.util.List;

@TypeInfo(EventTypeInfoFactory.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public final class Event {

    private String id;

    private List<String> tags;
}
