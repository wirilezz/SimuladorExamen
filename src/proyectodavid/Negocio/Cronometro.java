/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectodavid.Negocio;

/**
 *
 * @author jorgerueda
 */



import java.util.Timer;
import java.util.TimerTask;
import java.util.Observable;
import javax.swing.JTextField;

/**
 * Modelo de reloj utilizando java.util.Timer
 */
public class Cronometro extends Observable
 {
     /**
      * Lanza un timer cada segundo.
      */
    int segundos = 0;
    int minutos = 0;
    int horas= 0;
    int limit;
    Timer timer;
    JTextField textField;
     public Cronometro(JTextField textField, int limit)
     {
         this.textField=textField;
         this.limit= limit;
         timer = new Timer();
         timer.scheduleAtFixedRate(timerTask, 0, 1000);
     }

     /**
      * main de prueba de esta clase.
      * No necesita una ventana para funcionar.
      
     public static void main (String [] args)
     {
         Cronometro modelo = new Cronometro();
         modelo.addObserver (new Observer()
         {
             public void update (Observable unObservable, Object dato)
             {
                 System.out.println (dato);
             }
         });
     }
     */
     /**
      * Clase que se mete en Timer, para que se le avise cada segundo.
      */
     TimerTask timerTask = new TimerTask()
     {
         /**
          * Método al que Timer llamará cada segundo. Se encarga de avisar
          * a los observadores de este modelo.
          */
         public void run() 
         {    
             if(minutos==limit){
              timer.cancel();
              setChanged();
              notifyObservers();
             }else if(segundos<59){
              segundos++;  
             }else{
              minutos++;
              segundos=0;
             }
             String hor=String.format("%02d",horas);
             String min= String.format("%02d",minutos);
             String seg= String.format("%02d",segundos);
             textField.setText(hor +":"+min +":"+seg);
         }
     };
}