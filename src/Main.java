import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {

    private static void displayImage(){
        // Create a new Window when click on Yes.
        JFrame frame = new JFrame(":)");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // The Main.class it is here, causes Java to search starting from the root of the classpath,
        // ensuring that the given path is resolved correctly
        // regardless of where the application is running.
        ImageIcon GifIcon = new ImageIcon(Main.class.getResource("/Amiga, amo você!.gif"));
        JLabel label = new JLabel(GifIcon);
        frame.add(label);
        // adjust the frame window based on image size.
        frame.pack();
        
        frame.setVisible(true);

    }
    //Method to move the window for a random position.
    private static void moveWindow (JFrame frame){
        //Get the dimensions of the screen
        Dimension containerSize = Toolkit.getDefaultToolkit().getScreenSize();
        int containerWidth = (int) containerSize.getWidth();
        int containerHeight = (int) containerSize.getHeight();

        //Generate random coordinates inside in the screen limits
        Random random = new Random();
        int moveY = random.nextInt(containerWidth - frame.getWidth());
        int moveX = random.nextInt(containerHeight - frame.getHeight());

        //Move the window to random coordinates
        frame.setLocation(moveX, moveY);

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Be my BFF?");
        JPanel container = new JPanel();
        JLabel msg_inside = new JLabel("Do you want to be my BFF?");
        JButton bYes = new JButton("Yes!!!!");
        JLabel yes = new JLabel();
        JButton bNo = new JButton("No");
        JLabel no = new JLabel();

        container.setLayout(new FlowLayout());
        container.add(msg_inside);
        container.add(bYes);
        container.add(yes);
        container.add(bNo);
        container.add(no);
        frame.getContentPane().add(container);

        // A ActionListener to Button Yes.
        // Show an Image when you click the button yes.
        bYes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayImage();
            }
        });

        // A ActionListener to Button No.
        // A button that move randomly.
        bNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveWindow(frame);
            }
        });


        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(bNo);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }
}