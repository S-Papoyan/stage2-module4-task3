package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();
        RectangleValues rectangleValues = RectangleWarehouse.getInstance().get(rectangle.getId());
        if (rectangleValues != null) {
            rectangleValues.setPerimeter(rectangle.getSideA() * 2 + rectangle.getSideB() * 2);
            rectangleValues.setPerimeter(rectangle.getSideA() * rectangle.getSideB());
        } else RectangleWarehouse.getInstance().put(rectangle.getId(),
                new RectangleValues(rectangle.getSideA() * rectangle.getSideB(),
                        rectangle.getSideA() * 2 + rectangle.getSideB() * 2));
    }
}