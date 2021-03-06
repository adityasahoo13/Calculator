import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Mycalculator extends JFrame implements ActionListener 
{
	static JFrame f; //create a frame
	static JTextField j; //create a textfield
	String s0, s1, s2; //store operator and operands
	Mycalculator()
	{
		s0 = s1 = s2 = "";
	}
	public static void main(String[] args)
	{
		f = new JFrame("calculator");
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
		Mycalculator m = new Mycalculator();//creating the object
		j = new JTextField(16);//creating a text field
		j.setEditable(false);//set the textfield to non editable

		//create number buttons and some operators
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bm, bd, be, beq, bc;

		//creating number buttons
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		//equals buuton
		beq = new JButton("=");

		//create operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bm = new JButton("*");
		bd = new JButton("/");
		bc = new JButton("C");//clear textfield

		be = new JButton(".");//creating . buttons

		JPanel p = new JPanel();//creating jpanel

		bd.addActionListener(m);
		bm.addActionListener(m);
		bs.addActionListener(m);
		ba.addActionListener(m);
		b9.addActionListener(m);
		b8.addActionListener(m);
		b7.addActionListener(m);
		b6.addActionListener(m);
		b5.addActionListener(m);
		b4.addActionListener(m);
		b3.addActionListener(m);
		b2.addActionListener(m);
		b1.addActionListener(m);
		b0.addActionListener(m);
		be.addActionListener(m);
		bc.addActionListener(m);
		beq.addActionListener(m);

		//add elements to panel
		p.add(j);
		p.add(ba);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bs);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bm);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bd);
		p.add(be);
		p.add(b0);
		p.add(bc);
		p.add(beq);

		p.setBackground(Color.blue);
		f.add(p);

		f.setSize(200,200);
		f.show();		
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		if((s.charAt(0)>='0' && s.charAt(0)<='9') || s.charAt(0) == '.')
		{
			if(!s1.equals(""))
				s2 = s2+s;
			else
				s0 = s0+s;
			j.setText(s0+s1+s2);
		}
		else if (s.charAt(0)=='C') 
		{
			s0 = s1 = s2 = "";
			j.setText(s0+s1+s2);
		}
		else if (s.charAt(0)=='=') 
		{
			double te;
			if(s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if(s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if(s1.equals("*"))
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));

			j.setText(s0 + s1 + s2 + "=" + te);
			s0 = Double.toString(te);
			s1 = s2 = "";
		}
		else
		{
			if(s1.equals("") || s2.equals(""))
				s1 = s;
			else 
			{
				double te;
				if(s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if(s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if(s1.equals("*"))
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));	

				s0 = Double.toString(te);

				s1 = s;
				s2 = "";
			}
			j.setText(s0 + s1 + s2);
		}
	}
}