package inf101.v18.cell;

import inf101.v18.cell.gui.CellAutomataGUI;

public class Main {

	public static void main(String[] args) {

		ICellAutomaton ca = new BriansBrain(100,100);
		//Når du er klar til å teste ut BriansBrain
		//kan du bytte linjen over med det følgende:
		//ICellAutomaton ca = new BriansBrain(100,100);
		
		CellAutomataGUI.run(ca);
	}

}
