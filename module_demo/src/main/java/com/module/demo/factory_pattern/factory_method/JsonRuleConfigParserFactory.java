package com.module.demo.factory_pattern.factory_method;

public class JsonRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
//        return new JsonRuleConfigParser();
        return null; // 默认代码
    }
}
