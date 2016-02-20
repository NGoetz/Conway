package conway;

public class Beispiel {

	public static void main(String[] args) {
		Game g=new Game();
		boolean [][] neuwelt = new boolean [20][40];
		Petrischale Petri = new Petrischale (neuwelt,5,0.3);
		
		g.game(Petri);

	}

}
