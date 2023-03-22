package pl.nadberezny.flink.java;

import org.apache.flink.configuration.Configuration;
import org.apache.flink.runtime.testutils.MiniClusterResourceConfiguration;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.test.junit5.MiniClusterExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.testcontainers.shaded.org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertTrue;

public class PlaygroundJobTest {

    @RegisterExtension
    public static final MiniClusterExtension MINI_CLUSTER_RESOURCE = new MiniClusterExtension(
            new MiniClusterResourceConfiguration.Builder()
                    .setNumberTaskManagers(2)
                    .setConfiguration(new Configuration())
                    .build());

    @Test
    public void testPlayground() throws Exception {
        // given
        File checkpointDir = Files.createTempDirectory(getClass().getSimpleName() + "-checkpoint-" + RandomStringUtils.random(6)).toFile();
        checkpointDir.deleteOnExit();
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.enableCheckpointing(200);
        env.getCheckpointConfig().setCheckpointStorage("file://" + checkpointDir.getAbsolutePath());
        PlaygroundJobBuilder.build(env);

        // when
        env.execute();

        // then
        assertTrue(true);
    }
}
