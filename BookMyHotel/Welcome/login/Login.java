package login;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login
{
	Connection conn;
	JFrame frame;
	private JTextField txtLogin;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Login window = new Login();		
					window.frame.setVisible(true);
				} 
				catch (Exception e)
				{
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login()
	{
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
			initialize();
		}
		catch(SQLException e)
		{
			JLabel errLabel = new JLabel("Encountered error in establishing "
					+ "connection to server. Check the server and try again.");
			errLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			UIManager.put("Button.background", Color.white);
			JOptionPane.showMessageDialog(frame, errLabel, "Error",JOptionPane.ERROR_MESSAGE,null);
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		JPanel panel = new JPanel();
		panel.setBounds(151, 117, 583, 529);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel loginLabel = new JLabel("Username");
		loginLabel.setFont(new Font("Roboto", Font.PLAIN, 20));
		loginLabel.setBounds(173, 182, 128, 31);
		panel.add(loginLabel);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtLogin.setBounds(281, 185, 136, 25);
		panel.add(txtLogin);
		txtLogin.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnSubmit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				checkLogin(frame);
			}
		});
		btnSubmit.setBounds(239, 318, 105, 31);
		panel.add(btnSubmit);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtPass.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					checkLogin(frame);
			}
		});
		txtPass.setBounds(281, 253, 136, 25);
		panel.add(txtPass);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
		lblPassword.setBounds(173, 250, 128, 31);
		panel.add(lblPassword);
		
		JLabel lblHome = new JLabel("Back to Home");
		lblHome.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Welcome obj = new Welcome();
				(obj.frame).setVisible(true);
				frame.dispose();
			}
		});
		lblHome.setForeground(new Color(0, 0, 178));
		lblHome.setFont(new Font("Roboto", Font.PLAIN, 25));
		lblHome.setBounds(10, 10, 156, 29);
		panel.add(lblHome);
		Welcome.makeLink(lblHome);
		
		JLabel lblBookmyhotel = new JLabel("BookMyHotel");
		lblBookmyhotel.setFont(new Font("Roboto", Font.BOLD, 38));
		lblBookmyhotel.setBounds(10, 10, 266, 46);
		frame.getContentPane().add(lblBookmyhotel);
	}
	
	private void checkLogin(JFrame f)
	{	
		
		
		String uname = txtLogin.getText();
		String pass = txtPass.getText();
		
		try
		{
			Statement stmt = conn.createStatement();
			String qry = "SELECT password FROM login WHERE username='"+uname+"'";
			ResultSet rs = stmt.executeQuery(qry);
			
			JLabel errLabel = new JLabel("");
			errLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			UIManager.put("Button.background", Color.white);
			
			if(rs.next())
			{
				if(rs.getString(1).equals(pass))
				{
					errLabel.setText("Successful Login.");
					JOptionPane.showMessageDialog(f, errLabel);
				}
				else
				{
					errLabel.setText("Invalid Login.");
					JOptionPane.showMessageDialog(f, errLabel);
				}
			}
			else
			{
				errLabel.setText("Invalid username.");
				JOptionPane.showMessageDialog(f, errLabel);
			}
		}
		catch(SQLException e)
		{
			
		}
	}
}
