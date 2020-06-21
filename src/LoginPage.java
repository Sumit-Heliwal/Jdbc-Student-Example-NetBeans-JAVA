import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginPage extends JFrame implements ActionListener
{
	JTextField user,pass;
	JLabel userid,password;
	JButton Login,Exit;
	JPanel p1,p2,p3,mp;
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	public LoginPage()
	{
		setTitle("Login Page");
		user =new JTextField(20);
		pass =new JTextField(20);
		userid=new JLabel("USER ID");
		password=new JLabel("Password");
		p1=new JPanel();
		mp=new JPanel(new GridLayout(3,1));
		p1.add(userid);
		p1.add(user);
		mp.add(p1);
		p2=new JPanel();
		p2.add(password);
		p2.add(pass);
		mp.add(p2);
		Login=new JButton("Login");
		Exit=new JButton("Exit");
		p3=new JPanel();
		p3.add(Login);
		p3.add(Exit);
		mp.add(p3);
		add(mp);
		setVisible(true);
		setLayout(new FlowLayout());
		setBounds(50,50,750,800);
		Login.addActionListener(this);
		Exit.addActionListener(this);
		try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","sumit","1234");
       
	pst=con.prepareStatement("Select * from userdetail where username=? and password=?");
      
        		JOptionPane.showMessageDialog(this,"connection successfull");
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Error in connection");
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Login)
		{
                    try{
                         String use=user.getText();
                         String pas=pass.getText();
                         pst.setString(1, use);
                         pst.setString(2, pas);
                           rs=pst.executeQuery();
                        if(rs.next())
                        {
                             JOptionPane.showMessageDialog(this,"Login Success");
                             new HomePage();
                        }
                        else
                        {
                             JOptionPane.showMessageDialog(this,"Invalid userid password");
                        }
                    }catch(Exception ev)
                    {
                        JOptionPane.showMessageDialog(this,"Invalid userid password");
                        ev.printStackTrace();
                    }
                    }
			
		
		if(e.getSource()==Exit)
		System.exit(0);
	}
	public static void main(String asd[])
	{
		new LoginPage();
	}
}