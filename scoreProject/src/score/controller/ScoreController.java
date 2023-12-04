package score.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import score.view.ScoreView;
import score.vo.ScoreDAO;
import score.vo.ScoreVO;


@SuppressWarnings("serial")
public class ScoreController extends JFrame{
	ScoreDAO dao;
	ArrayList<ScoreVO> scoreVOList;
	ScoreView view;
	JTable table;
	
	public ScoreController() {
		scoreVOList = new ArrayList<ScoreVO>();
		dao = new ScoreDAO();
		view = new ScoreView();
		view.setScoreVOList(scoreVOList);
		view.initView();
		JButton btnAdd = view.getBtnAdd();
		btnAdd.addActionListener(btnAddL);
		table = view.getTable();
		table.addMouseListener(tableL);
		add(view, "Center");
		setTitle("성적관리시스템");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(500,200);
		setSize(600,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ScoreController();

	}
	
	ActionListener btnAddL = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			ScoreVO vo = view.neededInsertData();
			dao.insert(vo);
			scoreVOList = dao.select();
			view.setScoreVOList(scoreVOList);
			view.putResult();
			view.initInsertData();
		}
	};
	
	
	MouseAdapter tableL = new MouseAdapter() {
		int state = 1;
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount() == 2 ) {
				state = JOptionPane.showConfirmDialog(ScoreController.this,"정말 삭제하시겠습니까?" , "삭제여부", JOptionPane.YES_NO_OPTION);
				if (state == JOptionPane.YES_OPTION) {
					dao.delete(table.getSelectedRow() );
					view.setScoreVOList(scoreVOList);
					view.putResult();
					view.initInsertData();
				}
			}
		};
	};
}
