/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tactician
 */
//import java.awt.Color;
//import objectdraw.*;
//public abstract class PropertyCard extends ActiveObject {
//      
//    public abstract void updatePropertyColor(Color o);    
//    public abstract int getValue();
//    public abstract FramedRect getCardLocation();
//    public abstract String getPropertyName();
//    
//    
//}

import java.awt.Color;
import objectdraw.*;
public abstract class PropertyCard {
      
    public abstract void updatePropertyColor(Color o);    
    public abstract int getValue();
    public abstract FramedRect getCardLocation();
    public abstract String getPropertyName();
	
    public abstract FilledRect getP1();
    public abstract FilledRect getP2();
    public abstract FilledRect getP3();
    public abstract FilledRect getP4();    
    public abstract FilledRect getOwnedBy();
    
   
    


    
    
}
