import java.rmi.*;
import java.rmi.server.*;

public class De2Implementation extends UnicastRemoteObject
        implements IDe2 {

        public static int USCLN(int a, int b) {
                 if(a < 0)
           a = -a;
          if(b < 0)
           b = -b;
          if (a == 0 && b == 0)
           return -1;
          else 
          {
           while (a!= 0 && b!= 0)
           {
            if(a > b)
             a = a%b;
            else
             b = b%a;
           }
           if (a == 0)
           return b; //b la USCLN.
           else
            return a; //a la USCLN.
         }  
        
    }
 public static int BCNN(int a, int b) {
              return a * b / USCLN(a, b);
       }

    public De2Implementation() throws RemoteException {
        //There is no action need in this moment.
    }
    
    @Override
    public String getGreetingMessage(String args[]) throws RemoteException {
       String s="";
       int a = Integer.parseInt(args[0]);
        int b= Integer.parseInt(args[1]);
        	if( USCLN(a,b) == -1) {
                s=" Khong co ket qua.";
            }
            else
            {
                s = "\n USCLN = " + USCLN(a,b) +" \n BCNN = " + BCNN(a,b);
            }
        	
        
        return s;
    }
}
