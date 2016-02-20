package conway;

import java.util.Random;

public class Petrischale {
public boolean [][] welt;
public int gen;
public int maxgen;
double dichte;

public Petrischale(boolean [][] startwelt, int mg, double d) {
    gen  = 1;
    maxgen  = mg;
    welt=startwelt;
    dichte=d;
}
public int getGen() {
    return gen;
}
public void setGen(int g) {
    gen = g;
}

public int getMaxGen() {
    return maxgen;
}
public void setMaxGen(int mg) {
    maxgen = mg;
}


public boolean [][] getWelt(){
	return welt;
}
public void setWelt(boolean[][]w){
	welt=w;
}
public double getDichte(){
	return dichte;
}
public void setDichte(double d){
	dichte=d;
}
public void besetze (boolean [][] welt,double dichte) {
	//besetzt Array zufällig in beliebiger Dichte
	Random Generator = new Random ();
	double zufallswert;
	for (int i=0; i<welt.length; i++){
		for (int j=0; j<welt[0].length; j++){
			zufallswert=Generator.nextDouble();
			if (zufallswert <= dichte)
				welt [i] [j]=true;
		}
	}
}
public void gebeAus (boolean [][]m){
	//einfache Ausgabefunktion
	System.out.println();
	for( int i=0; i<m.length; i++){
		for(int j=0; j<m [0].length;j++){
			if(m[i][j])System.out.print("X ");
			else System.out.print("  ");
		}
		System.out.println();
	}
}
public int zaehleUmgebung (boolean [][] m, int x, int y){
	//zählt die Zellen in der Umgebung eines Arraypunktes
	//setzt Zellen außerhalb des Arrays auf tot. Der nötige Indexshift um innerhalb 
	//der Bounds zu bleiben wird über die Hilfsvariablen s,t,r,q,l und k übernommen
	int ret = 0;
	int s=(x-1);
	int t=(y-1);
	int r, q,l,k;
	if (s+3 > m.length)
		r=m.length;
	else 
		 r=s+3;
	if (s==-1)
		l=0;
	else
		l=x-1;
		
	if (t+3> m[0].length)
		q=m[0].length;
	else
		q=t+3;
	if (t==-1)
		k=0;
	else
		k=y-1;
	
	for ( int i=l; i<r; ++i){
		for (int j=k; j<q;++j){
				if (m[i][j])
					ret +=1;
		}
		}
	if (m[x] [y])//die Zelle selbst darf nicht mitgezählt werden!
		ret-=1;
	return ret;
	
}
}
