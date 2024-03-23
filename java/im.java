import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class im extends JFrame {
    private ImageIcon image1;
    private JLabel label1;
    private ImageIcon image2;
    private JLabel label2;
    private ImageIcon image3; // New ImageIcon for the third image
    private JLabel label3; // New JLabel for the third image

    im() {
        setLayout(new FlowLayout());

        // Load the first image
        image1 = new ImageIcon(getClass().getResource("ice.jpeg"));
        label1 = new JLabel(image1);
        add(label1);

        // Load the second image
        image2 = new ImageIcon(getClass().getResource("pust_logo.png"));
        label2 = new JLabel(image2);
        add(label2);

        // Load the third image
        image3 = new ImageIcon(getClass().getResource("pic1.jpeg"));
        label3 = new JLabel(image3);
        add(label3);
    }

    public static void main(String args[]) {
        im gui = new im();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();
        gui.setTitle("Image Program");
    }
}
