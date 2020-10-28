package exploreandbuild;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class EthenaHealth {

	 public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        Scanner s = new Scanner(new File("D:\\Keppler\\exploreandbuild\\src\\exploreandbuild\\input.txt"));
	        int tc = s.nextInt();
	        for(int i=0; i< tc; i++){
	            int n = s.nextInt();
	            HashSet<Point> set = new HashSet<>();
	            for(int j=0; j<n;j++){	                
	                int x = s.nextInt();
	                int y = s.nextInt();
	                set.add(new Point(x,y));
	            }
	            //process
	            //find max and min for x & y
	            int xmin = findXMin(set);
	            int xmax = findXMax(set);
	            int ymin = findYMin(set);
	            int ymax = findYMax(set);
	            //System.out.println(xmin+" "+xmax+" "+ymin+" "+ymax);
	            
	            HashSet<Point> result = new HashSet<>();
	            Iterator<Point> iter = set.iterator();
	            while(iter.hasNext()){
	            	Point p = iter.next();
	            	//check if any other points are in two diagonals both directions
	            	int k = 1;
	            	//x-1 y-1
	            	while(p.x-k > xmin && p.y-k > ymin){
	            		if(set.contains(new Point(p.x-k, p.y-k))){
	            			result.add(new Point(p.x-k, p.y-k));
	            		}
	            	}
	            	
	            }
	           
	            
	           
	            
	           // s.close();
	        }
	    }
	    
	    
	private static int findXMin(Set<Point> set) {
	    	 Iterator<Point> iter1 = set.iterator();
	            Integer xmin = Integer.MAX_VALUE;            
	            while(iter1.hasNext()){
	            	Point p = iter1.next();
	            	if(p.x < xmin){
	            		xmin= p.x;
	            	}
	            }
	            //System.out.println("xmin: "+xmin);
	            return xmin;
	}
	
	private static int findXMax(Set<Point> set) {
		 Iterator<Point> iter = set.iterator();
         Integer xmax = Integer.MIN_VALUE;	            
         while(iter.hasNext()){
         	Point p = iter.next();
         	if(p.x > xmax){
         		xmax = p.x;
         	}
         }
         //System.out.println("xmax: "+xmax);
         return xmax;
}
	
	private static int findYMin(Set<Point> set) {
   	 Iterator<Point> iter1 = set.iterator();
           Integer xmin = Integer.MAX_VALUE;            
           while(iter1.hasNext()){
           	Point p = iter1.next();
           	if(p.y < xmin){
           		xmin= p.y;
           	}
           }
           //System.out.println("xmin: "+xmin);
           return xmin;
}
	
	private static int findYMax(Set<Point> set) {
   	 Iterator<Point> iter1 = set.iterator();
           Integer ymax = Integer.MIN_VALUE;            
           while(iter1.hasNext()){
           	Point p = iter1.next();
           	if(p.y > ymax){
           		ymax= p.y;
           	}
           }
           //System.out.println("xmin: "+ymax);
           return ymax;
}


		static class Point{
	        int x;
	        int y;
	        public Point(int x, int y){
	            this.x = x;
	            this.y = y;
	        }
	        
	        public boolean equals(Object o){
	        	if(o == null)
	        		return false;
	        	Point p = (Point)o;
	        	if(p.x == this.x && p.y == this.y){
	        		return true;
	        	}
	        	return false;
	        }
	        
	        public int hashCode(){
	        	int h = 31;
	        	h = h * this.x;
	        	h = h * this.y;
	        	return h;
	        }
	    }
}
