package EDPropinas;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class CalculadoraPropinas {

    private JFrame frame;
    private JTextField totalTextField;
    private JTextField porcentajeTextField;
    private JTextField propinaTextField;
    private JTextField totalPagarTextField;

    public static void main(String[] args) {
        try {
            CalculadoraPropinas window = new CalculadoraPropinas();
            window.frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CalculadoraPropinas() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0, 153, 255));
        frame.setBounds(100, 100, 342, 396);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(10, 11, 46, 14);
        frame.getContentPane().add(lblTotal);

        totalTextField = new JTextField();
        totalTextField.setBounds(66, 8, 86, 20);
        frame.getContentPane().add(totalTextField);
        totalTextField.setColumns(10);

        JLabel lblPorcentaje = new JLabel("Porcentaje de Propina:");
        lblPorcentaje.setBounds(10, 42, 146, 14);
        frame.getContentPane().add(lblPorcentaje);

        porcentajeTextField = new JTextField();
        porcentajeTextField.setBounds(166, 39, 86, 20);
        frame.getContentPane().add(porcentajeTextField);
        porcentajeTextField.setColumns(10);

        JButton btnCalcular = new JButton("Calcular Propina");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPropina();
            }
        });
        btnCalcular.setBounds(10, 73, 146, 23);
        frame.getContentPane().add(btnCalcular);

        JLabel lblPropina = new JLabel("Propina:");
        lblPropina.setBounds(10, 110, 46, 14);
        frame.getContentPane().add(lblPropina);

        propinaTextField = new JTextField();
        propinaTextField.setEditable(false);
        propinaTextField.setBounds(66, 107, 86, 20);
        frame.getContentPane().add(propinaTextField);
        propinaTextField.setColumns(10);

        JLabel lblTotalPagar = new JLabel("Total a Pagar:");
        lblTotalPagar.setBounds(10, 145, 86, 14);
        frame.getContentPane().add(lblTotalPagar);

        totalPagarTextField = new JTextField();
        totalPagarTextField.setEditable(false);
        totalPagarTextField.setBounds(106, 142, 86, 20);
        frame.getContentPane().add(totalPagarTextField);

        JButton btnReiniciar = new JButton("Reiniciar");
        btnReiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciar();
            }
        });
        btnReiniciar.setBounds(10, 184, 89, 23);
        frame.getContentPane().add(btnReiniciar);
    }

    private void calcularPropina() {
        try {
            double total = Double.parseDouble(totalTextField.getText());
            double porcentaje = Double.parseDouble(porcentajeTextField.getText());

            double propina = (total * porcentaje) / 100;
            double totalPagar = total + propina;

            propinaTextField.setText(String.format("%.2f", propina));
            totalPagarTextField.setText(String.format("%.2f", totalPagar));
        } catch (NumberFormatException ex) {
            propinaTextField.setText("Error");
            totalPagarTextField.setText("Error");
        }
    }

    private void reiniciar() {
        totalTextField.setText("");
        porcentajeTextField.setText("");
        propinaTextField.setText("");
        totalPagarTextField.setText("");
    }
}