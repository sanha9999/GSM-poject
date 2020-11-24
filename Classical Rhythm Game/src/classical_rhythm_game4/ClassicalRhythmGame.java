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
	// 이미지파일을 얻어온 뒤 intro_background에다 초기화 시켜주는 것
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonbasic.png"));
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY;//마우스의 좌표
	
	public ClassicalRhythmGame() {
		setUndecorated(true); // 메뉴바가 보이지 않음
		setTitle("Classical Rhythm Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 사용자가 화면 크기를 조절할 수 없음
		setLocationRelativeTo(null); // 화면이 정중앙에 뜸
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임창을 종료 했을 때 프로그램 종료
		setVisible(true); // 컴퓨터에 정상적으로 출력되도록 함, 기본값이 false이므로 true로 지정해야함
		setBackground(new Color(0, 0, 0, 0));// 화면이 하얀색
		setLayout(null);
		
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);//기본적인 팸플릿 지우기
		exitButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);//마우스가 올라갔을 때 이미지를 바꾸는 것
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
				setLocation(x - mouseX, y - mouseY);//게임창의 위치를 바꿔주는 것
			}
			
		});
		add(menuBar);// 메뉴바 보이기

		
		
		
		

		Music introMusic = new Music("introMusic.mp3", true);// true값으로 음악이 계속 반복됨
		introMusic.start();
	}

	public void paint(Graphics g) {// 가장 첫번째로 화면을 그려주는 메서드
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);// 이 함수를 이용하여 그림
		g.drawImage(screenImage, 0, 0, null); // 0,0의 위치에 그려주는 것 게임창에 이미지가 그려지는 것

	}

	public void screenDraw(Graphics g) {
		g.drawImage(intro_background, 0, 0, null);
		paintComponents(g); // 이미지를 단순하게 그려주는 것 이외에 따로 메뉴바 같은j라벨을 추가해 주는것. 메뉴바는 항상 존재하므로 하나의 버튼으로 고정하기위해 이걸
							// 씀
		this.repaint(); // 다시 페인트 함수를 불러옴, 원래 자바가 버퍼링이 많이 걸려서 더블 버퍼링을 사용
	}
}
