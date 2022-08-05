import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
public class Select implements ActionListener
{
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label,label1;
	JButton button,button1,button2,bu;
	JPanel panel;
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
	public void select()
	{
		frame = new JFrame("La Cabana - peace to eat");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		textbox = new JTextField();
		label = new JLabel("Food for us comes from our relatives, whether they have wings or fins or roots. "+
				"That is how we consider food. Food has a culture. It has a history. It has a story. It has a relationship.");
		label.setBounds(10, 20, 500, 20);
		label1= new JLabel("Click to edit menucard");
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
			MainCourse();
		}
		else if (evt.getActionCommand() == Actions.STARTERS.name())
		{
			Starters();
		}
		else if(evt.getActionCommand() == Actions.MAINPAGE.name())
		{
			select();
		}
		else
		{
			Desserts();
		}
	}
	public void MainCourse()
	{
		MainCourse m= new MainCourse();
		m.edit();
	}
	public void Starters()
	{
		Starters s = new Starters();
		s.edit();
	}
	public void Desserts()
	{
		Desserts d = new Desserts();
		d.edit();
	}
}