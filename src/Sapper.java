import javax.swing.*;
import java.awt.*;

public class Sapper extends JFrame {

    private JPanel panel;

    public static void main(String[] args) {
        new Sapper();
    }

// Конструктор основного класса Sapper где создаеться основной GUI
    private Sapper(){
        initPanel();
        initFrame();
    }

// Метод по инициализации панели (JPanel)
    private void initPanel() {
        panel = new JPanel()
        {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

            }
        };
        panel.setPreferredSize(new Dimension(500,300)); //  установка размера панели с использование менеджера компановки
        add(panel);
    }

// Метод по инициализации фрейма JFrame
    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Сапер");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}
