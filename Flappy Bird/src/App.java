
import javax.swing.*;

public class App extends JFrame {

    public static void main(String[] args) throws Exception {
        int framewidth = 360;
        int frameheight = 640;
        JFrame frame = new JFrame("Flappy Bird");
        frame.setSize(framewidth,frameheight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Background bg = new Background();
        frame.add(bg);
        frame.pack();          

        frame.requestFocus();
        frame.setVisible(true);
    }
}
