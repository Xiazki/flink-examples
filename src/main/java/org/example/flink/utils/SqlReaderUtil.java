package org.example.flink.utils;

import org.apache.commons.lang3.StringUtils;
import org.example.flink.table.Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SqlReaderUtil {

    public static final String SQL_SPLIT = "----split----";

    public static List<String> readExecuteSql(String fileName) {
        ClassLoader classLoader = Main.class.getClassLoader();
        try {
            String path = Objects.requireNonNull(classLoader.getResource("sql/demo/flink-demo.sql")).toURI().getPath();
            String sql = Files.readString(Path.of(path));
            if (StringUtils.isEmpty(sql)) {
                return new ArrayList<>();
            }
            return Arrays.stream(sql.split(SQL_SPLIT)).filter(StringUtils::isNotBlank).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
