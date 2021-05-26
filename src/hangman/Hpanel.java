package hangman;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hpanel extends JFrame {
	GridBagLayout gBag;
	JLabel head;
	JTextField textField;
	JButton btn;
	String origin;
	JPanel panel;
	JLabel correctLabel;
	JLabel inCorrectLabel;
	JLabel remainCntLabel;
	int correctNum;
	int inCorrectNum;
	int remainCnt;
	ArrayList<String> list;
	public Hpanel(ArrayList<String> s) {
		this.list = s;
		this.correctNum = 0;
		this.inCorrectNum = 0;
		this.remainCnt = 5;
		
		
		setTitle("Hangman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JPanel header = new JPanel();
		head = new JLabel("HangMan");
		header.add(head);
		header.setBackground(new Color(0xff, 0x98, 0));
		
		panel = new JPanel();
		BufferedImage objectImage;
		try {
			objectImage = ImageIO.read(new File("./resource/hang1.jpg"));
			ImageLabel img = new ImageLabel();
			img.setIcon(new ImageIcon(objectImage));
				Hpanel.this.panel.add(img);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel side = new JPanel();
		side.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));

		gBag = new GridBagLayout();
		side.setBackground(Color.white);
		side.setSize(300, 100);
		side.setLayout(gBag);
		JLabel correctPro = new JLabel("맞은 문제");
		correctPro.setHorizontalAlignment(JLabel.CENTER);
		Border border = BorderFactory.createLineBorder(Color.white, 5);
		correctPro.setBorder(border);
		gbinsert(correctPro, 0, 1, 1, 1);
		side.add(correctPro);
		correctLabel = new JLabel(String.valueOf(this.correctNum));
		correctLabel.setHorizontalAlignment(JLabel.CENTER);
		correctLabel.setSize(100, 50);
		gbinsert(correctLabel, 0, 2, 1, 1);
		side.add(correctLabel);
		
		JLabel inCorrect = new JLabel("틀린 문제");
		inCorrect.setHorizontalAlignment(JLabel.CENTER);
		gbinsert(inCorrect, 0, 3, 1, 1);
		side.add(inCorrect);
		inCorrect.setBorder(border);
		inCorrectLabel = new JLabel(String.valueOf(this.inCorrectNum));
		inCorrectLabel.setHorizontalAlignment(JLabel.CENTER);
		inCorrectLabel.setSize(100, 50);
		gbinsert(inCorrectLabel, 0, 4, 1, 1);
		side.add(inCorrectLabel);
		
		JLabel remainCnt = new JLabel("남은 기회");
		remainCnt.setHorizontalAlignment(JLabel.CENTER);
		gbinsert(remainCnt, 0, 5, 1, 1);
		side.add(remainCnt);
		remainCnt.setBorder(border);
		remainCntLabel = new JLabel(String.valueOf(this.remainCnt));
		remainCntLabel.setHorizontalAlignment(JLabel.CENTER);
		remainCntLabel.setSize(100, 50);
		gbinsert(remainCntLabel, 0, 6, 1, 1);
		side.add(remainCntLabel);
		
		
		JPanel text = new JPanel();
		gBag = new GridBagLayout();
		text.setBorder(BorderFactory.createEmptyBorder(10 , 10 , 10 , 10));
		text.setLayout(gBag);
		text.setBackground(new Color(255, 224, 178, 100));
		text.setSize(500, 200);
		JLabel ans = new JLabel("정답 : ");
		ans.setHorizontalAlignment(JLabel.RIGHT);
		ans.setForeground(new Color(0, 31, 77, 200));
		gbinsert(ans, 0, 1, 1, 1);
		text.add(ans);
		textField = new JTextField("", 10);
		Border txtBorder = BorderFactory.createLineBorder(new Color(255, 224, 178, 100), 1);
		textField.setBorder(txtBorder);
		gbinsert(textField, 2, 1, 1, 1);
		text.add(textField);
		btn = new JButton("입력");
		gbinsert(btn, 3, 1, 1, 1);
		btn.setBackground(new Color(0xff, 0xb7, 0x4d, 200));
		Border btnBorder = BorderFactory.createLineBorder(new Color(255, 224, 178, 100), 1);
		btn.setBorder(btnBorder);
		// action
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Hpanel.this.origin.equals(textField.getText())) {
 					Hpanel.this.panel.removeAll();
 					Hpanel.this.panel.removeAll();
 					BufferedImage objectImage;
					try {
						objectImage = ImageIO.read(new File("./resource/hang1.jpg"));
						ImageLabel img = new ImageLabel();
						img.setIcon(new ImageIcon(objectImage));
	 					Hpanel.this.panel.add(img);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					Hpanel.this.correctNum++;
					Hpanel.this.remainCnt = 5;
					Hpanel.this.remainCntLabel.setText(String.valueOf(Hpanel.this.remainCnt));
					Hpanel.this.correctLabel.setText(String.valueOf(Hpanel.this.correctNum));
					setText();
				}else if(Hpanel.this.remainCnt > 1) {
					Hpanel.this.remainCnt--;
					Hpanel.this.remainCntLabel.setText(String.valueOf(Hpanel.this.remainCnt));
					BufferedImage objectImage;
					try {
						String imgName = "";
						switch(Hpanel.this.remainCnt) {
							case 1:{
								imgName = "./resource/hang5.jpg";
								break;
							}
							case 2:{
								imgName = "./resource/hang4.jpg";
								break;
							}
							case 3:{
								imgName = "./resource/hang3.jpg";
								break;
							}
							case 4:{
								imgName = "./resource/hang2.jpg";
								break;
							}
							case 5:{
								imgName = "./resource/hang1.jpg";
								break;
							}
							default: {
								imgName = "";
								break;
							}
						}
						if(imgName.equals("")) {
		 					Hpanel.this.panel.removeAll();
		 					Hpanel.this.panel.add(new JLabel());
						}else {
		 					Hpanel.this.panel.removeAll();
							objectImage = ImageIO.read(new File(imgName));
							ImageLabel img = new ImageLabel();
							img.setIcon(new ImageIcon(objectImage));
		 					Hpanel.this.panel.add(img);
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
 					Hpanel.this.panel.removeAll();
 					BufferedImage objectImage;
					try {
						objectImage = ImageIO.read(new File("./resource/hang1.jpg"));
						ImageLabel img = new ImageLabel();
						img.setIcon(new ImageIcon(objectImage));
	 					Hpanel.this.panel.add(img);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					Hpanel.this.inCorrectNum++;
					Hpanel.this.remainCnt = 5;
					Hpanel.this.remainCntLabel.setText(String.valueOf(Hpanel.this.remainCnt));
					Hpanel.this.inCorrectLabel.setText(String.valueOf(Hpanel.this.inCorrectNum));
					setText();
				}
				checkFin();
				Hpanel.this.textField.setText("");
			}
		});
		text.add(btn);
		
		c.add(header, BorderLayout.NORTH);
		c.add(panel, BorderLayout.CENTER);
		c.add(text, BorderLayout.SOUTH);
		c.add(side, BorderLayout.EAST);
		setSize(500, 500);
		setVisible(true);
		setText();
	}
	
   public void gbinsert(Component c, int x, int y, int w, int h){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gBag.setConstraints(c,gbc);
    }
   
   public void setText() {
		Random random = new Random();
		this.origin = this.list.get(random.nextInt(25143));
		while(this.origin.length() <= 2) {
			this.origin = this.list.get(random.nextInt(25143));
		}
		String hashing = origin;
		for(int i = 0; i < origin.length()/3; i++) {
			int randomTmp = random.nextInt(origin.length()-1);
			hashing = hashing.substring(0,randomTmp)+'-'+hashing.substring(randomTmp+1);
		}
		changeProblem(hashing);
		System.out.println(this.origin);
   }
   
   public void changeProblem(String s){
	   this.head.setText(s);
   }
   
   
   public void checkFin() {
		if(Hpanel.this.correctNum == 10) {
			System.exit(0);
			System.out.println("게임 종료 : 성공");
			
		}else if(Hpanel.this.inCorrectNum == 3) {
			System.exit(0);
			System.out.println("게임 종료 : 실패");
		}
   }

}

