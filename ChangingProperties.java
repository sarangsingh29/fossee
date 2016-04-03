/*

	Kumar Saarang Singh	
	Phone Number: (+91)9663587900
	Primary e-Mail: psarang29@gmail.com
	Secondary e-Mail: sarangsingh29@yahoo.com


	Input: There is no input from the user initially.
	Working: 
	1. User has to RIGHT-CLICK the label "Changing Properties" to get the pop-up menu.
	2. The PopupMenu has three items (Dummy1, Dummy2 and Properties).
	3. The first two menu items, simply create a Message Dialog to display a message.
	4. The properties item, when clicked, will open a Dialog.
	5. The dialog has three fields
	   i) Change Text : 
	   		A new text can be specified here to be displayed on the label.
	  ii) Change Foreground Color
	  		#This option takes 3 input INTEGER values (between 0-255), corresponding to red, green and 
	  		 blue components of the color.
	  		#Corresponding color will be the text color of the label.
	 iii) Change Background Color 
	 		#This option takes 3 input INTEGER values (between 0-255), corresponding to red, green and 
	  		 blue components of the color.
			#Corresponding color will be the background color of the label.

	References:
	1. docs.oracle.com/javase 
	2. JAVA, The complete reference (Herbert Schildt)

*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.SwingUtilities;

public class ChangingProperties
{
	static JFrame frame;
	static JLabel label;
	static JPopupMenu pupmenu;
	public static void main(String[]args)
	{
		Dimension frameDim=new Dimension(600,600);
		frame=new JFrame("Changing Properties");
		frame.setSize(frameDim);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,5,(frameDim.height/2)-20));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		label=new JLabel("Changing Properties");
		label.setOpaque(true);
		label.setFont(new Font(label.getFont().getName(),Font.BOLD,30));
		label.setSize(400,400);

		label.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				if(pupmenu!=null)
					pupmenu.setVisible(false);

				pupmenu=new JPopupMenu();
				boolean rbut=SwingUtilities.isRightMouseButton(e);

				if(rbut)
				{
					JMenuItem mi1=new JMenuItem("Dummy1");
					JMenuItem mi2=new JMenuItem("Dummy2");
					JMenuItem mi3=new JMenuItem("Properties");

					mi1.addMouseListener(new MouseAdapter()
					{
						public void mouseClicked(MouseEvent e)
						{
							pupmenu.setVisible(false);
							JOptionPane.showMessageDialog(frame,"This application is created for FOSSEE.");
						}
					});

					mi2.addMouseListener(new MouseAdapter()
					{
						public void mouseClicked(MouseEvent e)
						{
							pupmenu.setVisible(false);
							JOptionPane.showMessageDialog(frame,"Created by Kumar Saarang Singh (psarang29@gmail.com).");
						}
					});

					mi3.addMouseListener(new MouseAdapter()
					{
						public void mouseClicked(MouseEvent e)
						{
							pupmenu.setVisible(false);
							final JDialog dialog=new JDialog(frame,"Properties");
							
							
							JPanel panel1=new JPanel();
							JPanel panel2=new JPanel();
							JPanel panel3=new JPanel();

							panel1.setLayout(new FlowLayout(FlowLayout.CENTER,55,5));



							final JTextField forecolred=new JTextField(3);
							final JTextField forecolgreen=new JTextField(3);
							final JTextField forecolblue=new JTextField(3);
							final JTextField backcolred=new JTextField(3);
							final JTextField backcolgreen=new JTextField(3);
							final JTextField backcolblue=new JTextField(3);
							final JTextField settext=new JTextField(10);

							Button submit=new Button("Submit");

							panel1.setSize(300,100);
							panel1.add(new JLabel("Change Text"),FlowLayout.LEFT);
							panel1.add(settext);

							panel2.setSize(300,100);
							panel2.add(new JLabel("Foreground Color (RGB)"));
							panel2.add(forecolred);
							panel2.add(forecolgreen);
							panel2.add(forecolblue);

							panel3.setSize(300,100);
							panel3.add(new JLabel("Background Color (RGB)"));
							panel3.add(backcolred);
							panel3.add(backcolgreen);
							panel3.add(backcolblue);


							submit.addMouseListener(new MouseAdapter(){
								public void mouseClicked(MouseEvent e)
								{
									Color prevfore=label.getForeground();
									Color prevback=label.getBackground();
									int backr=prevback.getRed(),backg=prevback.getGreen(),backb=prevback.getBlue();
									int forer=prevfore.getRed(),foreg=prevfore.getGreen(),foreb=prevfore.getBlue();
									
									String text;

						
									
									try
									{
										if(!settext.getText().equals(""))
										{
											label.setText(settext.getText());
										}
										if(!backcolred.getText().equals(""))
											backr=Integer.parseInt(backcolred.getText());
										if(!backcolgreen.getText().equals(""))
											backg=Integer.parseInt(backcolgreen.getText());
										if(!backcolblue.getText().equals(""))
											backb=Integer.parseInt(backcolblue.getText());																			
									
										if(!forecolred.getText().equals(""))
											forer=Integer.parseInt(forecolred.getText());
										if(!forecolgreen.getText().equals(""))
											foreg=Integer.parseInt(forecolgreen.getText());
										if(!forecolblue.getText().equals(""))
											foreb=Integer.parseInt(forecolblue.getText());

										label.setBackground(new Color(backr,backg,backb));
										label.setForeground(new Color(forer,foreg,foreb));

										dialog.dispose();
									}

									catch(Exception exp)
									{
										JOptionPane.showMessageDialog(frame,"Please Enter Integer Values for RGB components.");
										backcolred.setText(""); backcolgreen.setText(""); backcolblue.setText("");
										forecolred.setText(""); forecolgreen.setText(""); forecolblue.setText("");
									}
								}	
							});

							dialog.setLayout(new GridLayout(4,1));
							dialog.add(panel1);
							dialog.add(panel2);
							dialog.add(panel3);
							dialog.add(submit);
							dialog.setSize(400,300);
							dialog.setVisible(true);
						}
					});
					
					pupmenu.setPopupSize(100,100);
					pupmenu.add(mi1);
					pupmenu.add(mi2);
					pupmenu.add(mi3);
					pupmenu.setLocation(e.getXOnScreen(),e.getYOnScreen());
					pupmenu.setVisible(true);


					/*
						Hide the pop-up if idle for 5 seconds
					*/
					java.util.Timer timer=new java.util.Timer();
					timer.schedule(new TimerTask(){
						public void run()
						{
							pupmenu.setVisible(false);
						}
					},5000);
				}
			}
		});


		frame.add(label);
		frame.setVisible(true);
	}
}
