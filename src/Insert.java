import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Insert extends JFrame implements ActionListener
{
	JLabel Roll,name,Address;
	JTextField tRoll,tname,tAddress;
	JButton Insert,Clear,Home;
	JPanel p1,p2,p3,p4,mp;
        Connection con;
	PreparedStatement pst;
	ResultSet rs;
	public Insert()
	{
		setTitle("Insert");
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
		Insert=new JButton("Insert");
		Clear=new JButton("Clear");
		Home=new JButton("Home");
		p1.add(Roll);
		p1.add(tRoll);
		p2.add(name);
		p2.add(tname);
		p3.add(Address);
		p3.add(tAddress);
		p4.add(Insert);
		p4.add(Clear);
		p4.add(Home);
		mp=new JPanel(new GridLayout(10,1));
		mp.add(p1);
		mp.add(p2);
		mp.add(p3);
		mp.add(p4);
		add(mp);
		setVisible(true);
		setBounds(50,50,750,800);
		Insert.addActionListener(this);
		Clear.addActionListener(this);
		Home.addActionListener(this);
                try{
			  Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","sumit","1234");
        pst=con.prepareStatement("Insert into student values(?,?,?)");
      
       }catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"Error in connection");
			e.printStackTrace();
		}

	}
	public void actionPerformed(ActionEvent e)
		{
                        if(e.getSource()==Insert)
                    {
                         try{
                             int r=Integer.parseInt(tRoll.getText());
                         String use=tname.getText();
                         String pas=tAddress.getText();
                         pst.setInt(1,r);
                         pst.setString(2,use);
                         pst.setString(3,pas);
                           rs=pst.executeQuery();
                        if(rs.next())
                        {
                             JOptionPane.showMessageDialog(this,"Insert Successful");

                        }
                        else
                        {
                             JOptionPane.showMessageDialog(this,"Invalid Insert");
                        }
                        }catch(Exception ev)
                    {
                        JOptionPane.showMessageDialog(this,"Invalid Insert");
                        ev.printStackTrace();
                    }
                    }
		if(e.getSource()==Clear)
			{
                         tRoll.setText("");
                         tname.setText("");
                         tAddress.setText("");

		}
		if(e.getSource()==Home)
			{
			new HomePage();
		}
		}

	public static void main(String asd[])
	{
		new Insert();
	}
}