import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BubbleSortPanel extends JPanel {

    private List<Integer> numbers;
    private int size = 100;
    private int gap = 5;

    public BubbleSortPanel() {
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

    private void swap(Graphics g, int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);

        g.setColor(Color.GREEN);
        g.drawLine(gap * i + 1, getHeight(), gap * i + 1, getHeight() - temp);
        g.setColor(Color.BLACK);
        g.drawLine(gap * i + 1, getHeight(), gap * i + 1, getHeight() - temp);
        g.setColor(Color.WHITE);
        g.drawLine(gap * i + 1, getHeight(), gap * i + 1, getHeight() - numbers.get(i));

        g.setColor(Color.GREEN);
        g.drawLine(gap * j + 1, getHeight(), gap * j + 1, getHeight() - numbers.get(i));
        g.setColor(Color.BLACK);
        g.drawLine(gap * j + 1, getHeight(), gap * j + 1, getHeight() - numbers.get(i));
        g.setColor(Color.WHITE);
        g.drawLine(gap * j + 1, getHeight(), gap * j + 1, getHeight() - numbers.get(j));
    }

    public void bubbleSort() {
        Graphics g = getGraphics();
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    swap(g, j, j + 1);
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
