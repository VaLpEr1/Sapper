import javax.swing.*;
import java.awt.*;
import sapper.*;
import sapper.Box;

public class Sapper extends JFrame {

    private JPanel panel;
    private final byte imageSize = 50; // переменая размера картинки
    private final byte rows = 1; // переменая кол-во строк
    private final byte cols = 15; // переменая кол-во столбцов

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
            // Вложеный анонимный класс для рисования картинок
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box : Box.values()){ // циклом идет перечисление картинок указаный в Enum
                g.drawImage(getImage(box.name()),
                        box.ordinal() * imageSize, 0, this);}
            }
        };
        panel.setPreferredSize(new Dimension(cols * imageSize,
                                             rows * imageSize)); //  установка размера панели(использование менеджера компановки). Размер зависит от кол-ва картинок в столбце и строчке
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

// Метод добавления картинки
    private Image getImage(String nameImage){
        ImageIcon icon = new ImageIcon("res/img/"+ nameImage + ".png");
        return icon.getImage();
    }
}