import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class Search extends JFrame implements ActionListener
{
	JLabel Roll,name,Address;
	JTextField tRoll,tname,tAddress;
	JButton Search,Update,Home;
	JPanel p1,p2,p3,p4,mp;
        Connection con;
	PreparedStatement pst,pst1;
	ResultSet rs;
	public Search()
	{
		setTitle("Search");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		Roll=new JLabel("Roll");
		name=new JLabel("Name");
		Address=new JLabel("Address");
		tRoll =new JTextField(20);
		tname =new JTextField(20);
		tAddress =new JTextField(20);
		Search=new JButton("Search");
		Update=new JButton("Update");
		Home=new JButton("Home");
		p1.add(Roll);
		p1.add(tRoll);
		p2.add(name);
		p2.add(tname);
		p3.add(Address);
		p3.add(tAddress);
		p1.add(Search);
		p4.add(Update);
		p4.add(Home);
		mp=new JPanel(new GridLayout(10,1));
		mp.add(p1);
		mp.add(p2);
		mp.add(p3);
		mp.add(p4);
		add(mp);
		setVisible(true);
		setBounds(50,50,750,800);
		Search.addActionListener(this);
		Update.addActionListener(this);
		Home.addActionListener(this);
                 try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","sumit","1234");
        pst=con.prepareStatement("Select * from student where roll=?");
        pst1=con.prepareStatement("update student set name=? , address=? where roll=?");
      
       }catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Error in connection");
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e)
		{
				if(e.getSource()==Search)
						{
                                                    try{
                             int r=Integer.parseInt(tRoll.getText());
                             pst.setInt(1,r);
                         
                           rs=pst.executeQuery();
                        if(rs.next())
                        {
                             JOptionPane.showMessageDialog(this,"Search Successful");
                             String n=rs.getString(2);
                             String ad=rs.getString(3);
                             tname.setText(n);
                             tAddress.setText(ad);

                        }
                        else
                        {
                             JOptionPane.showMessageDialog(this,"Search failed");
                        }
                        }catch(Exception ev)
                    {
                        JOptionPane.showMessageDialog(this,"Search failed");
                        ev.printStackTrace();
                    }

		}
			if(e.getSource()==Update)
					{
                                            try{
                             int r=Integer.parseInt(tRoll.getText());
                             String use=tname.getText();
                         String pas=tAddress.getText();
                         pst1.setInt(3,r);
                         pst1.setString(1,use);
                         pst1.setString(2,pas);
                           rs=pst1.executeQuery();
                         if(rs.next())
                        {
                             JOptionPane.showMessageDialog(this,"Update Successful");
                             
                        }
                        else
                        {
                             JOptionPane.showMessageDialog(this,"Update failed");
                        }
                        }catch(Exception ev)
                    {
                        JOptionPane.showMessageDialog(this,"Update failed");
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
		new Search();
	}
}