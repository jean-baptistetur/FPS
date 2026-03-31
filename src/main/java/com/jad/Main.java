package com.jad;

import com.jad.juniafps.GameWindow;
import com.jad.juniafps.Map;
import com.jad.juniafps.Player;
import com.jad.juniafps.Renderer;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Map map = new Map("map_zebi.bmp");
        Player player = new Player(new Point(429, 349), 0);
        Renderer renderer = new Renderer();
        GameWindow window = new GameWindow("SALAMALEYKOUM");
        int direction = 0;
        for (; ; ) {
            window.display(renderer.render(player.getPosition(), player.getDirection(), map));
            player.handleActions();
            direction = (direction + 1) % 360;
        }
    }
}