import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui implements ChangeListener, ActionListener {


    private PasswordGenerator generator = new PasswordGenerator();
    private JLabel length = new JLabel();
    private JTextField password = new JTextField();
    private JCheckBox checkBox = new JCheckBox();
    private JCheckBox checkBox1 = new JCheckBox();
    private JCheckBox checkBox2 = new JCheckBox();
    private JCheckBox checkBox3 = new JCheckBox();
    private JSlider slider = new JSlider(0, 50, 16);




    public void createGui() {
        // Frame
        JFrame frame = new JFrame("Password Generator");
        frame.setSize(650, 260);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        ImageIcon logo = new ImageIcon(Gui.class.getResource("/resources/lock.png"));
        frame.setIconImage(logo.getImage());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton button = new JButton();
        button.addActionListener(this);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setText("Generate Password");
        JLabel pass = new JLabel();
        pass.setText("Generate Password");
        pass.setAlignmentX(Component.CENTER_ALIGNMENT);
        pass.setFont(new Font("SansSerif", Font.BOLD, 20));
        panel.add(pass);
        slider.setPaintTicks(true);
        slider.setAlignmentX(Component.CENTER_ALIGNMENT);
        slider.addChangeListener(this);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintTrack(true);
        length.setAlignmentX(Component.CENTER_ALIGNMENT);
        length.setFont(new Font("SansSerif", Font.BOLD, 12));
        length.setText("Length: "+ slider.getValue());
        panel.add(slider);
        panel.add(length);
        checkBox.setText("Numbers");
        checkBox1.setText("Lowercase Letters");
        checkBox2.setText("Uppercase Letters");
        checkBox3.setText("Symbols");
        checkBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBox1.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBox2.setAlignmentX(Component.CENTER_ALIGNMENT);
        checkBox3.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(checkBox);
        panel.add(checkBox1);
        panel.add(checkBox2);
        panel.add(checkBox3);
        panel.add(button);
        password.setAlignmentX(Component.CENTER_ALIGNMENT);
        password.setHorizontalAlignment(JTextField.CENTER);
        password.setSize(550, 30);
        panel.add(password);


        frame.add(panel);
        frame.setVisible(true);
    }

    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        if (!source.getValueIsAdjusting()) {
                this.length.setText("Length: "+ source.getValue());
            }
        }

    @Override
    public void actionPerformed(ActionEvent e) {
       password.setText(generator.generatePassword(slider.getValue(),checkBox.isSelected(),checkBox1.isSelected(),checkBox2.isSelected(),checkBox3.isSelected()));

    }
}