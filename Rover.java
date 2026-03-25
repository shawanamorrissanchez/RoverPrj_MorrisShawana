import java.util.ArrayList;

public class Rover{

   private String nombre;
   private double potenciaInicial;
   private double potenciaDisponible;

   private int limiteRecargas;
   
   private int xInicial;
   private int yInicial;

   private int xActual;
   private int yActual;

   private ArrayList<String> mandatosRealizados;
   private ArrayList<String> mandatosNoRealizados;
   
   private static int cantidadRovers;
   private static ArrayList<Rover> listaRovers= new ArrayList<>();

   public Rover(String nombre){
   
      this.nombre= nombre;
      this.potenciaInicial=100;
      this.potenciaDisponible=100;
      this.limiteRecargas =5;
      this.xInicial=0;
      this.yInicial=0;
      this.xActual=0;
      this.yActual=0;
      mandatosRealizados= new ArrayList<>();
      mandatosNoRealizados= new ArrayList<>();
      cantidadRovers++;
      listaRovers.add(this);

    }


   private boolean detectarFugaCalor(){
      double numero= Math.random();

      potenciaDisponible= potenciaDisponible-0.25;

      if(numero >=0.5){

         return true;
      }
      else{
          return false;
      }
   }

   public void desplazarAdelante(){

      if (potenciaDisponible < 0.75){
         mandatosNoRealizados.add("Desplazar Adelante - potencia insuficiente");
         return;

      }
      if( detectarFugaCalor()){
         mandatosNoRealizados.add("Desplazar Adelante - Fuga de calor");
         return;
      }
      else{

         yActual++;
         potenciaDisponible-=0.5;
         mandatosRealizados.add("Desplazar Adelante - éxitoso");
      }
   }

   public void desplazarAtras(){

      if (potenciaDisponible < 0.75){
         mandatosNoRealizados.add("Desplazar Adelante - potencia insuficiente");
         return;

      }
      if( detectarFugaCalor()){
         mandatosNoRealizados.add("Desplazar Adelante - Fuga de calor");
         return;
      }
      else{

         yActual--;
         potenciaDisponible-=0.5;
         mandatosRealizados.add("Desplazar Adelante - éxitoso");
      }
   }
   public void desplazarDerecha(){

      if (potenciaDisponible < 0.75){
         mandatosNoRealizados.add("Desplazar Adelante - potencia insuficiente");
         return;

      }
      if( detectarFugaCalor()){
         mandatosNoRealizados.add("Desplazar Adelante - Fuga de calor");
         return;
      }
      else{

         xActual++;
         potenciaDisponible-=0.5;
         mandatosRealizados.add("Desplazar Adelante - éxitoso");
      }
   }
   public void desplazarAIzquierda(){

      if (potenciaDisponible < 0.75){
         mandatosNoRealizados.add("Desplazar Adelante - potencia insuficiente");
         return;

      }
      if( detectarFugaCalor()){
         mandatosNoRealizados.add("Desplazar Adelante - Fuga de calor");
         return;
      }
      else{

         xActual--;
         potenciaDisponible-=0.5;
         mandatosRealizados.add("Desplazar Adelante - éxitoso");
      }
   }
   public String conocerPosicionActual(){

    return "(" + xActual + ", " + yActual + ")";
   }
   public double conocerPotencia(){
      return potenciaDisponible;
   }

   public void recargaPotencia(double unidades){
      if(limiteRecargas <=0){
         mandatosNoRealizados.add("No quedan recargas disponibles");
         return;

      }
      potenciaDisponible += unidades;
      limiteRecargas--;

      mandatosNoRealizados.add("Recarga de "+ unidades+" realizada");
      return;


   } 
   public String conocerEstado(){

      String estado = "";

      estado += "Nombre del Rover: " + nombre + "\n";
      estado += "Potencia inicial: " + potenciaInicial + "\n";
      estado += "Potencia disponible: " + potenciaDisponible + "\n";
      estado += "Recargas disponibles: " + limiteRecargas + "\n";
      estado += "Posición inicial: (" + xInicial + ", " + yInicial + ")\n";
      estado += "Posición actual: (" + xActual + ", " + yActual + ")\n";
      estado += "Mandatos realizados: " + mandatosRealizados + "\n";
      estado += "Mandatos no realizados: " + mandatosNoRealizados + "\n";

      return estado;
   }
   public static int conocerCantidadRovers(){
      return cantidadRovers;
   }
   public static String informacionDeRovers(){

      String info = "";

      for(Rover r: listaRovers){
         info += r.conocerEstado() + "\n";
      }

      return info;
   }


}
