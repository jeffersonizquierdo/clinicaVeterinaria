package vista.gui;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.vo.PersonaVo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class ConsultarPersonaGui extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textDocumetno;
	private JTextField textNombre;
	private JTextField textTelefono;
	private JTextField textProfecion;
	private JTextField textTipo;
	private JTextField textDia;
	private JTextField textMes;
	private JTextField textAño;
	private JTextField textCiudad;
	private JTextField textDepartamento;
	private JTextField textPais;
	private JButton btnCancelar;
	private JButton btnConsultar;
	private Coordinador miCoordinador;


	public ConsultarPersonaGui(VentanaPrincipal miVentanaPrincipal, boolean b) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Consultar");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(259, 11, 140, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Documento");
		lblNewLabel_1.setBounds(163, 66, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		textDocumetno = new JTextField();
		textDocumetno.setBounds(259, 63, 136, 20);
		contentPane.add(textDocumetno);
		textDocumetno.setColumns(10);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(434, 62, 89, 23);
		contentPane.add(btnConsultar);
		btnConsultar.addActionListener(this);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(163, 107, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textNombre = new JTextField();
		textNombre.setBounds(255, 104, 334, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(163, 150, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(230, 147, 86, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Profecion");
		lblNewLabel_4.setBounds(341, 150, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textProfecion = new JTextField();
		textProfecion.setBounds(397, 147, 86, 20);
		contentPane.add(textProfecion);
		textProfecion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo");
		lblNewLabel_5.setBounds(493, 150, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textTipo = new JTextField();
		textTipo.setBounds(549, 147, 86, 20);
		contentPane.add(textTipo);
		textTipo.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha");
		lblNewLabel_6.setBounds(39, 199, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		textDia = new JTextField();
		textDia.setBounds(90, 196, 46, 20);
		contentPane.add(textDia);
		textDia.setColumns(10);
		
		textMes = new JTextField();
		textMes.setBounds(149, 196, 32, 20);
		contentPane.add(textMes);
		textMes.setColumns(10);
		
		textAño = new JTextField();
		textAño.setBounds(195, 196, 32, 20);
		contentPane.add(textAño);
		textAño.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Ciudad");
		lblNewLabel_7.setBounds(39, 251, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textCiudad = new JTextField();
		textCiudad.setBounds(90, 248, 86, 20);
		contentPane.add(textCiudad);
		textCiudad.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Departamento");
		lblNewLabel_8.setBounds(191, 251, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		textDepartamento = new JTextField();
		textDepartamento.setBounds(255, 248, 86, 20);
		contentPane.add(textDepartamento);
		textDepartamento.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Pais");
		lblNewLabel_9.setBounds(401, 251, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		textPais = new JTextField();
		textPais.setBounds(434, 248, 86, 20);
		contentPane.add(textPais);
		textPais.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(418, 299, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConsultar) {
			Long idDocumento=Long.parseLong(textDocumetno.getText());
			PersonaVo p=miCoordinador.setConsultarPersona(idDocumento);
			
			if (p!=null) {
				
				p.setNacimiento(miCoordinador.consultarNacimiento(p.getNacimiento().getIdNacimiento()));
				System.out.println(p);				
				textNombre.setText(p.getNombre());
				textProfecion.setText(p.getProfesion());
				textTelefono.setText(p.getTelefono());
				textTipo.setText(p.getTipo()+"");
				
				textCiudad.setText(p.getNacimiento().getCiudadNacimiento());
				textDepartamento.setText(p.getNacimiento().getDepartamentoNacimiento());
				textPais.setText(p.getNacimiento().getPaisNacimiento());
				textDia.setText(p.getNacimiento().getFechaNacimiento().getDayOfMonth()+"");
				textMes.setText(p.getNacimiento().getFechaNacimiento().getMonthValue()+"");
				textAño.setText(p.getNacimiento().getFechaNacimiento().getYear()+"");
					
			}else {
				JOptionPane.showMessageDialog(null,"No se encuentra la persona, verifique el documento","ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}			
		}

	}


	public void setCoordinador(Coordinador miCoordinador) {

		this.miCoordinador = miCoordinador;
		
	}

		
		
	}


