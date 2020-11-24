package classical_rhythm_game4;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClassicalRhythmGame extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private Image intro_background = new ImageIcon(Main.class.getResource("../images/intro_background(intro).jpg"))
			.getImage();
	// �̹��������� ���� �� intro_background���� �ʱ�ȭ �����ִ� ��
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonbasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY;//���콺�� ��ǥ
	
	public ClassicalRhythmGame() {
		setUndecorated(true); // �޴��ٰ� ������ ����
		setTitle("Classical Rhythm Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // ����ڰ� ȭ�� ũ�⸦ ������ �� ����
		setLocationRelativeTo(null); // ȭ���� ���߾ӿ� ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ����â�� ���� ���� �� ���α׷� ����
		setVisible(true); // ��ǻ�Ϳ� ���������� ��µǵ��� ��, �⺻���� false�̹Ƿ� true�� �����ؾ���
		setBackground(new Color(0, 0, 0, 0));// ȭ���� �Ͼ��
		setLayout(null);
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);//�⺻���� ���ø� �����
		exitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);//���콺�� �ö��� �� �̹����� �ٲٴ� ��
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
			
			
			
		});
		
		add(exitButton);

		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
			
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);//����â�� ��ġ�� �ٲ��ִ� ��
			}
			
		});
		add(menuBar);// �޴��� ���̱�

		
		
		
		

		Music introMusic = new Music("introMusic.mp3", true);// true������ ������ ��� �ݺ���
		introMusic.start();
	}

	public void paint(Graphics g) {// ���� ù��°�� ȭ���� �׷��ִ� �޼���
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// �� �Լ��� �̿��Ͽ� �׸�
		g.drawImage(screenImage, 0, 0, null); // 0,0�� ��ġ�� �׷��ִ� �� ����â�� �̹����� �׷����� ��

	}

	public void screenDraw(Graphics g) {
		g.drawImage(intro_background, 0, 0, null);
		paintComponents(g); // �̹����� �ܼ��ϰ� �׷��ִ� �� �̿ܿ� ���� �޴��� ����j���� �߰��� �ִ°�. �޴��ٴ� �׻� �����ϹǷ� �ϳ��� ��ư���� �����ϱ����� �̰�
							// ��
		this.repaint(); // �ٽ� ����Ʈ �Լ��� �ҷ���, ���� �ڹٰ� ���۸��� ���� �ɷ��� ���� ���۸��� ���
	}
}
