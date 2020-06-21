import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Delete extends JFrame implements ActionListener
{
	JLabel Roll;
	JTextField tRoll;
	JButton Delete,Home;
	JPanel p1,p2,mp;
        Connection con;
	PreparedStatement pst;
	ResultSet rs;
	public Delete()
	{
		setTitle("Delete");
		p1=new JPanel();
		p2=new JPanel();
		Roll=new JLabel("Roll");
		tRoll =new JTextField(20);
		Delete=new JButton("Delete");
		Home=new JButton("Home");
		p1.add(Roll);
		p1.add(tRoll);
		p2.add(Delete);
		p2.add(Home);
		mp=new JPanel(new GridLayout(10,1));
		mp.add(p1);
		mp.add(p2);
		add(mp);
		setVisible(true);
		setBounds(50,50,750,800);
		Delete.addActionListener(this);
		Home.addActionListener(this);
                 try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","sumit","1234");
        pst=con.prepareStatement("Delete from student where roll=?");
      
       }catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Error in connection");
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource()==Delete)
					{
                                            try{
                             int r=Integer.parseInt(tRoll.getText());
                         
                         pst.setInt(1,r);
                          rs=pst.executeQuery();
                        if(rs.next())
                        {
                             JOptionPane.showMessageDialog(this,"Delete Successful");

                        }
                        else
                        {
                             JOptionPane.showMessageDialog(this,"Invalid Delete");
                        }
                        }catch(Exception ev)
                    {
                        JOptionPane.showMessageDialog(this,"Invalid Delete");
                        ev.printStackTrace();
                    }

		}
			if(e.getSource()==Home)
					{
					new HomePage();
		}
	}

	public static void main(String asd[])
	{
		new Delete();
	}
}