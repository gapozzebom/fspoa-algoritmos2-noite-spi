package game;


import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.Color;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Point;
import com.senac.SimpleJava.Graphics.Resolution;
import com.senac.SimpleJava.Graphics.Sprite;
import com.senac.SimpleJava.Graphics.events.KeyboardAction;

public class Arkanoid extends GraphicApplication {

	private Bola bola;
	private Sprite quadrado, paddel;
	private boolean desenhaQuadrado = true; 
	
	@Override
	protected void draw(Canvas canvas) {		
		canvas.clear();
		
		bola.draw(canvas);
		
		if(desenhaQuadrado ){
			quadrado.draw(canvas);
		}
		paddel.draw(canvas);
	}

	@Override
	protected void setup() {
		this.setTitle("Arkanoid");
		this.setResolution(Resolution.MSX);
		this.setFramesPerSecond(60);
		
		bola = new Bola();
		bola.setPosition(150, 150);
		
		quadrado = new Sprite(18, 10, Color.BLUE);
		quadrado.setPosition(50, 50);
		
		paddel = new Sprite(20, 5, Color.RED);
		paddel.setPosition(Resolution.MSX.width/2 - 10, Resolution.MSX.height - 25);
		this.bindKeyPressed("LEFT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddel.move(-3, 0);
			}
		});
		
		this.bindKeyPressed("RIGHT", new KeyboardAction() {
			@Override
			public void handleEvent() {
				paddel.move(+3, 0);
			}
		});
	}

	@Override
	protected void loop() {
		bola.move();
	
		Point posicao = bola.getPosition();
	
		if(posicao.y <= 0 || posicao.y >= Resolution.MSX.height-5){
			bola.direcaoY();
		}
		if(posicao.x <= 0 || posicao.x >= Resolution.MSX.width-5){
			bola.direcaoX();
		}
		boolean bateu = true;
		Point posicaoQuadrado = quadrado.getPosition();
		// Se qualquer teste for verdadeiro, a bola nao bateu no quadrado.
		if (posicao.x > posicaoQuadrado.x + quadrado.getWidth()) 
		{
			bateu = false; 
		}
		if (posicao.x  + bola.getWidth() < posicaoQuadrado.x) 
		{
			bateu = false;
		}
		if (posicao.y > posicaoQuadrado.y + quadrado.getHeight()) 
		{
			bateu = false;
		}
		if (posicao.y  + bola.getHeight() < posicaoQuadrado.y) 
		{
			bateu = false;
		}
		
		desenhaQuadrado = !bateu;
		
		redraw();
	}
}
