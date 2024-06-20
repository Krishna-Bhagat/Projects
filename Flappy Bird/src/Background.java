
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Background extends JPanel implements ActionListener, KeyListener {

    int boardwidth = 360;
    int boardheight = 640;

    //Image Variable
    Image background;
    Image bird;
    Image top_pipe;
    Image bottom_pipe;

    //Bird Position variable
    int birdX = boardwidth / 8;
    int birdY = boardheight / 3;

    int birdWidth = 34;
    int birdHeight = 24;

    //Class for Pipe Position Variable
    class Pipe {

        int x = 360;
        int y = 0;
        int width = 64;
        int height = 512;
        boolean passed = false;
        Image img;

        Pipe(Image img) {
            this.img = img;
        }
    }

    //game Logic
    Timer gameLoop;
    int velocity_Y = 0;
    int gravity = 1;

    Timer placePipe;
    int velocity_X = -4;

    ArrayList<Pipe> pipes;
    Random random = new Random();
    boolean gameOver = false;
    int score =0;

    Background() {
        setPreferredSize(new Dimension(boardwidth, boardheight));
        // setBackground(Color.CYAN);

        //load Image
        background = new ImageIcon(getClass().getResource("./flappy_bird_bg.png")).getImage();
        bird = new ImageIcon(getClass().getResource("./flappy_bird.png")).getImage();
        top_pipe = new ImageIcon(getClass().getResource("./top_pipe.png")).getImage();
        bottom_pipe = new ImageIcon(getClass().getResource("./bottom_pipe.png")).getImage();

        //game Timer
        gameLoop = new Timer(1000 / 60, this);
        gameLoop.start();

        //place pipe time
        pipes = new ArrayList<>();
        placePipe = new Timer(1600, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placepipe();
            } 
        });
        placePipe.start();

        //key listener
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    private void draw(Graphics g) {
        //setting Background
        g.drawImage(background, 0, 0, boardwidth, boardheight, null);
        g.drawImage(bird, birdX, birdY, birdWidth, birdHeight, null);

        //Setting Pipe
        for (Pipe pipe : pipes) {
            g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
        }

        if(gameOver){
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("Game Over: "+String.valueOf(score), 80, 290);
        }
        else{
            g.setColor(Color.white);
            g.setFont(new Font("Arial", Font.PLAIN, 28));
            g.drawString("Score: "+String.valueOf(score), 10, 20);
        }
        
    }

    private void move() {
        //bird's move
        velocity_Y += gravity;
        birdY += velocity_Y;
        birdY = Math.max(birdY, 0);

        //top pipe velocity
        for (Pipe pipe : pipes) {
            pipe.x += velocity_X;
            if(!pipe.passed && birdX > pipe.x + pipe.width){
                pipe.passed = true;
                ++score;
            }
            if(collision(pipe)){
                gameOver = true;
            }
        }

        //Game Over Condition
        if(birdY > boardheight){
            gameOver = true;
        }
    }

    private boolean collision(Background.Pipe pipe) {
        if (birdX+birdWidth > pipe.x &&
            birdX < pipe.x + pipe.width &&
            birdY < pipe.y + pipe.height &&
            birdY + birdHeight > pipe.y
        ) {
            return true;
        }
        return false;
    }

    private void placepipe(){
        Pipe topPipe = new Pipe(top_pipe);
        int randomY = (int)(topPipe.y - topPipe.height/4 - Math.random()*(topPipe.height/2));
        topPipe.y = randomY;
        pipes.add(topPipe);

        Pipe bottomPipe = new Pipe(bottom_pipe);
        int opening = boardheight/4;
        bottomPipe.y = topPipe.y + topPipe.height + opening;
        pipes.add(bottomPipe);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if(gameOver){
            placePipe.stop();
            gameLoop.stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            velocity_Y = -9;
        }
        if(gameOver && e.getKeyCode() == KeyEvent.VK_ENTER){
            birdY = boardheight / 3;
            pipes.clear();
            velocity_Y = 0;
            score =0;
            gameOver = false;
            gameLoop.start();
            placePipe.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
