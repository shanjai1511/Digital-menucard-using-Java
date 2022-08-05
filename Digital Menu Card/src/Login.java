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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login implements ActionListener
{
	JButton b1;
	JFrame newPanel;
	JLabel userLabel, passLabel;
	JTextField  textField1;
	JPasswordField textField2;
	void CreateLoginForm()
	{
		newPanel = new JFrame("La Cabana - peace to eat");
		newPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newPanel.setLayout(null);
		userLabel = new JLabel();
		userLabel.setText("Username");
		userLabel.setBounds(10, 20, 200, 20);
		textField1 = new JTextField(15);
		textField1.setBounds(100, 20, 200, 30);
		passLabel = new JLabel();
		passLabel.setText("Password");
		passLabel.setBounds(10, 70, 200, 30);
		textField2 = new JPasswordField(15);
		textField2.setBounds(100, 70, 200, 30);
		b1 = new JButton("SUBMIT");
		b1.setBounds(200, 130, 200, 30);
		b1.addActionListener(this);
		newPanel.add(userLabel);
		newPanel.add(textField1);
		newPanel.add(passLabel);
		newPanel.add(textField2);
		newPanel.add(b1);
		newPanel.pack();
		newPanel.setVisible(true);
		newPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
		newPanel.setVisible(true);
	}  
    public void actionPerformed(ActionEvent e)
    {
        showData();
    }
    public void showData()
    {
		String str1 = textField1.getText();
        char[] p = textField2.getPassword();
        String str2 = new String(p);
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "root");
            PreparedStatement ps = con.prepareStatement("select * from reg where user=? and pass=?");
            ps.setString(1, str1);
            ps.setString(2, str2);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
            	Select s=new Select();
            	s.select();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Incorrect username or password..Try Again with correct detail");
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
    public static void main(String arr[])
    {
        Login l=new Login();
        l.CreateLoginForm();
    }
}