package com.jad.juniafps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.InputStream;

public class GameWindow extends JFrame {
    private static final InputStream FONT_FILE = GameWindow.class.getResourceAsStream("/CascadiaMono.ttf");
    private final JTextArea textArea = new JTextArea("");

    public GameWindow(final String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        final Font font;
        try {
            assert GameWindow.FONT_FILE != null;
            font = Font.createFont(Font.TRUETYPE_FONT, GameWindow.FONT_FILE).deriveFont(RenderUtils.FONT_SIZE);
        } catch (final FontFormatException | IOException exception) {
            throw new RuntimeException(exception);
        }
        this.setLayout(new BorderLayout());
        this.textArea.setFont(font);
        this.textArea.setEditable(false);
        this.textArea.setBackground(Color.ORANGE);
        this.textArea.setForeground(Color.BLACK);
        final JPanel panel = new JPanel();
        this.add(panel, BorderLayout.CENTER);
        panel.add(this.textArea);
        this.textArea.addMouseMotionListener(new MouseMotionHandler());
        this.createActionListeners();
        this.createActionPerformers();
        this.setVisible(true);
    }

    private void createActionPerformers() {
        final ActionMap actionMap = this.textArea.getActionMap();
        for (final ActionPlayer actionPlayer : ActionPlayer.values()) {
            actionMap.put(actionPlayer.getActionKey() + "-on", new AbstractAction() {
                @Override
                public void actionPerformed(final ActionEvent event) {
                    actionPlayer.turnOn();
                }
            });
            actionMap.put(actionPlayer.getActionKey() + "-off", new AbstractAction() {
                @Override
                public void actionPerformed(final ActionEvent event) {
                    actionPlayer.turnOff();
                }
            });

        }
    }

    private void createActionListeners() {
        final InputMap inputMap = this.textArea.getInputMap();
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0, false), "forward-on");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0, true), "forward-off");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, false), "left-on");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0, true), "left-off");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "right-on");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "right-off");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "backward-on");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "backward-off");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "exit-on");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, true), "exit-off");
    }

    public void display(final String text) {
        this.textArea.setText(text);
    }

    private class MouseMotionHandler implements MouseMotionListener {
        private int lastX;


        @Override
        public void mouseDragged(final MouseEvent mouseEvent) {

        }

        @Override
        public void mouseMoved(final MouseEvent mouseEvent) {
            final int newX = mouseEvent.getX();
            if (newX < this.lastX) ActionPlayer.TURN_LEFT.turnOn();
            if (newX > this.lastX) ActionPlayer.TURN_RIGHT.turnOn();
            this.lastX = newX;

        }
    }
}
