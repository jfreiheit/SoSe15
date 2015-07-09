package sose15.vorbereitungen.collections21;

import java.util.*;
import java.io.*; 

// Hilfsklasse 
class Item {
   // Konstruktor 
   Item(char z, int w) {
      zeichen = z;
      prio = w; 
   }

  char zeichen;
  int prio; 
}

public class StackDemo {
   public static void main(String[] args) {

   while(true) {
      // Einen Ausdruck von Tastatur einlesen
      System.out.print(" Ausdruck: ");
      BufferedReader t = new BufferedReader(new InputStreamReader(System.in));

      String ausdruck = null;

      try {
         ausdruck = t.readLine();
      } catch(Exception e) {
         System.out.println(e);
         System.exit(0); 
      }

      // nach jedem Zeichen ein Leerzeichen einf�gen f�r
      // den StringTokenizer
      StringBuffer tmp = new StringBuffer();

      for(int i = 0; i < ausdruck.length(); i++) {
	     tmp.append(ausdruck.charAt(i));
         tmp.append(' ');
      }

      ausdruck = tmp.toString(); 

      // in einzelne Zeichen zerlegen
      StringTokenizer st = new StringTokenizer(ausdruck);

      // Ausdruck in Postfix umwandeln 
      Stack<Item> operatoren = new Stack<Item>();
      StringBuffer postFix = new StringBuffer();

      char z; 
      String str;

      while(st.hasMoreTokens()) {
         str = st.nextToken(); 
         z = str.charAt(0);  
      
         int prioAlt; // die Priorität des im vorigen Schritt
                      // gelesenen Operators
      
         if(operatoren.size() > 0) {
            Item op = operatoren.peek();
            prioAlt = op.prio;
         } else 
            prioAlt = 0;
      
         Item aktItem;  // der neu gelesene Operator/Zahl   
      
         switch(z) {
         case 'q': System.exit(0);
         case '(': aktItem = new Item(z,1); 
                   break;
         case '+':
         case '-': aktItem = new Item(z,2);   
                   break;
         case '*':
         case '/':
         case ':': aktItem = new Item(z,3); 
                   break;
         case ')': aktItem = new Item(z,4); 
                   break;
         default : // kein Operator, sondern eine Zahl
                   aktItem = new Item(z,0); 
                   break;
         }
      
         if(aktItem.prio == 0) {
            // eine Zahl direkt der Postfix-Darstellung hinzuf�gen
            postFix.append(aktItem.zeichen); 
            postFix.append(" "); 
            continue; 
         }
      
         if(aktItem.prio == 1) {
            // �ffnende Klammer auf den Stack
            operatoren.push(aktItem);
            continue; 
         }
      
         if(aktItem.prio == 4) {
            // schlie�ende Klammer gefunden 
            // solange Operatoren entfernen und zur Postfix-Darstellung 
            //hinzuf�gen, bis eine �ffnende Klammer gefunden wird 
            while(true) {
               Item op = operatoren.pop();
      
               if(op.zeichen != '(')   {
                  postFix.append(op.zeichen);
                  postFix.append(" "); 
               } else 
                  break; 
            }
            continue;
         }
      
         if(aktItem.prio > prioAlt)  {
            // der neu gelesene Operator hat eine h�her Priorit�t
            // als der vorige auf dem Stack befindliche 
            operatoren.push(aktItem);
         } else {
            // alle vorhandenen Operatoren auf dem Stack 
            // zur Postfix-Darstellung hinzuf�gen, deren
            // Priorit�t >=  dem gerade gelesenen Operator
            while(true)  {
               if(operatoren.size() > 0) {
                  Item op = operatoren.peek();
       
                  if(op.prio >= aktItem.prio)  {
                     operatoren.pop();
                     postFix.append(op.zeichen);
                     postFix.append(" "); 
                  } else
                     break; 
               }
            }
       
            operatoren.push(aktItem); // zuletzt gelesener Op. auf Stack
         }
      }
      
      // Ausdruck komplett gelesen; den Reststack leeren
      while(operatoren.size() > 0) {
         Item op = operatoren.pop();
         postFix.append(op.zeichen);
         postFix.append(" ");
      }
       
      System.out.println(" Postfix: " + postFix.toString()); 
   }
   }
}
