package classical_rhythm_game1;

import javax.swing.JFrame;

public class ClassicalRhythmGame extends JFrame{
	
	public ClassicalRhythmGame() {
		setTitle("Classical Rhythm Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); //����ڰ� ȭ�� ũ�⸦ ������ �� ����
		setLocationRelativeTo(null); //ȭ���� ���߾ӿ� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����â�� ���� ���� �� ���α׷� ����
		setVisible(true); // ��ǻ�Ϳ� ���������� ��µǵ��� ��, �⺻���� false�̹Ƿ� true�� �����ؾ���
	}

}
