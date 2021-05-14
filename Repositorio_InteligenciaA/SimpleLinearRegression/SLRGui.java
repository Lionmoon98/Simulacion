package hands;
import jade.core.AID;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class SLRGui extends JFrame {
    private OneShotAgentSLR myAgent;

    private JTextField xValueField;

    SLRGui(OneShotAgentSLR a){
        super(a.getLocalName());

        myAgent = a;

        JPanel p = new JPanel(); 
        p.setLayout(new GridLayout(1, 2));
        p.add(new JLabel("Ingresa Valor :"));
        xValueField = new JTextField(15);
        p.add(xValueField);
        getContentPane().add(p, BorderLayout.CENTER);

        JButton addButton = new JButton("Calculate");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    String xValue = xValueField.getText().trim();
                    myAgent.predict(Integer.parseInt(xValue));
                    xValueField.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(SLRGui.this, "valor invalido"+e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        p = new JPanel();
        p.add(addButton);
        getContentPane().add(p, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                myAgent.doDelete();
            }
        });
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = (int)screenSize.getWidth() /2;
        int centerY = (int)screenSize.getWidth() /2;
        setLocation(centerX - getWidth()/2, 100);
        pack();
        super.setVisible(true);

    }
}
