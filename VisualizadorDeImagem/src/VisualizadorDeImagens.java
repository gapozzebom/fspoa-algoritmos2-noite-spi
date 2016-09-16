import java.io.IOException;

import com.senac.SimpleJava.Console;
import com.senac.SimpleJava.Graphics.Canvas;
import com.senac.SimpleJava.Graphics.GraphicApplication;
import com.senac.SimpleJava.Graphics.Image;
import com.senac.SimpleJava.Graphics.Resolution;

public class VisualizadorDeImagens
	extends GraphicApplication {

	private Image image;

	@Override
	protected void draw(Canvas canvas) {
		canvas.drawImage(image, 0, 0);
	}

	@Override
	protected void setup() {
		setResolution(Resolution.HIGHRES);
		try {
			image = new Image("images/teste.png");
		} catch (IOException e) {
			e.printStackTrace(System.err);
		}
	}

	@Override
	protected void loop() {
		try {
			throw new Exception("Eu sou uma excecao!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
