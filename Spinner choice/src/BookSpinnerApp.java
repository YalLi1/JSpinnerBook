import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookSpinnerApp extends JFrame {

    private JLabel resultLabel;
    private JSpinner bookSpinner;
    private JButton answerButton;

    public BookSpinnerApp() {
        // Настройка фрейма
        setTitle("Book Spinner App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Создание панели с компоновкой BoxLayout для вертикального размещения кнопок
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Создание JSpinner для выбора количества книг
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 100, 1); // начальное значение, мин, макс, шаг
        bookSpinner = new JSpinner(model);
        bookSpinner.setMaximumSize(new Dimension(50, 30)); // Устанавливаем размер JSpinner

        // Создание кнопки "Ответить"
        answerButton = new JButton("Ответить");
        answerButton.setMaximumSize(new Dimension(100, 30)); // Устанавливаем размер кнопки
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numberOfBooks = (int) bookSpinner.getValue();
                resultLabel.setText("Ответ: " + numberOfBooks + " книг");
            }
        });

        // Создание метки для отображения ответа
        resultLabel = new JLabel("Ответ: ", SwingConstants.CENTER);

        // Добавление компонентов к панели
        panel.add(Box.createVerticalGlue());
        panel.add(bookSpinner);
        panel.add(Box.createVerticalStrut(10)); // Добавляем вертикальный промежуток
        panel.add(answerButton);
        panel.add(Box.createVerticalStrut(10)); // Добавляем вертикальный промежуток
        panel.add(resultLabel);
        panel.add(Box.createVerticalGlue());

        // Добавление панели к фрейму
        add(panel, BorderLayout.CENTER);

        // Добавление центральной метки заголовка
        JLabel titleLabel = new JLabel("Сколько книг вы возьмёте с собой в лагерь?", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        setVisible(true);
    }

}
