package login;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Welcome
{

	JFrame frame;

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
					Welcome window = new Welcome();
					window.frame.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	static public void makeLink(JLabel link)
	{
		link.setForeground(Color.BLUE.darker());
		link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	private void initialize()
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(151, 178, 583, 529);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(109, 10, 365, 160);
		panel.add(lblWelcome);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Roboto", Font.BOLD, 49));
		
		JLabel lblinfo = new JLabel("Please login to continue.");
		lblinfo.setFont(new Font("Roboto", Font.PLAIN, 25));
		lblinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblinfo.setBounds(155, 124, 272, 29);
		panel.add(lblinfo);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				Login obj = new Login();
				(obj.frame).setVisible(true);
				frame.dispose();
			}
		});
		lblLogin.setFont(new Font("Roboto", Font.PLAIN, 25));
		lblLogin.setBounds(155, 267, 62, 29);
		makeLink(lblLogin);
		panel.add(lblLogin);
		
		JLabel lblReg = new JLabel("New user? Register");	//
		lblReg.setFont(new Font("Roboto", Font.PLAIN, 25));
		lblReg.setBounds(155, 306, 216, 29);
		makeLink(lblReg);
		panel.add(lblReg);
		
		JLabel lblTitle = new JLabel("BookMyHotel");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Roboto", Font.BOLD, 49));
		lblTitle.setBounds(10, -78, 300, 246);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblSubtitle = new JLabel("A one-stop solution for all your hotel-booking queries.");
		lblSubtitle.setFont(new Font("Roboto", Font.PLAIN, 30));
		lblSubtitle.setBounds(10, 43, 795, 125);
		frame.getContentPane().add(lblSubtitle);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
