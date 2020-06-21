import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
public class DisplayAll extends JFrame implements ActionListener
{
        JPanel p1,p2,mp;
        JTable tab;
        JButton Home,Exit;
        Connection con;
	PreparedStatement pst;
	ResultSet rs;
        DisplayAll()
        {
            setTitle("Display All");
		p1=new JPanel();
		p2=new JPanel();
                mp=new JPanel();
                tab=new JTable();
                Home=new JButton("Home");
                Exit=new JButton("Exit");
                p1.add(tab);
                p2.add(Home);
                p2.add(Exit);
                mp.add(p1);
                mp.add(p2);
                add(mp);
                setVisible(true);
                setBounds(50,50,750,800);
                Home.addActionListener(this);
                Exit.addActionListener(this);
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
        public void actionPerformed(ActionEvent e)
		{
				if(e.getSource()==Home)
        			new HomePage();
		  		if(e.getSource()==Exit)
				{
					System.exit(0);
				}
        }
        public static void main(String asd[])
        {
            new DisplayAll();
        }
}
