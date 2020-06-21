import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import sumitjdbcexamples.DisplayAllData;
public class HomePage extends JFrame implements ActionListener
{
	JButton Insert,Search,Delete,Display,DisplayAll;
	JPanel p1,p2,p3,p4,p5,mp;
	public HomePage()
	{
		setTitle("Home Page");
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		Insert=new JButton("Insert");
		Search=new JButton("Search");
		Delete=new JButton("Delete");
		Display=new JButton("Display");
		DisplayAll=new JButton("DisplayAll");
		p1.add(Insert);
		p2.add(Search);
		p3.add(Delete);
		p4.add(Display);
		p5.add(DisplayAll);
		mp=new JPanel(new GridLayout(10,1));
		mp.add(p1);
		mp.add(p2);
		mp.add(p3);
		mp.add(p4);
		mp.add(p5);
		add(mp);
		setVisible(true);
		setBounds(50,50,750,800);
		Insert.addActionListener(this);
		Search.addActionListener(this);
		Delete.addActionListener(this);
		Display.addActionListener(this);
		DisplayAll.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==Insert)
		{
			new Insert();
		}
		if(e.getSource()==Search)
		{
				new Search();
		}
	if(e.getSource()==Delete)
		{
			new Delete();
		}
	if(e.getSource()==Display)
			{
			new Display();
		}
			if(e.getSource()==DisplayAll)
					{
                new DisplayAllData();

		}
	}
	public static void main(String asd[])
	{
		new HomePage();
	}
}