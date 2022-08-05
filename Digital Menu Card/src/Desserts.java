import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Desserts implements ActionListener
{
	JButton b1 = new JButton("Insert"),b2 = new JButton("Delete"),b3=new JButton("BACK");
	JFrame frame1;
	JTextField f1=new JTextField(60),f2=new JTextField(60),f3=new JTextField(60),f4=new JTextField(60);
	JLabel l1 = new JLabel(),l2 = new JLabel(),l3 = new JLabel(),l4 = new JLabel(),l5 = new JLabel(),l6 = new JLabel();	
	private enum Actions
	{
		INSERT,
		DELETE,
		MAINPAGE
	}
	public void edit()
	{
		frame1 = new JFrame("Edit Dessert");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(null);
		l1.setText("Details to insert in the menu");
		l1.setBounds(10, 20, 200, 20);
		l2.setText("Item Name :");
		l2.setBounds(100, 70, 200, 30);
		f1.setBounds(200,70,200,30);
		l3.setText("Price :");
		l3.setBounds(100,110,200,30);
		f2.setBounds(200,110,200,30);
		l4.setText("Id :");
		l4.setBounds(100,150,200,30);
		f3.setBounds(200,150,200,30);
		b1.setBounds(150,200,200,30);
		b1.setActionCommand(Actions.INSERT.name());
		b1.addActionListener(this);
		l5.setText("Details to delete in the menu");
		l5.setBounds(10,250,200,20);
		l6.setText("Id :");
		l6.setBounds(100,290,200,30);
		f4.setBounds(200,290,200,30);
		b2.setBounds(150,340,200,30);
		b2.setActionCommand(Actions.DELETE.name());
		b2.addActionListener(this);
		b3.setBounds(100,400,100,20);
		b3.setActionCommand(Actions.MAINPAGE.name());
		b3.addActionListener(this);
		frame1.add(l1);
		frame1.add(l2);
		frame1.add(f1);
		frame1.add(l3);
		frame1.add(f2);
		frame1.add(l4);
		frame1.add(f3);
		frame1.add(b1);
		frame1.add(l5);
		frame1.add(l6);
		frame1.add(f4);
		frame1.add(b2);
		frame1.add(b3);
		frame1.pack();
		frame1.setVisible(true);
		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame1.setVisible(true);
	}
	public void actionPerformed(ActionEvent evt)
    {
		if (evt.getActionCommand() == Actions.INSERT.name())
		{
			insert();
		}
		else if (evt.getActionCommand() == Actions.DELETE.name())
		{
			delete();
		}
		else if(evt.getActionCommand() == Actions.MAINPAGE.name())
		{
			Select s = new Select();
			s.select();
		}
    }
	public void insert()
	{
		String item = f1.getText();
		int price = f2.getX();
		String id = f3.getText();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "root");
            PreparedStatement ps = con.prepareStatement("insert into dessert values(?,?,?)");
            ps.setString(1, item);
            ps.setInt(2, price);
            ps.setString(3, id);
            ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
	public void delete()
	{
		String id = f4.getText();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "root");
            PreparedStatement ps = con.prepareStatement("delete from dessert where id=?");
            ps.setString(1, id);
            ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
	}
}