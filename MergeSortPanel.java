import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MergeSortPanel extends JPanel {

    private List<Integer> numbers;
    private int size = 100;
    private int gap = 5;

    public MergeSortPanel() {
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

    public void mergeSort() {
        Graphics g = getGraphics();
        mergeSortHelper(numbers, g, gap, getHeight());
        repaint();
    }

    private void mergeSortHelper(List<Integer> numbers, Graphics g, int gap, int panelHeight) {
        if (numbers.size() < 2) {
            return;
        }
        int mid = numbers.size() / 2;
        List<Integer> left = new ArrayList<>(numbers.subList(0, mid));
        List<Integer> right = new ArrayList<>(numbers.subList(mid, numbers.size()));

        mergeSortHelper(left, g, gap, panelHeight);
        mergeSortHelper(right, g, gap, panelHeight);
        merge(numbers, left, right, g, gap, panelHeight);
    }

    private void merge(List<Integer> numbers, List<Integer> left, List<Integer> right, Graphics g, int gap, int panelHeight) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                numbers.set(k++, left.get(i++));
            } else {
                numbers.set(k++, right.get(j++));
            }
            draw(g, numbers, gap, panelHeight);
        }
        while (i < left.size()) {
            numbers.set(k++, left.get(i++));
            draw(g, numbers, gap, panelHeight);
        }
        while (j < right.size()) {
            numbers.set(k++, right.get(j++));
            draw(g, numbers, gap, panelHeight);
        }
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
