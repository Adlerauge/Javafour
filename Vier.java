//Vier.java
//Vier gewinnt
public class Vier {
	final static int Z = 6;
	final static int S = 7;
	static int[][] feld = new int[Z][S];
	static int[] fuellstand = new int[S];
	static boolean spielEnde;
	static int p;//Player
	static int spalte;
	
	static void spielfeldAusgeben() {
		System.out.println("|   |   |   |   |   |   |   |");
        System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 |");
        System.out.println("|___|___|___|___|___|___|___|");

        for ( int i=0; i<Z; i++)
        {
            System.out.println("|   |   |   |   |   |   |   |");
            for ( int j = 0; j < S; j++)
            {

                if (feld[i][j] == 0)
                    System.out.print("|   ");
                else if (feld[i][j] == 1)
                    System.out.print("| X ");
                else System.out.print("| O ");
            } // end of for
            System.out.print("|");
            System.out.println();
            System.out.println("|___|___|___|___|___|___|___|");
        } // end of for
        System.out.println();
	}
	
	static void spielerWechsel()
    {
        // spielerWechsel
        if (p==1)
		p=2;
		else
        p = 1;
    } // end of void spielerWechsel
	
	static void spaltenEingabe() {
        do {
        System.out.print("Spieler "+p+": Spaltennummer angeben: ");
    	spalte = new java.util.Scanner(System.in).nextInt();
    	if(spalte<1||spalte>S)System.out.println("Spaltenzahl nicht im Rahmen!");
    	if(fuellstand[spalte-1]>=Z) System.out.println("Spalte voll!");
		} while (spalte < 1 || spalte > S || fuellstand[spalte-1]>=Z);
	    fuellstand[spalte-1]++;
    }//
	
	static void spielZug()
    {
		feld[6 - fuellstand[spalte-1]][spalte-1] = p;
    }//spielZug
	
	static void gewinnBedingung()
    {
        for(int i=0;i<=2;i++)
              for(int j=0;j<=6;j++)
          {if(feld[i][j]==p && feld[i+1][j]==p && feld[i+2][j]==p && feld[i+3][j]==p)
              {spielEnde=true;}
              }
        for(int i=0;i<=5;i++)
              for(int j=0;j<=3;j++)
              {
		 if(feld[i][j]==p && feld[i][j+1]==p && feld[i][j+2]==p && feld[i][j+3]==p)
              	spielEnde=true;
              }        
             
        for(int i=0;i<=2;i++)
            for(int j=0;j<=3;j++)
			{
		if(feld[i][j]==p && feld[i+1][j+1]==p && feld[i+2][j+2]==p && feld[i+3][j+3]==p)
               		spielEnde=true;
            }
      
        for(int i = 0; i < 3; i++)
           	for(int j = 6; j > 2; j--){
       	if(feld[i][j]==p && feld[i+1][j-1]==p && feld[i+2][j-2]==p && feld[i+3][j-3]==p)
                	 spielEnde=true;
            }                  
    }//
	
	public static void main(String[] args) {
			int janein = 0;
        do
		{
		spielEnde=false;
		p = 2;
		for(int i=0; i<Z; i++)
			for(int j=0; j<S; j++)
				feld[i][j]=0;
		for(int j=0; j<S; j++)
			fuellstand[j]=0;
		System.out.println("         4 GEWINNT");
        spielfeldAusgeben();
		while (spielEnde==false)
        {
            spielerWechsel();
			spaltenEingabe();
            spielZug();
            spielfeldAusgeben();
            gewinnBedingung();
        }
        System.out.println("Spieler "+p+" hat grandios gewonnen!!!!");
        System.out.print("Noch einmal das Ganze (1=ja, 2=nein) ? ");
        janein = new java.util.Scanner(System.in).nextInt();
    } while (janein!=2);
	}//main
}//class


