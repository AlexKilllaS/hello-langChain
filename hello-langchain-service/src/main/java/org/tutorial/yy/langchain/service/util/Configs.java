package org.tutorial.yy.langchain.service.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.nio.charset.StandardCharsets;

/**
 * @author yyHuangfu
 * @create 2024/2/3
 * @description
 */
public class Configs {
    public static String get(String value) {
        String configFile = FileUtil.readString("hello_langchain_config.json",
                StandardCharsets.UTF_8);
        JSONObject config = JSONUtil.parseObj(configFile);
        return String.valueOf(config.get(value));
    }
}
