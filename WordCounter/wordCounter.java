import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wordCounter extends JFrame {
    
    private JTextArea textArea;
    private JButton countButton;
    private JLabel resultLabel;

    public wordCounter() {
        // Set up the JFrame
        setTitle("Word Counter");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        textArea = new JTextArea(10, 10);
        countButton = new JButton("Count Words");
        resultLabel = new JLabel("Word Count: 0");

        // Add action listener to button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        // Set up layout
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countButton, BorderLayout.SOUTH);
        add(resultLabel, BorderLayout.NORTH);

        // Make the frame visible
        setVisible(true);
    }

    private void countWords() {
        String text = textArea.getText().trim();
        if (text.isEmpty()) {
            resultLabel.setText("Word Count: 0");
            return;
        }
        String[] words = text.split("\\s+"); // Split by whitespace
        resultLabel.setText("Word Count: " + words.length);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(wordCounter::new);
    }
}
