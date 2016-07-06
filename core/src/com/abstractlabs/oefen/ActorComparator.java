package com.abstractlabs.oefen;

import java.util.Comparator;

import com.abstractlabs.oefen.entity.Tower;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorComparator implements Comparator < Actor > {
    @Override
    public int compare(Actor arg0, Actor arg1) {
//    	int a0 = arg0.getZIndex();
//    	int a1 = arg1.getZIndex();
//    	if(arg0 instanceof Entity) {
//    		a0 = ((Entity)arg0).getOrder();
//    	}
//    	if(arg1 instanceof Entity) {
//    		a1 = ((Entity)arg1).getOrder();
//    	}
//    	
//    	if (a0 < a1) {
//            return -1;
//        } else if (a0 == a1) {
//            return 0;
//        } else {
//            return 1;
//        }
//    	
//        if (arg0.getZIndex() < arg1.getZIndex()) {
//            return -1;
//        } else if (arg0.getZIndex() == arg1.getZIndex()) {
//            return 0;
//        } else {
//            return 1;
//        }

    	System.out.println("sorting...");
    	
    	Tower t1 = (Tower)arg0;
    	Tower t2 = (Tower)arg1;
    	
    	if(t1.getMapY()+(17*t1.getMapX()) < t2.getMapY()+(17*t2.getMapX())) {
    		t1.setZIndexBy(-1);
        	System.out.println("sorting... -1");
    		return -1;
    	} else if (t1.getMapY()+(17*t1.getMapX()) == t2.getMapY()+(17*t2.getMapX())) {
    		t1.setZIndexBy(0);
        	System.out.println("sorting... 0");
            return 0;
		} else {
    		t1.setZIndexBy(1);
        	System.out.println("sorting... 1");
	        return 1;
		}
    }
}