package org.example;

import javax.swing.*;
import java.awt.*;

public class GridWindow {
    private JFrame frame;
    private JLabel[] cells;

    public GridWindow(String title, int rows, int cols) {
        frame = new JFrame(title);
        frame.setLayout(new GridLayout(rows, cols, 5, 5));
        cells = new JLabel[rows * cols];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new JLabel("", SwingConstants.CENTER);
            cells[i].setOpaque(true);
            cells[i].setBackground(Color.WHITE);
            cells[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            frame.add(cells[i]);
        }
        frame.setSize(900, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setCell(int index, String html, Color colour) {
        cells[index].setText("<html>" + html + "</html>");
        cells[index].setBackground(colour);
    }

    public void repaint() {
        frame.repaint();
    }
}
