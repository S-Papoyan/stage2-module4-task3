package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType componentType) {
        super(componentType);
        this.size = 0;
    }

    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder();
        for (AbstractTextComponent abstractTextComponent : componentList) {
            builder.append(abstractTextComponent.operation());
        }
        return builder.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
        this.size ++;
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
        this.size --;
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
