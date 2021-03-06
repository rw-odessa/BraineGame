import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*;
import java.util.Random;
  
/**
 *
 * @author RW-Odessa
 * 14:38 19.09.2014
 */

class BraineGame implements ActionListener { 
 
	JLabel jlab, jlaba, jlabb; 
	//JButton JButtonStart;
 
    // These variables are used to time the task. 
    long beginT, endT; 

    Random r = new Random();
    int rnd, rnc = 0;
	boolean rnb = false;
	
	AverageTime AT1, AT2;
	
	JButton JButtonStart, JButtonRed, JButtonOrange, JButtonYellow, JButtonGreen, JButtonBlue, JButtonCyan;

	//enum GameColor {�������, ���������, ������, �������, �����, �������}; 	
	
  BraineGame() { 
 
    // Create a new JFrame container. 
    JFrame jfrm = new JFrame("���������� ���� �������, � �� ���� �������"); 
 
    // Specify FlowLayout for the layout manager. 
    //jfrm.setLayout(new FlowLayout());
    //jfrm.setLayout(new BorderLayout());

    GridBagLayout gbag = new GridBagLayout();  
    GridBagConstraints gbc = new GridBagConstraints();  
    jfrm.setLayout(gbag);  
 
    // Create a text-based label.
	
	jlab = new JLabel("START"); 
    //jlaba.setHorizontalTextPosition(SwingConstants.CENTER);
    gbc.anchor = GridBagConstraints.WEST; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.BOTH; // ��������� �������� ��������. GridBagConstraints.NONE GridBagConstraints.HORIZONTAL
    gbc.gridwidth = 3; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 2; // ��������� � ����� �� ��� �
    gbc.gridy = 0; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    gbc.ipadx = 0; // �������������� ���������� �� ����� ������ �� �
    gbc.ipady = 0; // �������������� ���������� �� ����� ������ �� Y
	//jlab.setBackground(Color.black);
	jlab.setFont(new Font("Arial", Font.PLAIN, 64));
    jfrm.add(jlab, gbc);

    jlaba = new JLabel("������� �����, �� - "); 
    jlaba.setHorizontalTextPosition(JLabel.RIGHT);
    gbc.anchor = GridBagConstraints.CENTER; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.BOTH; // ��������� �������� ��������. GridBagConstraints.NONE GridBagConstraints.HORIZONTAL
    gbc.gridwidth = 2; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 0; // ��������� � ����� �� ��� �
    gbc.gridy = 1; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    gbc.ipadx = 0; // �������������� ���������� �� ����� ������ �� �
    gbc.ipady = 0; // �������������� ���������� �� ����� ������ �� Y
    jfrm.add(jlaba, gbc);

    jlabb = new JLabel("������� ����� �� - "); 
    jlabb.setHorizontalTextPosition(JLabel.LEFT);
    gbc.anchor = GridBagConstraints.SOUTH; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.BOTH; // ��������� �������� ��������. GridBagConstraints.NONE GridBagConstraints.HORIZONTAL
    gbc.gridwidth = 2; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 5; // ��������� � ����� �� ��� �
    gbc.gridy = 1; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    gbc.ipadx = 0; // �������������� ���������� �� ����� ������ �� �
    gbc.ipady = 0; // �������������� ���������� �� ����� ������ �� Y
    jfrm.add(jlabb, gbc);


	JButtonStart = new JButton("START"); 
    gbc.anchor = GridBagConstraints.SOUTH; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.BOTH; // ��������� �������� ��������. GridBagConstraints.NONE GridBagConstraints.HORIZONTAL
    gbc.gridwidth = 2; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 2; // ��������� � ����� �� ��� �
    gbc.gridy = 1; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    //gbc.ipadx = 10; // �������������� �������������� ���������� �� ����� ������ �� �
    //gbc.ipady = 10; // �������������� �������������� ���������� �� ����� ������ �� Y
    jlab.setForeground(Color.red);
    JButtonStart.addActionListener(this);
    jfrm.add(JButtonStart, gbc);  


    JButtonRed = new JButton("�������"); 
    gbc.anchor = GridBagConstraints.SOUTH; // ��������������� ������ ������. CENTER SOUTH HORIZONTAL
    gbc.fill = GridBagConstraints.HORIZONTAL; // ��������� �������� ��������. GridBagConstraints.NONE GridBagConstraints.HORIZONTAL
    gbc.gridwidth = 1; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 0; // ��������� � ����� �� ��� �
    gbc.gridy = 2; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    //gbc.ipadx = 10; // �������������� �������������� ���������� �� ����� ������ �� �
    //gbc.ipady = 10; // �������������� �������������� ���������� �� ����� ������ �� Y
    //JButtonRed.setForeground(Color.red);
    JButtonRed.addActionListener(this);
    jfrm.add(JButtonRed, gbc);  

    JButtonOrange = new JButton("���������");
    gbc.anchor = GridBagConstraints.SOUTH; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.HORIZONTAL; // ��������� �������� ��������. GridBagConstraints.NONE
    gbc.gridwidth = 1; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 1; // ��������� � ����� �� ��� �
    gbc.gridy = 2; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    //JButtonOrange.setForeground(Color.orange);
    JButtonOrange.addActionListener(this);
    jfrm.add(JButtonOrange, gbc);

    JButtonYellow = new JButton("������");
    gbc.anchor = GridBagConstraints.SOUTH; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.HORIZONTAL; // ��������� �������� ��������. GridBagConstraints.NONE
    gbc.gridwidth = 1; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 2; // ��������� � ����� �� ��� �
    gbc.gridy = 2; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    //JButtonYellow.setForeground(Color.yellow);
    JButtonYellow.addActionListener(this);
    jfrm.add(JButtonYellow, gbc);

    JButtonGreen = new JButton("�������");
    gbc.anchor = GridBagConstraints.SOUTH; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.HORIZONTAL; // ��������� �������� ��������. GridBagConstraints.NONE
    gbc.gridwidth = 1; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 3; // ��������� � ����� �� ��� �
    gbc.gridy = 2; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    //JButtonGreen.setForeground(Color.green);
    JButtonGreen.addActionListener(this);
    jfrm.add(JButtonGreen, gbc);

    JButtonBlue = new JButton("�����");
    gbc.anchor = GridBagConstraints.SOUTH; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.HORIZONTAL; // ��������� �������� ��������. GridBagConstraints.NONE
    gbc.gridwidth = 1; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 4; // ��������� � ����� �� ��� �
    gbc.gridy = 2; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    //JButtonBlue.setForeground(Color.blue);
    JButtonBlue.addActionListener(this);
    jfrm.add(JButtonBlue, gbc);

    JButtonCyan = new JButton("�������");
    gbc.anchor = GridBagConstraints.SOUTH; // ��������������� ������ ������. GridBagConstraints.CENTER
    gbc.fill = GridBagConstraints.HORIZONTAL; // ��������� �������� ��������. GridBagConstraints.NONE
    gbc.gridwidth = 1; // ������ �������� � �������.
    gbc.gridheight = 1; // ������ �������� � �������.
    gbc.gridx = 5; // ��������� � ����� �� ��� �
    gbc.gridy = 2; // ��������� � ����� �� ��� Y
    gbc.weightx = 0.1; // �������������� ���������� �� ����� ���������� �� �
    gbc.weighty = 0.1; // �������������� ���������� �� ����� ���������� �� Y
    //JButtonCyan.setForeground(Color.cyan);
    JButtonCyan.addActionListener(this);
    jfrm.add(JButtonCyan, gbc);

	JButtonRed.setEnabled(false);
	JButtonOrange.setEnabled(false);
	JButtonYellow.setEnabled(false);
	JButtonGreen.setEnabled(false);
	JButtonBlue.setEnabled(false);
	JButtonCyan.setEnabled(false);

	
    // Give the frame an initial size. 
    jfrm.setSize(800, 300); 
 
    // Terminate the program when the user closes the application. 
    jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 
    // Add the label to the content pane. 
    //jfrm.add(jlab);
	AT1 = new AverageTime();
	AT2 = new AverageTime();
    // Display the frame. 
    jfrm.setVisible(true); 
  } 
 
  public static void main(String args[]) { 
    // Create the frame on the event dispatching thread. 
    SwingUtilities.invokeLater(new Runnable() { 
      public void run() { 
        new BraineGame(); 
      } 
    }); 
  }

  public void actionPerformed(ActionEvent ae) { 
    String a = "";
    a = ae.getActionCommand();
	
	//JButtonStart.setEnabled(false);
	//JButtonRed.setEnabled(false);
	//JButtonOrange.setEnabled(false);
	//JButtonYellow.setEnabled(false);
	//JButtonGreen.setEnabled(false);
	//JButtonBlue.setEnabled(false);
	//JButtonCyan.setEnabled(false);
	
		if (a.equals("START")) {
		   // Starting timing. 
			beginT = System.nanoTime();
			rnd = r.nextInt(6);
			rnb = r.nextBoolean();
			if (!rnb) { rnc = r.nextInt(6);} else {rnc = rnd;}
				switch (rnd) {
					case 0:
						if (rnb) {jlab.setForeground(Color.red);}
						jlab.setText("�������");
						break;
					case 1:
						if (rnb) {jlab.setForeground(Color.orange);}
						jlab.setText("���������");
						break;
					case 2:
						if (rnb) {jlab.setForeground(Color.yellow);}
						jlab.setText("������");
						break;
					case 3:
						if (rnb) {jlab.setForeground(Color.green);}
						jlab.setText("�������");
						break;
					case 4:
						if (rnb) {jlab.setForeground(Color.blue);}
						jlab.setText("�����");
						break;
					case 5:
						if (rnb) {jlab.setForeground(Color.cyan);}
						jlab.setText("�������");
						break;
					default:
					jlab.setForeground(Color.gray);		
				} // switch (rnd)
						if (!rnb) { 
							switch (rnc) {
							case 0:
								jlab.setForeground(Color.red);
								//jlab.setText("�������");
								break;
							case 1:
								jlab.setForeground(Color.orange);
								//jlab.setText("���������");
								break;
							case 2:
								jlab.setForeground(Color.yellow);
								//jlab.setText("������");
								break;
							case 3:
								jlab.setForeground(Color.green);
								//jlab.setText("�������");
								break;
							case 4:
								jlab.setForeground(Color.blue);
								//jlab.setText("�����");
								break;
							case 5:
								jlab.setForeground(Color.cyan);
								//jlab.setText("�������");
								break;
							default:
								jlab.setForeground(Color.gray);		
							} // switch (rnc)
						}
			SetButton(true);
			JButtonStart.setEnabled(false);
			//JButtonRed.setEnabled(true);
			//JButtonOrange.setEnabled(true);
			//JButtonYellow.setEnabled(true);
			//JButtonGreen.setEnabled(true);
			//JButtonBlue.setEnabled(true);
			//JButtonCyan.setEnabled(true);
					
			//jlabb.setText("Random: " + Integer.toString(rnd) + " Color: " + Integer.toString(rnc) + "Bool: " + Boolean.toString(rnb));
		} else {
			endT = System.nanoTime();// End timing. 
			switch (rnc) {
				case 0:
					if (a.equals("�������")) {
					SetLabel();
					SetButton(false);
					JButtonStart.setEnabled(true);
					//JButtonRed.setEnabled(false);
					//JButtonOrange.setEnabled(false);
					//JButtonYellow.setEnabled(false);
					//JButtonGreen.setEnabled(false);
					//JButtonBlue.setEnabled(false);
					//JButtonCyan.setEnabled(false);
					}
					else {
						SetButton(false);
						JButtonRed.setEnabled(true);
						//JButtonOrange.setEnabled(false);
						//JButtonYellow.setEnabled(false);
						//JButtonGreen.setEnabled(false);
						//JButtonBlue.setEnabled(false);
						//JButtonCyan.setEnabled(false);
					}
					break;
				case 1:
					if (a.equals("���������")) {
					SetLabel();
					SetButton(false);
					JButtonStart.setEnabled(true);
					//JButtonRed.setEnabled(false);
					//JButtonOrange.setEnabled(false);
					//JButtonYellow.setEnabled(false);
					//.setEnabled(false);
					//JButtonBlue.setEnabled(false);
					//JButtonCyan.setEnabled(false);
					}
					else {
						SetButton(false);
						//JButtonRed.setEnabled(false);
						JButtonOrange.setEnabled(true);
						//JButtonYellow.setEnabled(false);
						//JButtonGreen.setEnabled(false);
						//JButtonBlue.setEnabled(false);
						//JButtonCyan.setEnabled(false);
					}
					break;
				case 2:
					if (a.equals("������")) {
					SetLabel();
					SetButton(false);
					JButtonStart.setEnabled(true);
					//JButtonRed.setEnabled(false);
					//JButtonOrange.setEnabled(false);
					//JButtonYellow.setEnabled(false);
					//JButtonGreen.setEnabled(false);
					//JButtonBlue.setEnabled(false);
					//JButtonCyan.setEnabled(false);
					}
					else {
						SetButton(false);
						//JButtonRed.setEnabled(false);
						//JButtonOrange.setEnabled(false);
						JButtonYellow.setEnabled(true);
						//JButtonGreen.setEnabled(false);
						//JButtonBlue.setEnabled(false);
						//JButtonCyan.setEnabled(false);
					}
					break;
				case 3:
					if (a.equals("�������")) {
					SetLabel();
					SetButton(false);
					JButtonStart.setEnabled(true);
					//JButtonRed.setEnabled(false);
					//JButtonOrange.setEnabled(false);
					//JButtonYellow.setEnabled(false);
					//JButtonGreen.setEnabled(false);
					//JButtonBlue.setEnabled(false);
					//JButtonCyan.setEnabled(false);
					}
					else {
						SetButton(false);
						//JButtonRed.setEnabled(false);
						//JButtonOrange.setEnabled(false);
						//JButtonYellow.setEnabled(false);
						JButtonGreen.setEnabled(true);
						//JButtonBlue.setEnabled(false);
						//JButtonCyan.setEnabled(false);
					}
					break;
				case 4:
					if (a.equals("�����")) {
					SetLabel();
					SetButton(false);
					JButtonStart.setEnabled(true);
					//JButtonRed.setEnabled(false);
					//JButtonOrange.setEnabled(false);
					//JButtonYellow.setEnabled(false);
					//JButtonGreen.setEnabled(false);
					//JButtonBlue.setEnabled(false);
					//JButtonCyan.setEnabled(false);
					}
					else {
						SetButton(false);
						//JButtonRed.setEnabled(false);
						//JButtonOrange.setEnabled(false);
						//JButtonYellow.setEnabled(false);
						//JButtonGreen.setEnabled(false);
						JButtonBlue.setEnabled(true);
						//JButtonCyan.setEnabled(false);
					}					
					break;
				case 5:
					if (a.equals("�������")) {
					SetLabel();
					SetButton(false);
					JButtonStart.setEnabled(true);
					//JButtonRed.setEnabled(false);
					//JButtonOrange.setEnabled(false);
					//JButtonYellow.setEnabled(false);
					//JButtonGreen.setEnabled(false);
					//JButtonBlue.setEnabled(false);
					//JButtonCyan.setEnabled(false);
					}
					else {
						SetButton(false);
						//JButtonRed.setEnabled(false);
						//JButtonOrange.setEnabled(false);
						//JButtonYellow.setEnabled(false);
						//JButtonGreen.setEnabled(false);
						//JButtonBlue.setEnabled(false);
						JButtonCyan.setEnabled(true);
					}										
					break;
				default:
					jlaba.setText("You selected " + ae.getActionCommand());
					JButtonStart.setEnabled(true);
					//jlabb.setText("ELSE - Random: " + Integer.toString(rnd) + " Color: " + Integer.toString(rnc) + "Bool: " + Boolean.toString(rnb));
			}	 // switch (rnd)
		} // else if (a.equals("START")) 
   } // actionPerformed
   
   private void SetLabel() {
   					if (rnb) {
					AT1.Add((endT - beginT)/1000000);
					jlaba.setText("�����: " + Long.toString(AT1.calculateAverage()) + " ms");
					} else {
					AT2.Add((endT - beginT)/1000000);
					jlabb.setText("����: " + Long.toString(AT2.calculateAverage()) + " ms");
					}
   }
 
	private void SetButton(boolean Enabled) {
		JButtonStart.setEnabled(Enabled);
		JButtonRed.setEnabled(Enabled);
		JButtonOrange.setEnabled(Enabled);
		JButtonYellow.setEnabled(Enabled);
		JButtonGreen.setEnabled(Enabled);
		JButtonBlue.setEnabled(Enabled);
		JButtonCyan.setEnabled(Enabled);
	}
   
} // BraineGame