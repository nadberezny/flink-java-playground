package pl.nadberezny.flink.java.serde.pojo;

import org.apache.flink.api.common.typeinfo.TypeInfoFactory;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.typeutils.ListTypeInfo;

import java.lang.reflect.Type;
import java.util.Map;

public class EventTypeInfoFactory extends TypeInfoFactory<Event> {

    @Override
    public TypeInformation<Event> createTypeInfo(Type t, Map<String, TypeInformation<?>> genericParameters) {
        return Types.POJO(Event.class, Map.of(
                "id", TypeInformation.of(String.class),
                "tags", new ListTypeInfo<>(String.class)
        ));
    }
}
