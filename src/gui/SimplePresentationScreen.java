package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textLU;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textGithub;
	private JLabel labelImage;
	private DateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
	private DateFormat hora = new SimpleDateFormat("HH:mm:ss");
	private Calendar cal = Calendar.getInstance();
	private ImageIcon icon;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 250));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		
		JLabel labelLU = new JLabel("LU");
		
		JLabel labelApellido = new JLabel("Apellido");
		
		JLabel labelNombre = new JLabel("Nombre");
		
		JLabel labelEmail = new JLabel("E-mail");
		
		JLabel labelGithub = new JLabel("Github URL");
		
		textLU = new JTextField();
		textLU.setDisabledTextColor(Color.WHITE);
		textLU.setText(String.valueOf(studentData.getId()));
		textLU.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setText(studentData.getLastName());
		textApellido.setDisabledTextColor(Color.WHITE);
		textApellido.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setText(studentData.getFirstName());
		textNombre.setDisabledTextColor(Color.WHITE);
		textNombre.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setText(studentData.getMail());
		textEmail.setDisabledTextColor(Color.WHITE);
		textEmail.setColumns(10);
		
		textGithub = new JTextField();
		textGithub.setText(studentData.getGithubURL());
		textGithub.setDisabledTextColor(Color.WHITE);
		textGithub.setColumns(10);
		GroupLayout gl_tabInformation = new GroupLayout(tabInformation);
		gl_tabInformation.setHorizontalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING)
						.addComponent(labelLU)
						.addComponent(labelApellido)
						.addComponent(labelNombre)
						.addComponent(labelEmail)
						.addComponent(labelGithub))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textLU, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
						.addComponent(textGithub)
						.addComponent(textEmail)
						.addComponent(textNombre)
						.addComponent(textApellido))
					.addContainerGap())
		);
		gl_tabInformation.setVerticalGroup(
			gl_tabInformation.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_tabInformation.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelLU)
						.addComponent(textLU, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelApellido)
						.addComponent(textApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelNombre)
						.addComponent(textNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelEmail)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_tabInformation.createParallelGroup(Alignment.TRAILING)
						.addComponent(labelGithub)
						.addComponent(textGithub, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35))
		);
		tabInformation.setLayout(gl_tabInformation);
		contentPane.add(tabbedPane, BorderLayout.WEST);
		
		JLabel lblNewLabel_5 = new JLabel("Esta ventana fue generada el "+fecha.format(cal.getTime())+" a las "+hora.format(cal.getTime()));
		contentPane.add(lblNewLabel_5, BorderLayout.SOUTH);
		
		labelImage = new JLabel("");
		labelImage.setIcon(new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto())));
		labelImage.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(labelImage, BorderLayout.EAST);
	}
}
