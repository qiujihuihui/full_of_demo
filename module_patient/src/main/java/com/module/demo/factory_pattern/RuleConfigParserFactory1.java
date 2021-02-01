package com.module.demo.factory_pattern;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 另外一种简单工厂的写法
 */
public class RuleConfigParserFactory1 {
//    private static final Map<String, IRuleConfigParser> cachedParsers = new HashMap<>();

//    static {
//        cachedParsers.put("json", new JsonRuleConfigParser());
//        cachedParsers.put("xml", new XmlRuleConfigParser());
//        cachedParsers.put("yaml", new YamlRuleConfigParser());
//        cachedParsers.put("properties", new PropertiesRuleConfigParser());
//    }

//    public static IRuleConfigParser createParser(String configFormat){
//        if (TextUtils.isEmpty(configFormat)){
//            return null;
//        }
//        IRuleConfigParser parser = cachedParsers.get(configFormat.toLowerCase());
//        return parser;
//    }
}
