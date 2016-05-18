import java.awt.Graphics;

public class Cember {
	
	int x=50,y=50;
	int gen=50,yuk=50;
	
	public void EkranCiz(Graphics g){
		g.drawOval(x, y, gen, yuk);
	}

	public Cember(int x, int y, int gen, int yuk) {
		super();
		this.x = x;
		this.y = y;
		this.gen = gen;
		this.yuk = yuk;
	}

}
