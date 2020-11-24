package classical_rhythm_game3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	private Player player;
	private boolean isLoop; // 곡이 무한반복인지 한번만 반복하는지 변수
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop=isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {//음악이 몇 초까지 재생되고 있는지 (0.001초 단위로 알려줌)
		if (player==null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {//플레이어가 게임중 탈주할 때, 곡이 안정적으로 끊어지게 하려고
		isLoop = false;
		player.close();
		this.interrupt();//곡을 종료하는게 인터럽트
	}

	@Override
	public void run() {
		try {
			do {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
				player.play();//곡 실행
			}while(isLoop);//무한반복 재생
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());//오류메세지 발생
		}
	}
	
	
	
}
