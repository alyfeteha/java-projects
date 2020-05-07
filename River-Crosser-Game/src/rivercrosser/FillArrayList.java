package rivercrosser;

import java.util.ArrayList;

public class FillArrayList {
 ArrayList<Crosser> LeftCrossers=new ArrayList<>();
 ArrayList<Crosser> RightCrossers=new ArrayList<>();
 ArrayList<Crosser> onboatCrossers=new ArrayList<>();
 	//Farmer h=new Farmer();
 	 //Carnivore;
 	//Plant p=new Plant();
 public void fillarrayLeft() {

 }
 public void fillArrayRight() {
	
 }
 public void onboat() {
	 
 }
 public int boat() {
	 int x;
	 return x=0;
 }
 public void SaveToArrays(ArrayList<Crosser> OnShore,ArrayList<Crosser> OnBoat,ArrayList<Crosser> Crossed)
 {
     for(Crosser cross:OnBoat)
     {
         onboatCrossers.add(cross);
     }
     for(Crosser cross:Crossed)
     {
        RightCrossers.add(cross);
     }
     
    for(Crosser cross:OnShore)
    {
        LeftCrossers.add(cross);
    }
     
 }
}