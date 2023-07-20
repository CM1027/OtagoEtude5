import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class PrimeDays4{
  public static void main(String[] args){
    
    ArrayList<Integer> inPut = new ArrayList<Integer>();
    ArrayList<Integer> Index = new ArrayList<Integer>();
    ArrayList<Integer> PrimeDaysMonth = new ArrayList<Integer>();
    ArrayList<Integer> Ylength = new ArrayList<Integer>();
    
    int yearLength = 0;
    Ylength.add(0);
    
    if(args.length > 0){
      try{
        for(int i = 0; i < args.length; i++){
          inPut.add(Integer.parseInt(args[i]));
        }
      }catch(NumberFormatException e){
        System.err.println("argument must be an integer");
        System.exit(1);
      }
    }
    
    //Calculate the Length of the Year
    for(int i = 0; i < inPut.size(); i++){
      yearLength += inPut.get(i);
      Ylength.add(yearLength);
    }
    
    for(int i = 1; i <= inPut.size(); i++){
      if(isPrime(i)){
        Index.add(i - 1);
      }
    }
    
    int max = Collections.max(inPut);
    //Get Prime Days of Each Month.
    for(int i = 1; i <= max; i++){
      if(isPrime(i)){  
        PrimeDaysMonth.add(i); 
      }
    }
    
    
    /*//Testing Data
    System.out.println(inPut);
    System.out.println("length" +Ylength);
    System.out.println("index" + Index);
    System.out.println("month" + PrimeDaysMonth);
    */
    
    
    //checking for truly prime
    
    for(int y : Index){
      for(int w = 0; w < PrimeDaysMonth.size(); w++){
        if(PrimeDaysMonth.get(w) <= inPut.get(y)){
          int primeDay = (PrimeDaysMonth.get(w) + Ylength.get(y));
          if(isPrime(primeDay)){
            System.out.println(primeDay + ": " + (y+1) + " " + PrimeDaysMonth.get(w) );
          }
        }
      }
    }
  }
  
  //method for checking if time
  public static boolean isPrime(int n){
    if(n == 1){
      return false;
    }
    if(n != 2 && n % 2 == 0){
      return false;
    }
    
    for(int i = 2; i <= Math.sqrt(n); i++){
      if(n % i == 0){
        return false;
      }
    }
    return true;
  }
}