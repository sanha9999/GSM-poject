package classical_rhythm_game1;

import javax.swing.JFrame;

public class ClassicalRhythmGame extends JFrame{
	
	public ClassicalRhythmGame() {
		setTitle("Classical Rhythm Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); //사용자가 화면 크기를 조절할 수 없음
		setLocationRelativeTo(null); //화면이 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 종료 했을 때 프로그램 종료
		setVisible(true); // 컴퓨터에 정상적으로 출력되도록 함, 기본값이 false이므로 true로 지정해야함
	}

}
