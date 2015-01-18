import java.awt.*;

public class Segment {
	private Puzzle gameInstance;
	private int ID;
	private int segmentSize;
	private Point pos;

	public boolean isEmpty = false;

	public Segment(Puzzle instance, int ID, int segmentSize) {
		this.gameInstance = instance;
		this.ID = ID;
		this.segmentSize = segmentSize;
		pos = new Point(((ID <= 2)? ID:(ID <= 5)? (ID-3):(ID-6)), (int) Math.ceil((ID/3)));
	}
	
	public boolean hitten(Point p) {
		return new Rectangle(pos.x*segmentSize, pos.y*segmentSize, segmentSize, segmentSize).contains(p);
	}
	
	public boolean move(Point p) {
		boolean isPossible = false;
		if (p.x == pos.x+1 && p.y == pos.y) isPossible = true;
		if (p.x == pos.x-1 && p.y == pos.y) isPossible = true;
		if (p.x == pos.x && p.y == pos.y+1) isPossible = true;
		if (p.x == pos.x && p.y == pos.y-1) isPossible = true;
		
		if (isPossible) {
			pos = p;
		}
		
		return isPossible;
	}

	public void paint(Graphics g) {
		if (!isEmpty) {
			int x = ((ID <= 2)? ID:
				(ID <= 5)? (ID-3):(ID-6));
			int y = (int) Math.ceil((ID/3));
			g.drawImage(gameInstance.img, pos.x*segmentSize, pos.y*segmentSize, (pos.x+1)*segmentSize, (pos.y+1)*segmentSize, x*segmentSize, y*segmentSize, (x+1)*segmentSize, (y+1)*segmentSize, null);
			g.setColor(new Color(0,0,0));
			g.drawLine(pos.x*segmentSize+(segmentSize-1), pos.y*segmentSize, pos.x*segmentSize+(segmentSize-1), (pos.y+1)*segmentSize);
			g.drawLine(pos.x*segmentSize, pos.y*segmentSize+(segmentSize-1), (pos.x+1)*segmentSize, pos.y*segmentSize+(segmentSize-1));
			g.setColor(new Color(150,150,150, 100));
			g.drawLine(pos.x*segmentSize, pos.y*segmentSize, pos.x*segmentSize, (pos.y+1)*segmentSize);
			g.drawLine(pos.x*segmentSize, pos.y*segmentSize, (pos.x+1)*segmentSize, pos.y*segmentSize);
		}
	}

	public Point getPosition() {
		return this.pos;
	}
	
	public void setPosition(Point p) {
		this.pos = p;
	}

	public int getID() {
		return ID;
	}
}
