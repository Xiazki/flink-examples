package org.example.flink.table;

import org.apache.commons.lang3.StringUtils;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.TableEnvironment;
import org.example.flink.Executor;
import org.example.flink.utils.SqlReaderUtil;

import java.util.List;

public class FlinkDemoSqlExecutor implements Executor {

    @Override
    public void run(String[] args) {
        EnvironmentSettings settings = EnvironmentSettings.newInstance().build();
        TableEnvironment tEnv = TableEnvironment.create(settings);
        List<String> sqlList = SqlReaderUtil.readExecuteSql("sql/demo/flink-demo.sql");
        sqlList.stream().filter(StringUtils::isNotBlank).forEach(tEnv::executeSql);
    }
}
