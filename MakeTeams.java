import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;
/* The controller file. Takes care of all the logic.
 *  @author: Azmain Amin
 */
public class MakeTeams {
	static String[] list;
	
	public MakeTeams(){
	}
	
	public static ArrayList<String> makeList(){
		String inputNames = Frame.inputNames.getText();
		list = inputNames.split(",");
		ArrayList<String> aList = new ArrayList<String>();
		for(String name: list){
			aList.add(name);
		}
		Collections.shuffle(aList);
		if(aList.size() != 8 && aList.size() != 6){
			JOptionPane.showMessageDialog(Frame.f, "Invalid number of debaters.");
		}
		return aList;
	
	}
	
	public static void template(ArrayList<String> aList){
		StringBuilder showTeams = new StringBuilder("Team Setup: \n\n");
		if(Frame.rb_wudc.isSelected()){
			showTeams.append("Opening Gov: " + aList.get(0)+ ", " + aList.get(1) + "\n");
			showTeams.append("Opening Opp: " + aList.get(2)+ ", " + aList.get(3)+ "\n");
			showTeams.append("Closing Gov: " + aList.get(4)+ ", " + aList.get(5)+ "\n");
			showTeams.append("Closing Gov: " + aList.get(6)+ ", " + aList.get(7)+ "\n");
		}
		if(Frame.rb_wsdc.isSelected()){
			showTeams.append("Government: " + aList.get(0)+ ", " + aList.get(1) + ", " + aList.get(2)+ "\n\n");
			showTeams.append("Opposition: " + aList.get(3)+ ", " + aList.get(4)+ ", " + aList.get(5)+ "\n");
		
		}
		Frame.showTeams.setText(showTeams.toString());
		if (! Frame.rb_wudc.isSelected() && ! Frame.rb_wsdc.isSelected()){
			
			JOptionPane.showMessageDialog(Frame.f, "Please select debate Format.");
		}
	}
	public static void displayTeams(){
		ArrayList<String> aList = makeList();
		template(aList);
	}

}
