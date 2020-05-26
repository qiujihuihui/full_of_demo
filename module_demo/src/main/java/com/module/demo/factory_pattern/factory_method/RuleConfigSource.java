package com.module.demo.factory_pattern.factory_method;

public class RuleConfigSource {
//    public RuleConfig load(String ruleConfigFilePath) {
//        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
//
//        IRuleConfigParserFactory parserFactory = null;
//        if ("json".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parserFactory = new JsonRuleConfigParserFactory();
//        } else if ("xml".equalsIgnoreCase(ruleConfigFileExtension)) {
//            parserFactory = new XmlRuleConfigParserFactory();
//        }
//
//        IRuleConfigParser parser = parserFactory.createParser();
//        String configText = "";
//        RuleConfig ruleConfig = parser.parse(configText);
//        return ruleConfig;
//    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}
