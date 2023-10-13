package from_a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.util.HashMap;
import java.util.Map;

public class AnalysisCSV_v_1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AnalysisCSV (version 1.0)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        Map<String, String> yearData = new HashMap<>();
        yearData.put("2014", "معلومات عن سنة 2014");
        yearData.put("2015", "معلومات عن سنة 2015");
        yearData.put("2016", "معلومات عن سنة 2016");
        yearData.put("2017", "معلومات عن سنة 2017");
        yearData.put("2018", "معلومات عن سنة 2018");
        yearData.put("2019", "معلومات عن سنة 2019");
        yearData.put("2020", "معلومات عن سنة 2020");
        yearData.put("2021", "معلومات عن سنة 2021");
        yearData.put("2022", "معلومات عن سنة 2022");
        yearData.put("2023", "معلومات عن سنة 2023");


        JLabel titleLabel = new JLabel("AnalysisCSV");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.WHITE); // تعيين لون النص إلى الأبيض
        titleLabel.setOpaque(true); // تفعيل خلفية العنوان
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
                textArea.setText("معلومات حول CSV");
            }
        });

        antibioticButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("معلومات حول Antibiotic");
            }
        });

        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("معلومات عامة");
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(csvButton);
        buttonPanel.add(antibioticButton);
        buttonPanel.add(infoButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);


        String[] yearsArray = {"2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"};
        JList<String> yearList = new JList<>(yearsArray);


        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // احصل على السنة المحددة
                String selectedYear = yearList.getSelectedValue();
                if (selectedYear != null && yearData.containsKey(selectedYear)) {
                    String yearInfo = yearData.get(selectedYear);
                    textArea.setText(yearInfo);
                    if (selectedYear.equals("2014")) {
                        // عرض الرسم البياني عندما يتم تحديد سنة 2014
                        JPanel chartPanel = createChart();
                        panel.add(chartPanel, BorderLayout.EAST);
                        frame.revalidate();
                    } else {
                        // إزالة الرسم البياني إذا تم تحديد سنة أخرى
                        Component[] components = panel.getComponents();
                        for (Component component : components) {
                            if (component instanceof ChartPanel) {
                                panel.remove(component);
                            }
                        }
                        frame.revalidate();
                    }
                } else {

                    Component[] components = panel.getComponents();
                    for (Component component : components) {
                        if (component instanceof ChartPanel) {
                            panel.remove(component);
                        }
                    }
                    frame.revalidate();
                    textArea.setText("لم يتم تحديد سنة أو لا توجد بيانات لهذه السنة.");
                }
            }
        });


        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BorderLayout());
        sidePanel.add(new JScrollPane(yearList), BorderLayout.CENTER);
        sidePanel.add(selectButton, BorderLayout.SOUTH);
        sidePanel.setPreferredSize(new Dimension(100, frame.getHeight())); // تعيين العرض الجانبي

        panel.add(sidePanel, BorderLayout.WEST);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static JPanel createChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(11373, "2014", "Summer");
        dataset.addValue(10435, "2014", "Winter");
        dataset.addValue(8842, "2014", "Spring");
        dataset.addValue(7943, "2014", "Autumn");

        JFreeChart chart = ChartFactory.createBarChart(
                "Number of antibiotic boxes consumption",
                "Seasons",
                "IN 2014",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 400));

        return chartPanel;
    }
}
