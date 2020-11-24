package classical_rhythm_game3;



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
		setResizable(false); //����ڰ� ȭ�� ũ�⸦ ������ �� ����
		setLocationRelativeTo(null); //ȭ���� ���߾ӿ� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����â�� ���� ���� �� ���α׷� ����
		setVisible(true); // ��ǻ�Ϳ� ���������� ��µǵ��� ��, �⺻���� false�̹Ƿ� true�� �����ؾ���
		
		intro_background = new ImageIcon(Main.class.getResource("../images/intro_background(intro).jpg")).getImage();
		//�̹��������� ���� �� intro_background���� �ʱ�ȭ �����ִ� ��
		
		Music introMusic = new Music("introMusic.mp3", true);//true������ ������ ��� �ݺ���
		introMusic.start();
	}
	
	public void paint(Graphics g) {//���� ù��°�� ȭ���� �׷��ִ� �޼���
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);//�� �Լ��� �̿��Ͽ� �׸�
		g.drawImage(screenImage, 0,0, null); //0,0�� ��ġ�� �׷��ִ� �� ����â�� �̹����� �׷����� ��
		
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(intro_background, 0, 0, null);
		this.repaint(); // �ٽ� ����Ʈ �Լ��� �ҷ���, ���� �ڹٰ� ���۸��� ���� �ɷ��� ���� ���۸��� ���
	}
}
