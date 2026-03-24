package com.jad;

import com.jad.juniafps.Map;
import com.jad.juniafps.Renderer;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Map map = new Map("map_zebi.bmp");
        Renderer renderer = new Renderer();
        System.out.println(renderer.render(new Point(306, 356), 45, map));
    }
}