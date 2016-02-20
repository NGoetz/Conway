package conway;

public class Game {
	public Game(){
		
	}
	
	
	public void game (Petrischale Petri){
		//gibt n Generationen aus, basierend auf der ersten Generation, welche mit Welt übergeben wird
		int k=1;
		System.out.print("Generation 1");
		Petri.besetze(Petri.welt, Petri.dichte);
		Petri.gebeAus(Petri.getWelt());
		while (k<=Petri.maxgen-1){
			k++;
			boolean [][] welt_neu = new boolean [Petri.welt.length][Petri.welt[0].length];
			int nachbarn;
			for (int i=0; i<Petri.welt.length; i++){
				for (int j=0; j<Petri.welt[0].length; j++){
					//Anwenden von Conway's-Regeln
					nachbarn=Petri.zaehleUmgebung(Petri.welt, i,j);
					if (Petri.welt [i] [j]){
						if((nachbarn<2) || (nachbarn>3))
							welt_neu [i][j]=false;
						else if((nachbarn==2)||(nachbarn==3))
							welt_neu [i][j]=true;
					}
					else {
						if (nachbarn==3)
							welt_neu [i][j]=true;
					}
				}
			}
			System.out.print("Generation"+k);
			Petri.gebeAus(welt_neu);
			Petri.setWelt(welt_neu);
			
		}

	}
}
