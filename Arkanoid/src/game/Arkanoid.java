package game;


import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.Sprite;

public class Arkanoid extends GraphicApplication {

	private Sprite bola;
	private double dy = -2;
	private int dx = -2;
	private Sprite quadrado;
	private Image bloco; 
	
	@Override
	protected void draw(Canvas canvas) {		
		canvas.clear();
		bola.draw(canvas);
		quadrado.draw(canvas);
		
		bloco.clear(Color.RED);
		canvas.drawImage(bloco, 69, 50);
		bloco.clear(Color.GREEN);
		canvas.drawImage(bloco, 87, 50);
	}

	@Override
	protected void setup() {
		this.setTitle("Arkanoid");
		this.setResolution(Resolution.MSX);
		this.setFramesPerSecond(60);
		
		bola = new Sprite(5, 5, Color.BLACK);
		bola.setPosition(30, 101);
		
		quadrado = new Sprite(18, 10, Color.BLUE);
		quadrado.setPosition(50, 50);
		
		bloco = new Image(18, 10);
		
	}

	@Override
	protected void loop() {
		bola.move(dx, dy );
		Point posicao = bola.getPosition();
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			dy *= -1;
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			dx  *= -1;
		}
		
		redraw();
	}
}
