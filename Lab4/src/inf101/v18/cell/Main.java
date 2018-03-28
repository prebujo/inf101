package inf101.v18.cell;

import inf101.v18.cell.gui.CellAutomataGUI;

public class Main {

	public static void main(String[] args) throws Exception {

		ICellAutomaton ca = new LangtonsAnt(100,100,"LLRRL");
		//Når du er klar til å teste ut BriansBrain
		//kan du bytte linjen over med det følgende:
		//ICellAutomaton ca = new BriansBrain(100,100);
		
		CellAutomataGUI.run(ca);
	}

}
