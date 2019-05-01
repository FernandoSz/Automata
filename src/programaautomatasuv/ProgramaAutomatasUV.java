package programaautomatasuv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProgramaAutomatasUV {

    
    public static void main(String[] args) {
        try{
        File archivo = new File("src/Ide.txt");
        FileReader fr = new FileReader(archivo);
        
        BufferedReader br = new BufferedReader(fr);
        
        
        String [] Simbolos = new String[3];
        String Aux="";
        int [] Valores = new int [3];
        int val=0;
        String Tipo[]= new String[3];
        String Auxt;
        String L1=br.readLine();
        boolean resul;
        Pattern a = Pattern.compile("^inicio>");
        Matcher EInicio=a.matcher(L1);
        resul=EInicio.find();
        if(resul==true){
            L1=br.readLine();
            Pattern b = Pattern.compile("^RF:$");
            Matcher EDeclara = b.matcher(L1);
            resul=EDeclara.find();
            if(resul==true){
                L1=br.readLine();
                Pattern c = Pattern.compile("^Entero:[a-z A-Z]*[;]$");
                Matcher EVaria = c.matcher(L1);
                resul=EVaria.find();
                if(resul==true){
                    Aux=L1.replaceAll("Entero:|;|","");
                    Aux=Aux.replaceAll(" ","");
                    Auxt="Entero";
                    Tipo[0]=Auxt;
                    Simbolos[0]=Aux;
                    
                    L1=br.readLine();
                    Pattern cc =Pattern.compile("^Entero:[a-z A-Z]*[;]$");
                    Matcher EbVaria = cc.matcher(L1);
                    resul=EbVaria.find();
                    if(resul==true){
                     Aux=L1.replaceAll("Entero:|;","");
                     Aux=Aux.replaceAll(" ","");
                     Simbolos[1]=Aux;
                     Auxt="Entero";
                    Tipo[1]=Auxt;
                     
                     L1=br.readLine();
                     Pattern to = Pattern.compile("^Entero:[a-z A-Z]*[;]$");
                     Matcher ETota= to.matcher(L1);
                     resul= ETota.find();
                     if(resul==true){
                         Aux=L1.replaceAll("Entero:|;","");
                         Aux=Aux.replaceAll(" ","");
                         Simbolos[2]=Aux;
                         Auxt="Entero";
                    Tipo[2]=Auxt;
                         
                     L1=br.readLine();
                     Pattern d =Pattern.compile("^Mostrar: [a-z A-Z 0-9]*[;]$");
                     Matcher Emostrar=d.matcher(L1);
                     resul=Emostrar.find();
                     if(resul==true){
                         L1=br.readLine();
                         Pattern e=Pattern.compile("^Leer:[a-z A-Z 0-9]*=:[0-9]*[;]$");
                         Matcher EAsign = e.matcher(L1);
                         resul=EAsign.find();
                         if(resul==true){
                             Aux=L1.replaceAll("Leer:|=|;|:|[0-9]","");
                             Aux=Aux.replaceAll(" ","");
                             String a1=Simbolos[0];
                             String a2=Simbolos[1];
                             if(Aux.equals(a1) || Aux.equals(a2)){
                                 Aux=L1.replaceAll("[a-z A-Z]|;|:|=:","");
                                 val=Integer.parseInt(Aux);
                                 Valores[0]=val;
                                 val=0;
                                 L1=br.readLine();
                                 Pattern f=Pattern.compile("^Leer:[a-z A-Z 0-9]*=:[0-9]*[;]$");
                                 Matcher EAsignb = f.matcher(L1);
                                 resul= EAsignb.find();
                                 if(resul==true){
                                     Aux=L1.replaceAll("Leer:|=|;|:|[0-9]","");
                                     Aux=Aux.replaceAll(" ","");
                                     Aux=Simbolos[1];
                                     
                             if(Aux.equals((Simbolos[0]))||(Aux.equals(Simbolos[1]))){
                                 Aux=L1.replaceAll("[a-z A-Z]|;|:| |=","");
                                 
                                 val=Integer.parseInt(Aux);
                                 Valores[1]=val;
                                 val=0;
                                 L1=br.readLine();
                                 Pattern g =Pattern.compile("^Si[:][a-z A-Z]*Maq|Meq|Ig|Dist [a-z A-Z 0-9]*[;]$");
                                 Matcher Eif = g.matcher(L1);
                                 resul=Eif.find();
                                 if(resul==true){
                                     String Bus1="Maq";
                                     String busval1=Simbolos[0].toString();
                                     String busval2=Simbolos[1].toString();
                                     
                                     boolean r =L1.contains(Bus1);
                                     if(r==true){
                                        Aux= L1.replaceAll("Si: |Maq|;","");
                                        String rf="[".concat(Simbolos[0].toString()).concat("]");
                                        Pattern bv= Pattern.compile(rf);
                                        Matcher bbv = bv.matcher(Aux);
                                         
                                        resul=bbv.find();
                                        if(resul==true){
                                            String as="[".concat(Simbolos[1].toString().concat("]"));
                                            Pattern bc=Pattern.compile(as);
                                            Matcher bbc=bc.matcher(Aux);
                                            resul=bbc.find();
                                            if(resul==true){
                                                Bus1=Simbolos[0].toString();
                                                
                                                int p1;
                                                p1=L1.indexOf(Bus1);
                                                
                                                Bus1=Simbolos[1].toString();
                                                int p2;
                                                p2=L1.indexOf(Bus1);
                                             
                                               L1=br.readLine();
                                               
                                             
                                               Pattern ESumaa= Pattern.compile("^("+Simbolos[2].toString()+")[=][:] ("+Simbolos[0].toString()+") Mas ("+Simbolos[1].toString()+")[;]");
                                               Matcher Msumaa=ESumaa.matcher(L1);
                                               resul=Msumaa.find();
                                               
                                               if(resul==true){
                                                 int total;
                                                 if(Valores[0]>Valores[1]){
                                                     total=Valores[0]+Valores[1];
                                                 }else{
                                                     total=Valores[1]-Valores[0];
                                                 }
                                                   Valores[2]=total;
                                                   System.out.println("Mostrar: "+Valores[2]);
                                                   System.out.println("\n            Tabla De Simbolos");
                                                   System.out.println("Tipo:     Variable:          Valor:");
                                                   for(int i=0; i<Valores.length;i++){
                                                       System.out.println(Tipo[i]+"      "+Simbolos[i]+"                 "+Valores[i]);
                                                   }
                                                  
                                                   
                                                   
                                                   L1=br.readLine();
                                                   Pattern EContra = Pattern.compile("^Contrario:$");
                                                   Matcher MContra = EContra.matcher(L1);
                                                   resul= MContra.find();
                                                   if(resul==true){
                                                       L1=br.readLine();
                                                       Pattern Scontra = Pattern.compile("^("+Simbolos[1].toString()+") Menos ("+Simbolos[0].toString()+")[;]");
                                                       Matcher MContrab = Scontra.matcher(L1);
                                                       resul = MContrab.find();
                                                       if(resul==true){
                                                           
                                                           L1=br.readLine();
                                                           Pattern EResultado = Pattern.compile("^Mostrar: ["+Simbolos[2].toString()+"];");
                                                           Matcher MResultado = EResultado.matcher(L1);
                                                           resul=MResultado.find();
                                                           if(resul==true){
                                                               Aux=L1.replaceAll(Simbolos[2]+";",""+total);
                                                               L1=br.readLine();
                                                               
                                                               Pattern Sfin = Pattern.compile("<Fin");
                                                               Matcher Mfin = Sfin.matcher(L1);
                                                               resul=Mfin.find();
                                                               if(resul==true){
                                                                   
                                                                  
                                                                   
                                                               }else{
                                                                   System.out.println("Error Al Finalizar El Programa.");
                                                               }
                                                               
                                                           }else{
                                                               System.out.println("Error En Sentencia Mostrar.");
                                                           }
                                                          
                                                           
                                                           
                                                           
                                                       }else{
                                                           System.out.println("Error En El Contrario.");
                                                       }
                                                       
                                                       
                                                   }else{
                                                       System.out.println("Error En El Contrario.");
                                                   }
                                                   
                                                   
                                                   
                                                   
                                               }else{
                                                   System.out.println("no Existen Las Variables" );
                                                   
                                               }
                                                
                                                
                                                
                                               
                                            }else{
                                                System.out.println("No Existe");
                                            }
                                            
                                        }else{
                                            System.out.println("No Existe");
                                        }
                                        
                                         
                                         
                                     }else{
                                         
                                     }
                                     
                                 }else{
                                     System.out.println("Error En El if");
                                 }
                                
                                 
                                
                             }else{
                                 System.out.println("La Variable "+Aux+" No Ha Sido Declarada.");
                             }
                                     
                                     
                                     
                                 }else{
                                     System.out.println("Error En La Asignacion De Valores 2");
                                 }
                               
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                             }else{
                                 System.out.println("La Variable "+Aux+" No Ha Sido Declaradjja.");
                                 
                                
                             }
                             
                             
                            
                             
                         }else{
                             System.out.println("Error En La Asignacion De Valores 1.");
                         }
                         
                         
                         
                         
                         
                     }else{
                         System.out.println("Error En La Sentencia Mostrar.");
                     }
                     }else{
                         System.out.println("Error Al Declarar La Variable 3.");
                     }
                    }else{
                        System.out.println("Error Al Declarar La Variable 2.");
                    }
                    
                    
                    
                    
                }else{
                    System.out.println("Error Al Declarar Variable 1.");
                }
                
                
                
                
                
            }else{
                System.out.println("Error En El Inicio De Variables.");
            }
            
            
            
            
            
            
            
        }else{
            System.out.println("Error En El Encabezado De Inicio.");
        }
        
        
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
    }catch(Exception e){
            System.out.println("Error Al Leer");
    }
    }
    
}
