package com.module.demo.factory_pattern.factory_method;

public class XmlRuleConfigParserFactory implements IRuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
//        return new XmlRuleConfigParser();
        return null;
    }
}
