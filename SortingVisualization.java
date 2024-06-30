import javax.swing.*;
import java.awt.*;

public class SortingVisualization {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualization");

        BubbleSortPanel bubbleSortPanel = new BubbleSortPanel();
        MergeSortPanel mergeSortPanel = new MergeSortPanel();
        InsertionSortPanel insertionSortPanel = new InsertionSortPanel();

        frame.setLayout(new GridLayout(1, 3));
        frame.add(bubbleSortPanel);
        frame.add(mergeSortPanel);
        frame.add(insertionSortPanel);

        frame.setSize(1200, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the sorting algorithms
        SwingUtilities.invokeLater(() -> bubbleSortPanel.bubbleSort());
        SwingUtilities.invokeLater(() -> mergeSortPanel.mergeSort());
        SwingUtilities.invokeLater(() -> insertionSortPanel.insertionSort());
    }
}
