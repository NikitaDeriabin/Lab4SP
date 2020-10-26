package com.company;

public class RegexPatterns {
    public static final String Comment = "(\\/{2}[^\\n]*)";
    public static final String Directive = "\\b(uses)(\\s*)([a-zA-z]*)";
    public static final String CharConst = "\\'\\\\?.\\'";
    public static final String StringConst = "\"[^\"]*\"";
    public static final String Keyword = "\\b(?:if|then|procedure|else|continue|for|to|while|do|begin|end|read|write|program|true|false|and|or|not|xor|div|mod)\\b";
    public static final String Number = " ([\\d]+[.]?[\\d]*)|(\\$[a-fA-F0-9]+)";
    public static final String Operator = "(\\+|\\-|\\*|\\/|:=|=|>=|<=|<>|:|<|>)";
    public static final String Delimiter = "(\\(|\\)|\\[|\\]|;|,)";
    public static final String Ident = "(?:[\\w_]+[\\w\\d_]*)";
}
