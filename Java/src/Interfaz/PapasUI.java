package Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import FIS_Papas.FIS_Papas;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Rule;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PapasUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TEMPERATURA;
	private JTextField ALTITUD;
	private JTextField LUZ;
	private JTextField AGUA;
	private JTextField PH;
    
	private static FIS_Papas fis = new FIS_Papas();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PapasUI frame = new PapasUI();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PapasUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblTemperatura = new JLabel("Temperatura: ");
		lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTemperatura.setBounds(83, 50, 103, 35);
		contentPane.add(lblTemperatura);
		
		TEMPERATURA = new JTextField();
		TEMPERATURA.setBounds(196, 58, 96, 20);
		contentPane.add(TEMPERATURA);
		TEMPERATURA.setColumns(10);
		
		JLabel lblAltitud = new JLabel("Altitud: ");
		lblAltitud.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAltitud.setBounds(83, 83, 103, 35);
		contentPane.add(lblAltitud);
		
		JLabel lblLuz = new JLabel("Luz: ");
		lblLuz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLuz.setBounds(83, 111, 103, 35);
		contentPane.add(lblLuz);
		
		JLabel lblAgua = new JLabel("Agua: ");
		lblAgua.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAgua.setBounds(83, 139, 103, 35);
		contentPane.add(lblAgua);
		
		JLabel lblPh = new JLabel("Ph: ");
		lblPh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPh.setBounds(83, 168, 103, 35);
		contentPane.add(lblPh);
		
		ALTITUD = new JTextField();
		ALTITUD.setColumns(10);
		ALTITUD.setBounds(196, 91, 96, 20);
		contentPane.add(ALTITUD);
		
		LUZ = new JTextField();
		LUZ.setColumns(10);
		LUZ.setBounds(196, 119, 96, 20);
		contentPane.add(LUZ);
		
		AGUA = new JTextField();
		AGUA.setColumns(10);
		AGUA.setBounds(196, 147, 96, 20);
		contentPane.add(AGUA);
		
		PH = new JTextField();
		PH.setColumns(10);
		PH.setBounds(196, 176, 96, 20);
		contentPane.add(PH);
		
		JButton VerVariables = new JButton("Variables");
		VerVariables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fis.MostrarVariables();
				
			}
		});
		VerVariables.setBounds(167, 227, 89, 23);
		contentPane.add(VerVariables);
		
		JButton VerReglas = new JButton("Reglas");
		VerReglas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				StringBuffer rules = fis.MostrarReglas(); 
		        JOptionPane.showMessageDialog(null, rules, "REGLAS",JOptionPane.INFORMATION_MESSAGE);

			}
		});
		VerReglas.setBounds(52, 227, 89, 23);
		contentPane.add(VerReglas);
		
		JButton Calcular = new JButton("Calcular");
		Calcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
		        
		        String respuesta = fis.fisStart(Double.parseDouble(TEMPERATURA.getText().replace(",", ".")), 
		        								Double.parseDouble(ALTITUD.getText().replace(",", ".")), 
		        								Double.parseDouble(LUZ.getText().replace(",", ".")), 
		        								Double.parseDouble(AGUA.getText().replace(",", ".")), 
		        								Double.parseDouble(PH.getText().replace(",", ".")));
		        
		        JOptionPane.showMessageDialog(null, respuesta, "RESPUESTA",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		Calcular.setBounds(277, 227, 89, 23);
		contentPane.add(Calcular);
	}
}
