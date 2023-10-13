package Past_versions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnalysisCSV {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AnalysisCSV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // تعيين اللون الأسود للعنوان
        JLabel titleLabel = new JLabel("AnalysisCSV");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE); // تعيين لون النص إلى الأبيض
        titleLabel.setOpaque(true); // تفعيل خلفية عنوان
        titleLabel.setBackground(Color.BLACK); // تعيين لون الخلفية إلى الأسود
        titleLabel.setPreferredSize(new Dimension(frame.getWidth(), 40)); // تعيين ارتفاع العنوان
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20)); // تعيين حجم الخط للنص
        textArea.setWrapStyleWord(true); // التمرير الأفقي
        textArea.setLineWrap(true); // التمرير الأفقي
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton csvButton = new JButton("CSV");
        JButton antibioticButton = new JButton("Antibiotic");
        JButton infoButton = new JButton("Info");

        csvButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Antibiotic Name,ward,Production Date,Expiration Date, Total price, One price, Num of antibiotic,range of Antibiotic to ward on day,\n" +
                        " Amoxicillin,1:2,05/01/2023,05/01/2025,2500,25,100,24:3,\n" +
                        " Ciprofloxacin,1:2,06/15/2023,06/15/2024,2500,25,100,24:3,\n" +
                        " Doxycycline,1:2,04/10/2023,04/10/2024,2500,25,100,24:3,\n" +
                        " Azithromycin,1:2,07/20/2023,07/20/2025,2500,25,100,24:3,");
            }
        });

        antibioticButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText(" 1-Amoxicillin\n" +
                        " 2-Ciprofloxacin\n" +
                        " 3-Doxycycline\n" +
                        " 4-Azithromycin\n");
            }
        });

        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("About:.\n" +
                        "DEV , Ashraf \n" +
                        "DEV , Mohammed \n ");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(csvButton);
        buttonPanel.add(antibioticButton);
        buttonPanel.add(infoButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
