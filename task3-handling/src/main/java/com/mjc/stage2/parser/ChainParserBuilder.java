package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        int index = 0;
        while (index < parsers.size()) {
            if (parsers.get(index) == null) {
                parsers.get(index).setNextParser(parsers.get(index++));
            } else {
                return parsers.get(index);
            }
        }
        throw new RuntimeException();
    }
}
