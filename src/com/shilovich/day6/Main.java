package com.shilovich.day6;

import com.shilovich.day6.controller.InvokeController;
import com.shilovich.day6.model.entity.CustomBook;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CustomBook book = new CustomBook(47966, "W.G. Sebald", "Vertigo", 1990, new BigDecimal(9.49, MathContext.DECIMAL64));
        InvokeController controller = InvokeController.getInstance();
        Map map = controller.processRequest("sort_by_tag", new HashMap<>());
        System.out.println(map.get("Books").toString());
    }
}
