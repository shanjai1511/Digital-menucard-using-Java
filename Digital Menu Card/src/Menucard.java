import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class Menucard implements ActionListener
{
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label,label1;
	JButton button,button1,button2,bu;
	static JTable table;
	String[] columnNames = {"item", "price"};
	String[] starters = {"item", "price"};
	String[] maincourse = {"item", "price"};
	String[] desserts = {"item", "price"};
	private enum Actions
	{
		MAINCOURSE,
		STARTERS,
		MAINPAGE
	}
	public void createUI()
	{
		frame = new JFrame("La Cabana - peace to eat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		textbox = new JTextField();
		label = new JLabel("Food for us comes from our relatives, whether they have wings or fins or roots. "+
				"That is how we consider food. Food has a culture. It has a history. It has a story. It has a relationship.");
		label.setBounds(10, 20, 50000, 20);
		label1= new JLabel("Click to fill your mouth");
		label1.setBounds(10, 40, 50000, 20);
		button = new JButton("Starters");
		button.setBounds(10,130,150,20);
		button.setActionCommand(Actions.STARTERS.name());
		button.addActionListener(this);
		button.setLocation(200 , 150);
		button1 = new JButton("Main Course");
		button1.setBounds(20,130,150,20);
		button1.setActionCommand(Actions.MAINCOURSE.name());
		button1.addActionListener(this);
		button1.setLocation(400 , 150);
		button2 = new JButton("Desserts");
		button2.setBounds(120,10,150,20);
		button2.addActionListener(this);
		button2.setLocation(600 , 150);
		frame.add(textbox);
		frame.add(label);
		frame.add(label1);
		frame.add(button);
		frame.add(button1);
		frame.add(button2);
		frame.pack();
		frame.setVisible(true);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getActionCommand() == Actions.MAINCOURSE.name())
		{
			showMainCourse();
		}
		else if (evt.getActionCommand() == Actions.STARTERS.name())
		{
			showStarters();
		}
		else if(evt.getActionCommand() == Actions.MAINPAGE.name())
		{
			createUI();
		}
		else
		{
			showDesserts();
		}
	}
	public void showStarters()
	{
		frame1 = new JFrame("Menu Card");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model);
		table.setSize(8, 5);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		String roll= "";
		int name= 0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "root");
			String sql = "select item,price from starters";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				roll = rs.getString("item");
				name = rs.getInt("price");
				model.addRow(new Object[]{roll, name});
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		bu = new JButton("MAIN PAGE");
		bu.setBounds(120,10,150,20);
		bu.setActionCommand(Actions.MAINPAGE.name());
		bu.addActionListener(this);
		bu.setLocation(900 ,300);
		frame1.add(bu);
		frame1.add(scroll);
		frame1.setVisible(true);
		frame1.setVisible(true);
		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame1.setUndecorated(true);
		frame1.setVisible(true);
	}
	public void showMainCourse()
	{
		frame1 = new JFrame("Menu Card");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model);
		table.setSize(8, 5);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		String roll= "";
		int name= 0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "root");
			String s = "select item,price from maincourse";
			PreparedStatement p = con.prepareStatement(s);
			ResultSet r = p.executeQuery();
			while(r.next())
			{
				roll = r.getString("item");
				name = r.getInt("price");
				model.addRow(new Object[]{roll, name});
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		bu = new JButton("MAIN PAGE");
		bu.setBounds(120,10,150,20);
		bu.setActionCommand(Actions.MAINPAGE.name());
		bu.addActionListener(this);
		bu.setLocation(900 ,300);
		frame1.add(bu);
		frame1.add(scroll);
		frame1.setVisible(true);
		frame1.setVisible(true);
		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame1.setUndecorated(true);
		frame1.setVisible(true);
	}
	public void showDesserts()
	{
		frame1 = new JFrame("Menu Card");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model);
		table.setSize(8, 5);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		String roll= "";
		int name= 0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "root");
			String sql = "select item,price from dessert";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				roll = rs.getString("item");
				name = rs.getInt("price");
				model.addRow(new Object[]{roll, name});
			}
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		bu = new JButton("MAIN PAGE");
		bu.setBounds(120,10,150,20);
		bu.setActionCommand(Actions.MAINPAGE.name());
		bu.addActionListener(this);
		bu.setLocation(900 ,300);
		frame1.add(bu);
		frame1.add(scroll);
		frame1.setVisible(true);
		frame1.setVisible(true);
		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame1.setUndecorated(true);
		frame1.setVisible(true);
	}
	public static void main(String args[])
	{
		Menucard sr = new Menucard();
		sr.createUI();
	}
}