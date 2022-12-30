package score.vo;

import java.util.ArrayList;


public class ScoreDAO {
ArrayList <ScoreVO> stuList = new ArrayList <ScoreVO>();
	
	//저장
	public void insert(ScoreVO svo) {
		stuList.add(svo);
	}
	//반환
	public ArrayList<ScoreVO> select() {
		return stuList;
	}
	
	public void delete(int index) {
		stuList.remove(index);
	}

}
