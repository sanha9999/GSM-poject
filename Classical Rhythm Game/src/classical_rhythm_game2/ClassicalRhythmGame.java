package classical_rhythm_game2;



import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ClassicalRhythmGame extends JFrame{
	
	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image intro_background;
	
	
	public ClassicalRhythmGame() {
		setTitle("Classical Rhythm Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); //사용자가 화면 크기를 조절할 수 없음
		setLocationRelativeTo(null); //화면이 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 종료 했을 때 프로그램 종료
		setVisible(true); // 컴퓨터에 정상적으로 출력되도록 함, 기본값이 false이므로 true로 지정해야함
		
		intro_background = new ImageIcon(Main.class.getResource("../images/intro_background(intro).jpg")).getImage();
		//이미지파일을 얻어온 뒤 intro_background에다 초기화 시켜주는 것
	}
	
	public void paint(Graphics g) {//가장 첫번째로 화면을 그려주는 메서드
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);//이 함수를 이용하여 그림
		g.drawImage(screenImage, 0,0, null); //0,0의 위치에 그려주는 것 게임창에 이미지가 그려지는 것
		
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(intro_background, 0, 0, null);
		this.repaint(); // 다시 페인트 함수를 불러옴, 원래 자바가 버퍼링이 많이 걸려서 더블 버퍼링을 사용
	}
}
