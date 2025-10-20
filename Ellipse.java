import javax.swing.*;
import java.awt.*;

public class Ellipse extends JPanel {

    private static final int centerX = 300;
    private static final int centerY = 300;
    private static final int a = 40; // полуось по горизонтали, т.е ширина = 80
    private static final int b = 30; // полуось по вертикали, т.е высота = 60
    private static final Color color = Color.PINK;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color);

        for (int x = centerX - a; x <= centerX + a; x++) {  //перебор пикселей
            for (int y = centerY - b; y <= centerY + b; y++) {
                double dx = x - centerX;
                double dy = y - centerY;
                double value = (dx * dx) / (double)(a * a) + (dy * dy) / (double)(b * b);

                if (value >= 0.90 && value <= 1.10) {
                    g2d.fillRect(x, y, 1, 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("эллипс");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new Ellipse());
        frame.setVisible(true);
    }
}