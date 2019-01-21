import javax.swing.*;
import java.awt.*;
import sapper.*;
import sapper.Box;

public class Sapper extends JFrame {

    private JPanel panel;
    private final int imageSize = 50; // переменая размера картинки
    private final int rows = 9; // переменая кол-во строк
    private final int cols = 9; // переменая кол-во столбцов
    private final int bombs = 10; // кол-во бомб
    private Game game; // Экзепляр класса

    public static void main(String[] args) {
        new Sapper();
    }

// Конструктор основного класса Sapper где создаеться основной GUI
    private Sapper(){

        game = new Game(cols, rows, bombs);
        game.start();
        setImages();
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
                for (Coord coord : Ranges.getAllCoords()){ // циклом идет перечисление картинок указаный в Enum
                    g.drawImage((Image) game.getBox(coord).image,
                            coord.x * imageSize,
                            coord.y * imageSize, this);}
            }
        };
        panel.setPreferredSize(new Dimension(Ranges.getSize().x * imageSize,
                                             Ranges.getSize().y * imageSize)); //  установка размера панели(использование менеджера компановки). Размер зависит от кол-ва картинок в столбце и строчке
        add(panel);
    }

// Метод по инициализации фрейма JFrame
    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Сапер");
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void setImages(){
        for (Box box : Box.values())
            box.image = getImage(box.name());
        setIconImage(getImage("icon"));
    }

// Метод добавления картинки
    private Image getImage(String nameImage){
        String filename = "img/"+ nameImage + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }
}