package notepad;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JToolBar;


@SuppressWarnings("serial")
public class Notepad extends JFrame implements ActionListener{
	JMenuItem itemNew, itemOpen, itemSave, itemExit;
	JMenuItem red, blue, black;
	JMenuItem item10, item15, item20;
	JMenuItem font1, font2, font3;
	JButton newBtn, openBtn, saveBtn;
	
	JTextArea area = new JTextArea();
	
	public Notepad() {
		
		setTitle("메모장");
		makeMenu(); 
		add(area);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200,200,800,600);
		setResizable(false);
		setVisible(true);

	}
	
	ActionListener btnL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object eBtn = e.getSource();
			if (eBtn == newBtn) {
				area.setText("");
			} else if (eBtn == openBtn) {
				readFile();
			} else if (eBtn == saveBtn) {
				writeFile();
			}
		}
	};
	
	public void makeToolBar() {
		JToolBar toolBar = new JToolBar();
		newBtn = new JButton(new ImageIcon("Image/새문서.png"));
		openBtn = new JButton(new ImageIcon("Image/열기.png"));
		saveBtn = new JButton(new ImageIcon("Image/저장.png"));
		newBtn.addActionListener(btnL);
		openBtn.addActionListener(btnL);
		saveBtn.addActionListener(btnL);
		toolBar.add(newBtn);
		toolBar.add(openBtn);
		toolBar.add(saveBtn);
		add(toolBar, "North");
		
	}
	
	public void makeMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menuFile = new JMenu("File");
		itemNew = new JMenuItem("New");
		itemOpen = new JMenuItem("Open");
		itemSave = new JMenuItem("Save");
		itemExit = new JMenuItem("Exit");
		
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);
		
		JMenu format = new JMenu("Format");
		JMenu fontSize = new JMenu("FontSize");
		item10 = new JMenuItem("10px");
		item15 = new JMenuItem("15px");
		item20 = new JMenuItem("20px");
		item10.addActionListener(this);
		item15.addActionListener(this);
		item20.addActionListener(this);
		
		JMenu fontAppearance = new JMenu("Font");
		font1 = new JMenuItem("궁서체");
		font2 = new JMenuItem("맑은 고딕");
		font3 = new JMenuItem("신명조");
		font1.addActionListener(this);
		font2.addActionListener(this);
		font3.addActionListener(this);
		
		JMenu fontColor = new JMenu("FontColor");
		red = new JMenuItem("Red");
		blue = new JMenuItem("Blue");
		black = new JMenuItem("Black");
		red.addActionListener(this);
		blue.addActionListener(this);
		black.addActionListener(this);
		
		fontAppearance.add(font1);
		fontAppearance.add(font2);
		fontAppearance.add(font3);
		
		fontColor.add(red);
		fontColor.add(blue);
		fontColor.add(black);
		
		fontSize.add(item10);
		fontSize.add(item15);
		fontSize.add(item20);
		
		menuFile.add(itemNew);
		menuFile.add(itemOpen);
		menuFile.add(itemSave);
		menuFile.add(itemExit);
		format.add(fontAppearance);
		format.add(fontSize);
		format.add(fontColor);
		
		
		menuBar.add(menuFile);
		menuBar.add(format);
		setJMenuBar(menuBar);
		makeToolBar();
	}

	public static void main(String[] args) {
		new Notepad();

	}
	public void readFile() {
		area.setText("");
		FileDialog fileDlg = null;
		fileDlg = new FileDialog(this, "File Open", FileDialog.LOAD);
		fileDlg.setVisible(true);
		FileReader fReader = null;
		BufferedReader bufReader = null;
		try {
			fReader = new FileReader(new File(fileDlg.getDirectory() + "/" + fileDlg.getFile()));
			bufReader = new BufferedReader(fReader);
			String line = "";
			while ((line=bufReader.readLine()) != null) {
				area.append(line+"\n");
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeFile() {
		FileDialog fileDlg = null;
		fileDlg = new FileDialog(this, "File Save", FileDialog.SAVE);
		fileDlg.setVisible(true);
		FileWriter fWriter = null;
		BufferedWriter bufWriter = null;
		try {
			fWriter = new FileWriter(new File(fileDlg.getDirectory() + "/" + fileDlg.getFile()));
			bufWriter = new BufferedWriter(fWriter);
			bufWriter.write(area.getText());
			bufWriter.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem eitem = (JMenuItem)e.getSource();
		if(eitem == itemNew) {
			area.setText("");
		} else if (eitem == itemOpen) {
			readFile();
		} else if (eitem == itemSave) {
			writeFile();
		} else if (eitem == itemExit) {
			System.exit(0);
		} else if (eitem == font1 ) {
			area.setFont(new Font("궁서체", Font.PLAIN, area.getFont().getSize()));
		} else if (eitem == font2 ) {
			area.setFont(new Font("맑은 고딕", Font.PLAIN, area.getFont().getSize()));
		} else if (eitem == font3 ) {
			area.setFont(new Font("신명조", Font.PLAIN, area.getFont().getSize()));
		} else if (eitem == red) {
			area.setForeground(Color.red);
		} else if (eitem == blue) {
			area.setForeground(Color.blue);
		} else if (eitem == black) {
			area.setForeground(Color.BLACK);
		} else if (eitem == item10) {
			area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 10));
		} else if (eitem == item15) {
			area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 15));
		} else if (eitem == item20) {
			area.setFont(new Font(area.getFont().getFamily(), Font.PLAIN, 20));
		}
	}
}
