import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class Display extends JFrame implements ActionListener
{
	JLabel Roll,name,Address;
	JTextField tRoll,tname,tAddress;
	JButton first,prev,next,last,Home;
	JPanel p1,p2,p3,p4,mp;
        Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public Display()
	{
		setTitle("Display");
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
		first=new JButton("<<");
		prev=new JButton("<");
		next=new JButton(">");
		last=new JButton(">>");
		Home=new JButton("Home");
		p1.add(Roll);
		p1.add(tRoll);
		p2.add(name);
		p2.add(tname);
		p3.add(Address);
		p3.add(tAddress);
		p4.add(first);
		p4.add(next);
		p4.add(prev);
		p4.add(last);
		p4.add(Home);
		mp=new JPanel(new GridLayout(10,1));
		mp.add(p1);
		mp.add(p2);
		mp.add(p3);
		mp.add(p4);
		add(mp);
		setVisible(true);
		setBounds(50,50,750,800);
		first.addActionListener(this);
		prev.addActionListener(this);
		next.addActionListener(this);
		last.addActionListener(this);
		Home.addActionListener(this);
                 try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","sumit","1234");
         pst=con.prepareStatement("Select * from student",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         rs=pst.executeQuery();
                    }catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Error in connection");
			e.printStackTrace();
		}
	}
        void display()
        {
                   try{
                           
                        
                            int r=rs.getInt(1);
                             String n=rs.getString(2);
                             String ad=rs.getString(3);
                             tRoll.setText(""+r);
                             tname.setText(n);
                             tAddress.setText(ad);

                       
                        }catch(Exception ev)
                    {
                        JOptionPane.showMessageDialog(this,"Search failed");
                        ev.printStackTrace();
                    }

        }
	public void actionPerformed(ActionEvent e)
		{
				if(e.getSource()==Home)
						{
						new HomePage();
		}
			if(e.getSource()==first)
					{
                                            try{
                                                if(rs.first())
                                                    display();
                                            }catch(Exception ev)
                                            {
                                                ev.printStackTrace();
                                            }

		}
			if(e.getSource()==prev)
					{
                                  try{
                                                if(rs.previous())
                                                    display();
                                            }catch(Exception ev)
                                            {
                                                ev.printStackTrace();
                                            }

		}
			if(e.getSource()==next)
					{
                                  try{
                                                if(rs.next())
                                                    display();
                                            }catch(Exception ev)
                                            {
                                                ev.printStackTrace();
                                            }

		}
			if(e.getSource()==last)
					{
                                  try{
                                                if(rs.last())
                                                    display();
                                            }catch(Exception ev)
                                            {
                                                ev.printStackTrace();
                                            }

		}

		}

	public static void main(String asd[])
	{
		new Display();
	}
}