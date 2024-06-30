import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class InsertionSortPanel extends JPanel {

    private List<Integer> numbers;
    private int size = 100;
    private int gap = 5;

    public InsertionSortPanel() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            numbers.add(i);
        }

        long seed = System.currentTimeMillis();
        Collections.shuffle(numbers, new Random(seed));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < numbers.size(); i++) {
            g.drawLine(gap * i + 1, getHeight(), gap * i + 1, getHeight() - numbers.get(i));
        }
    }

    public void insertionSort() {
        Graphics g = getGraphics();
        for (int i = 1; i < numbers.size(); i++) {
            int key = numbers.get(i);
            int j = i - 1;
            while (j >= 0 && numbers.get(j) > key) {
                numbers.set(j + 1, numbers.get(j));
                j = j - 1;
                draw(g, numbers, gap, getHeight());
            }
            numbers.set(j + 1, key);
            draw(g, numbers, gap, getHeight());
        }
        repaint();
    }

    private void draw(Graphics g, List<Integer> numbers, int gap, int panelHeight) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        g.clearRect(0, 0, gap * numbers.size(), panelHeight);
        for (int i = 0; i < numbers.size(); i++) {
            g.drawLine(gap * i + 1, panelHeight, gap * i + 1, panelHeight - numbers.get(i));
        }
    }
}
