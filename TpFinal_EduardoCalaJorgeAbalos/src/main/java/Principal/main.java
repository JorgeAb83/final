package Principal;

import DAO.EmpleadoDAO;
import DAO.EmpleadoDAOlmpl;
import DAO.ProyectoDAOlmpl;
import DAO.ProyectoDAO;
import Modelo.Empleado;
import Modelo.Proyectos;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;






public class main {
    
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");//formato de fecha
    public static SimpleDateFormat año = new SimpleDateFormat("YYYY");//formato de fecha
    public static SimpleDateFormat mes = new SimpleDateFormat("MM");//formato de fecha
    public static SimpleDateFormat dia = new SimpleDateFormat("dd");//formato de fecha
    
    
    public static Calendar calendar = new GregorianCalendar();
    
    public static Date getDateCalendar(){
        return calendar.getTime();
    } 
    
    public static void main(String[] args) {
        ProyectoDAO proyecto = new ProyectoDAOlmpl();
        EmpleadoDAO empleado = new EmpleadoDAOlmpl();
       
        int op=0;
           do {
            try{
            op=Integer.parseInt(JOptionPane.showInputDialog("MENU\n"
                +"1_Empleado\n"
                +"2_Proyectos\n"
                +"3_Salir"));
            switch(op){
                case 1:
                    int op2=0;
                    do {
                       try{
                       op2=Integer.parseInt(JOptionPane.showInputDialog("MENU\n"
                             +"1_Agregar Empleado\n"
                             +"2_Eliminar Empleado\n"
                             +"3_Modificar Empleado\n"
                             +"4_Listar Empleados\n"
                             +"5_Mostrar Empleado con mayor edad\n"
                             +"6_Listar Empleados que se superen a un determinado sueldo basico ingresado\n"
                             +"7_Buscar Empleado por DNI o por Apellido\n"
                             +"8_Volver")); 
                       switch(op2){
                           case 1:
                               boolean Respuesta=false;
                               try{
                               int o=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el N° de legajo del Empleado: "));
                               
                               for(Empleado e:empleado.TrearListaEmpleado()){
                                   
                                   if (e.getId()==o) {
                                       Respuesta = true;
                                   }
                               }
                               //EL IDE INGRESADO EXITE?
                               if (Respuesta==true) {
                                   JOptionPane.showMessageDialog(null,"El N° de legajo ingresado ya existe");
                               }else{
                                   String nombre=JOptionPane.showInputDialog("Ingrese el nombre: ");
                               String apellido=JOptionPane.showInputDialog("Ingrese el apellido: ");
                               try{
                               int dni=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el CUIT: "));
                               float sueldo=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el sueldo basico: "));
  
                               int año=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Nacimiento\nIngrese el año"));
                               if(1000>año||año>3000){
                                   JOptionPane.showMessageDialog(null,"El numero de año ingresado es muy grande\nIngrese un año menor al 3000 y mayor a 1000");
                               }else{
                                   int mes=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Nacimiento\nIngrese el mes"));
                                   
                                   if(mes>12){
                                       JOptionPane.showMessageDialog(null,"El numero de mes ingresado es muy grande\nIngrese un mes menor o igual 12");
                                   }else{
                                       int dia=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Nacimiento\nIngrese el dia"));
                                       if(dia>31){
                                            JOptionPane.showMessageDialog(null,"El numero de dia ingresado es muy grande\nIngrese un dia menor o igual 31");
                                       }else{
                                          mes--;
                                          calendar.set(año,mes,dia);
                                          Date fecha1=getDateCalendar();
                               
                                           Empleado emp = new Empleado(o,nombre,apellido,fecha1,dni,sueldo,null);
                                            empleado.CrearEmpleado(emp);
                                           JOptionPane.showMessageDialog(null,"El Empleado fue registrado"); 
                                       }
                                   }
                               }
                               
                               }
                               catch(java.lang.NumberFormatException e){
                                       JOptionPane.showMessageDialog(null,"Ingreso un carater cunado se esperaba un valor numerico");
                                       }
                               }
                               }catch(java.lang.NumberFormatException e){
                                   JOptionPane.showMessageDialog(null,"Ingreso un carater cunado se esperaba un valor numerico");
                               }
                               break;
                           case 2:
                               boolean Respuesta1=false;
                               try{
                               int m=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id: "));
                               for(Empleado e:empleado.TrearListaEmpleado()){
                                   
                                   if (e.getId()==m) {
                                       Respuesta1 = true;
                                   }
                               }
                               if(Respuesta1==true){
                                    empleado.EliminarEmpleado(m);
                                    JOptionPane.showMessageDialog(null,"El Empleado fue eliminado");
                               }else{
                                   JOptionPane.showMessageDialog(null,"El id ingresado no existe");
                               }
                               }catch(java.lang.NumberFormatException e){
                                   JOptionPane.showMessageDialog(null,"Ingreso un caracter cuando se esperaba un valor numerico");
                               }
                               break;
                           case 3:
                               int x=0;
                               boolean RE=false;
                               try{
                               x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del empledao a modificar: "));
                               
                               for(Empleado e:empleado.TrearListaEmpleado()){
                                   
                                   if (e.getId()==x) {
                                       RE = true;
                                   }
                               }
                               if(RE==true){
                                    
                               String nombr=JOptionPane.showInputDialog("Ingrese el nombre: ");
                               String apellid=JOptionPane.showInputDialog("Ingrese el apellido: ");
                               try{
                               int dn=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el CUIT: "));
                               int sueld=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el sueldo basico: "));
                               Proyectos p = empleado.traerEmpleado(x).getProyecto();
                               
                               
                               
                               
                               int año1=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Nacimiento\nIngrese el año"));
                               if(1000>año1||año1>3000){
                                   JOptionPane.showMessageDialog(null,"El numero de año ingresado es muy grande\nIngrese un año menor al 3000 y mayor a 1000");
                               }else{
                                  
                                   int mes1=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Nacimiento\nIngrese el mes"));
                                   if(mes1>12){
                                       JOptionPane.showMessageDialog(null,"El numero de mes ingresado es muy grande\nIngrese un mes menor o igual 12");
                                   }else{
                                       int dia1=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Nacimiento\nIngrese el dia"));
                                       if(dia1>31){
                                            JOptionPane.showMessageDialog(null,"El numero de dia ingresado es muy grande\nIngrese un dia menor o igual 31");
                                       }else{
                                          mes1--;
                                          calendar.set(año1,mes1,dia1);
                                          Date fecha11=getDateCalendar();
                               
                                          empleado.EliminarEmpleado(x);
                               
                               
                                          Empleado es = new Empleado(x,nombr,apellid,fecha11,dn,sueld,p);
                                         empleado.CrearEmpleado(es);
                                          JOptionPane.showMessageDialog(null,"El Empleado fue modificado");
                                       }
                                   }
                               }
                               
                               
                               
                               
                               
                               
                               }catch(java.lang.NumberFormatException e){
                                   JOptionPane.showMessageDialog(null,"Ingreso un carater cuando se esperaba un valor numerico");
                               }
                              
                               }else{
                                   JOptionPane.showMessageDialog(null,"El N° de legajo ingresado no existe");
                               }
                               }catch(java.lang.NumberFormatException e){
                                   JOptionPane.showMessageDialog(null,"Ingreso un caracter cuando se esperaba un valor numerico");
                               }

                               break;
                           case 4:
                               String exto=" ";
                               int y=0;
                               for(Empleado g:empleado.TrearListaEmpleado()){
                                   exto+="**********************************\n"
                                           +"Nombre: "+g.getNombre()+"\n"
                                           +"Apellido: "+g.getApellido()+"\n"
                                           +"CUIT: "+g.getDni()+"\n"
                                           +"N° de legajo: "+g.getId()+"\n"
                                           +"Fecha Nacimiento: "+sdf.format(g.getFechanacimiento())+"\n"
                                           //+"Proyecto"+g.getProyecto()+"\n"
                                           +"Sueldo Basico: "+g.getSueldo()+"\n";
                                   
                                   y++;
                               }
                               if(exto==" "){
                                   JOptionPane.showMessageDialog(null,"La lista de Empleados esta vacia");
                               }else{
                                   exto+="*************************************\n"
                                       +"Cantidad de Empleados Registrados:"+y;
                               JOptionPane.showMessageDialog(null,exto);
                               }
                               break;
                           case 5:
                               String t=" ";
                               int id;
                               int edad=0,edad1=0;
                               for(Empleado e:empleado.TrearListaEmpleado()){
                                   
                                   edad=empleado.CalcularEdad(e.getFechanacimiento());
                                   if(edad>edad1){
                                      
                                       edad1=edad;
                                        
                                   }
                                   
                               }
                               
                               for(Empleado e:empleado.TrearListaEmpleado()){
                                   
                                   if(edad1==empleado.CalcularEdad(e.getFechanacimiento())){
                                      t+="*********************************\n"
                                           +"N° de legajo: "+e.getId()+"\n"
                                           +"Nombre: "+e.getNombre()+"\n"
                                           +"Apellido: "+e.getApellido()+"\n"
                                           +"FechaNacimiento: "+sdf.format(e.getFechanacimiento())+"\n"
                                           +"Edad: "+empleado.CalcularEdad(e.getFechanacimiento())+"\n"
                                           +"CUIT: "+e.getDni()+"\n"
                                           +"Sueldo Basico: "+e.getSueldo()+"\n"
                                         ;
                                      
                                   }
    
                               }
                               if(t==" "){
                                   JOptionPane.showMessageDialog(null,"La lista de Empleados esta vacia");
                               }else{
                                   JOptionPane.showMessageDialog(null,t); 
                               }
                               
                                  
                               break;
                           case 6:
                               String te="";
                               try{
                               float SueldoBasico=Float.parseFloat(JOptionPane.showInputDialog("Ingrese el sueldo Basico a comparar"));
                               for(Empleado e:empleado.TrearListaEmpleado()){
                                   if(e.getSueldo()>SueldoBasico){
                                      te+="*********************************\n"
                                           +"N° de legajo: "+e.getId()+"\n"
                                           +"Nombre: "+e.getNombre()+"\n"
                                           +"Apellido: "+e.getApellido()+"\n"
                                           +"FechaNacimiento: "+sdf.format(e.getFechanacimiento())+"\n"
                                           +"CUIT: "+e.getDni()+"\n"
                                           +"Sueldo: "+e.getSueldo()+"\n"
                                           ; 
                                   }
                               }
                               if(te==""){
                                   JOptionPane.showMessageDialog(null,"La lista de Empleados esta vacia");
                               }else{
                                   JOptionPane.showMessageDialog(null,te);
                               }
                               }catch(java.lang.NumberFormatException e){
                                    JOptionPane.showMessageDialog(null,"Ingreso un carater cuando se esperaba un valor numerico");
                               }
                               break;
                           case 7:
                               String h="";
                               String dni1=JOptionPane.showInputDialog("Ingrese el CUIT o Apellido");
                               try{
                                   int a = Integer.parseInt(dni1);
                                   for(Empleado d:empleado.TrearListaEmpleado()){
                                   if(d.getDni()==a){
                                      h+="*********************************\n"
                                           +"N° de legajo: "+d.getId()+"\n"
                                           +"Nombre: "+d.getNombre()+"\n"
                                           +"Apellido: "+d.getApellido()+"\n"
                                           +"FechaNacimiento: "+sdf.format(d.getFechanacimiento())+"\n"
                                           +"CUIT: "+d.getDni()+"\n"
                                           +"Sueldo Basico: "+d.getSueldo()+"\n"; 
                                   }
                                   
                                   }
                                   if(h==""){
                                       JOptionPane.showMessageDialog(null,"El CUIT ingresado no se encuntra registrado");
                                   }else{
                                       JOptionPane.showMessageDialog(null,h);
                                   }
                                   
                               }catch(Exception e){
                                 for(Empleado d:empleado.TrearListaEmpleado()){
                                   if(d.getApellido().equals(dni1)){
                                      h+="*********************************\n"
                                           +"N° de legajo: "+d.getId()+"\n"
                                           +"Nombre: "+d.getNombre()+"\n"
                                           +"Apellido: "+d.getApellido()+"\n"
                                           +"FechaNacimiento: "+sdf.format(d.getFechanacimiento())+"\n"
                                           +"CUIT: "+d.getDni()+"\n"
                                           +"Sueldo: "+d.getSueldo()+"\n"; 
                                   }
                                   
                               }
                               if(h==""){
                                       JOptionPane.showMessageDialog(null,"El Apellido ingresado no se encuentra registrado");
                                   }else{
                                       JOptionPane.showMessageDialog(null,h);
                                   }
                                 
                               }
                               break;
                           case 8:
                               break;
                           default:
                                JOptionPane.showMessageDialog(null,"Elija una opcion exitente");
                               break;
                       }
                       }catch(java.lang.NumberFormatException e){
                           JOptionPane.showMessageDialog(null,"Ingreso un caracter cuando se esperaba un valor numerico");
                       }
                    } while (op2!=8);
                    break;
                case 2:
                    int op3=0;
                    do {
                       try{
                       op3=Integer.parseInt(JOptionPane.showInputDialog("MENU\n"
                             +"1_Agregar nuevo proyecto\n"
                             +"2_Eliminar proyecto\n"
                             +"3_Listar proyectos\n"
                             +"4_Agregar Emplaedo a un proyecto\n"                         
                             +"5_Quitar Empleado de un proyecto\n"
                             +"6_Listar datos de un proyecto\n"
                             +"7_Calcular el total de montos destinados a proyectos\n"
                             +"8_Calcular el monto que resibe cada participante de un proyecto\n"
                             +"9_Listar proyectos por rangos de fechas\n"
                             +"10_Volver")); 
                       
                       switch(op3){
                           case 1:
                               boolean b=false;
                               try{
                               int id=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del proyecto del proyecto"));
                               
                               for(Proyectos p:proyecto.TrearProyecto()){
                                   if(p.getId()==id){
                                       b=true;
                                   }
                               }
                               
                               if(b==true){
                                   JOptionPane.showMessageDialog(null,"El codigo del proyecto ingreasdo ya existe");
                               }else{
                                  
                               int num_legajo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el N°de legajo"));
                               String Nombre =JOptionPane.showInputDialog("Ingrese el nombre del proyecto");
                               float monto = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el monto presupuestado"));
                               
                               
                               
                               
                               
                               int año1=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Inicio\nIngrese el año"));
                               if(1000>año1||año1>3000){
                                   JOptionPane.showMessageDialog(null,"El numero de año ingresado es muy grande\nIngrese un año menor al 3000 y mayor a 1000");
                               }else{
                                   int mes1=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Inicio\nIngrese el mes"));
                                   
                                   if(mes1>12){
                                       JOptionPane.showMessageDialog(null,"El numero de mes ingresado es muy grande\nIngrese un mes menor o igual 12");
                                   }else{
                                       int dia1=Integer.parseInt(JOptionPane.showInputDialog("Fecha de Inicio\nIngrese el dia"));
                                       if(dia1>31){
                                            JOptionPane.showMessageDialog(null,"El numero de dia ingresado es muy grande\nIngrese un dia menor o igual 31");
                                       }else{
                                           mes1--;
                                          calendar.set(año1,mes1,dia1);
                               Date fecha11=getDateCalendar();
                               
                               
                                List<Empleado>lista=new ArrayList();
                                Proyectos pro = new Proyectos (id,num_legajo,Nombre,monto,fecha11,lista);
                                proyecto.CrearProyecto(pro); 
                                JOptionPane.showMessageDialog(null,"Se creo el nuevo proyecto");
                                       }
                                   }
                               }
                               
                               }
                               
                               }catch(java.lang.NumberFormatException e){
                                 JOptionPane.showMessageDialog(null,"Ingreso un caracter cuando se esperaba un valor numerico");
                               }
                               break;
                           case 2:
                               boolean d=false;
                               try{
                               int id1=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del proyecto a borrar"));
                               
                               for(Proyectos p:proyecto.TrearProyecto()){
                                   if(id1==p.getId()){
                                       d=true;
                                   }
                               }
                               if(d==true){
                                   proyecto.EliminarProyecto(id1);
                                   JOptionPane.showMessageDialog(null,"Se elimino el proyecto");
                               }else{
                                  JOptionPane.showMessageDialog(null,"No se encuentra el proyecto registrado"); 
                               }
                               
                               
                               }catch(java.lang.NumberFormatException e){
                                   JOptionPane.showMessageDialog(null,"Ingreso un carater cunado se esperaba un valor numerico");
                               }
                               break;
                           case 3:
                               String Texto="";
                               for(Proyectos p:proyecto.TrearProyecto()){
                                   Texto+="*************************************************\n"
                                           +"Nombre Proyecto: "+p.getNombre()+"\n"
                                           +"Codigo de proyecto: "+p.getId()+"\n"
                                           +"Numero de legajo:"+p.getNumlejago()+"\n"
                                           +"Monto Presupuestado:"+p.getMonto()+"\n"
                                           +"Fecha de Proyecto:"+sdf.format(p.getFechapreoyecto())+"\n";
                               }
                               if(Texto==""){
                                   JOptionPane.showMessageDialog(null,"La lista de Proyectos se encuentra vacia");
                               }else{
                                   JOptionPane.showMessageDialog(null,Texto);
                               }
                               
                               break;
                           case 4:
                               boolean as=false,az=false;
                               try{
                               int iden =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del Proyecto"));
                               for(Proyectos p:proyecto.TrearProyecto()){
                                   if(iden==p.getId()){
                                       as=true;
                                   }
                               }
                               if(as==true){
                                   int idem =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el N° de legajo del empleado"));
                                   for(Empleado e:empleado.TrearListaEmpleado()){
                                       if(idem==e.getId()){
                                           az=true;
                                       }
                                   }
                                   if(az==true){
                                       
                               
                               int num_legaj=proyecto.traerProyecto(iden).getNumlejago();
                               String Nombr =proyecto.traerProyecto(iden).getNombre();
                               float mont = proyecto.traerProyecto(iden).getMonto();
                               Date flo = proyecto.traerProyecto(iden).getFechapreoyecto();
                               List<Empleado>lista8=new ArrayList();
                               lista8=proyecto.traerProyecto(iden).getListaempleado();
                               proyecto.EliminarProyecto(iden);
                               List<Empleado>lista7=new ArrayList();
                               Proyectos pro2 = new Proyectos (iden,num_legaj,Nombr,mont,flo,lista7);
                               proyecto.CrearProyecto(pro2);
                              
                               
                               String nombr=empleado.traerEmpleado(idem).getNombre();
                               String apellido=empleado.traerEmpleado(idem).getApellido();;
                               int dni=empleado.traerEmpleado(idem).getDni();
                               float sueldo=empleado.traerEmpleado(idem).getSueldo();
                               Date fa = empleado.traerEmpleado(idem).getFechanacimiento();
                               
                               empleado.EliminarEmpleado(idem);
                               Empleado x1 = new Empleado(idem,nombr,apellido,fa,dni,sueldo,pro2);
                               empleado.CrearEmpleado(x1);
                               lista7=lista8;
                               lista7.add(x1);
                               pro2.setListaempleado(lista7);
                               proyecto.EditarProyecto(pro2);
                               JOptionPane.showMessageDialog(null,"Se agrego al proyecto el empleado"); 
                            
                                   }else{
                                       JOptionPane.showMessageDialog(null,"El N°de legajo no se encuentra registrado");
                                   }
                               
                               
                               
                               }else{
                                   JOptionPane.showMessageDialog(null,"El codigo del proyecto nose encuentra registrado");
                               }
                               }catch(java.lang.NumberFormatException e){
                                    JOptionPane.showMessageDialog(null,"Ingreso un carater cunado se esperaba un valor numerico");
                               }
                               
                               break;
                           case 5:
                               boolean n1=false,n2=false,n3=false;
                               try{
                               int U=0;
                               int iden1 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo proyecto del Proyecto"));
                               
                               for(Proyectos p:proyecto.TrearProyecto()){
                                   if(iden1==p.getId()){
                                       n1=true;
                                   }
                               }
                               
                               if(n1==true){
                                   
                               int idem1 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el N°de legajo del empledao"));
                               
                               for(Empleado e:empleado.TrearListaEmpleado()){
                                   if(idem1==e.getId()){
                                       n3=true;
                                   }
                               }
                               if(n3==true){
                                   for(Proyectos p:proyecto.TrearProyecto()){
                                   if(iden1==p.getId()){
                                       for(Empleado e:p.getListaempleado()){
                                           if(e.getId()==idem1){
                                               n2=true;
                                           }
                                       }
                                   }
                               }
                               
                               if(n2==true){
                                   String nombr1=empleado.traerEmpleado(idem1).getNombre();
                               String apellido1=empleado.traerEmpleado(idem1).getApellido();;
                               int dni1=empleado.traerEmpleado(idem1).getDni();
                               float sueldo1=empleado.traerEmpleado(idem1).getSueldo();
                                Date fa1 = empleado.traerEmpleado(idem1).getFechanacimiento();
                               empleado.EliminarEmpleado(idem1);
                               Empleado x11 = new Empleado(idem1,nombr1,apellido1,fa1,dni1,sueldo1,null);
                               empleado.CrearEmpleado(x11);
                               
                               
                               
                               
                               int num_legaj1=proyecto.traerProyecto(iden1).getNumlejago();
                               String Nombr1 =proyecto.traerProyecto(iden1).getNombre();
                               float mont1 = proyecto.traerProyecto(iden1).getMonto();
                               Date flo1 = proyecto.traerProyecto(iden1).getFechapreoyecto();
                               List<Empleado>lista712=new ArrayList();
                               lista712=proyecto.traerProyecto(iden1).getListaempleado();
                               proyecto.EliminarProyecto(iden1);
                               
                               for(Empleado e:lista712){
                                   U++;
                                   
                               }
                               U++;

                               
                               if(U==1){
                                   
                                   List<Empleado>lista7123=new ArrayList();
                                   Proyectos pro21 = new Proyectos (iden1,num_legaj1,Nombr1,mont1,flo1,lista7123);
                                   proyecto.CrearProyecto(pro21); 
                                   JOptionPane.showMessageDialog(null,"Se elimino al empleado del proyecto"); 
                               }else{
                                  for(Empleado e:lista712){
                                   
                                   if(e.getId()==idem1){
                                      
                                       lista712.remove(e);
                                   }
                                   
                                   
                               } 
                                   
                               Proyectos pro21 = new Proyectos (iden1,num_legaj1,Nombr1,mont1,flo1,lista712);
                               proyecto.CrearProyecto(pro21); 
                               JOptionPane.showMessageDialog(null,"Se elimino al empleado del proyecto");  
                               }
                               
                                   
                               }
                               else{
                                  JOptionPane.showMessageDialog(null,"El empleado no se encuentra registrado en el proyecto");  
                               }
                               }else{
                                   JOptionPane.showMessageDialog(null,"El empleado no existe"); 
                               }
                               
                               //aqui termina
                               
                               }else{
                                  JOptionPane.showMessageDialog(null,"El codigo del proyecto no se encuentra registrado"); 
                               }
                               
                               
                               
                               
                
                        }catch(java.lang.NumberFormatException e){
                                  JOptionPane.showMessageDialog(null,"Ingreso un carater cuando se esperaba un valor numerico"); 
                               }
                              
                               
                               
                               break;
                           case 6:
                               int y=0;
                               int p=0;
                               int ide2 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del proyecto"));
                               String Text="";
                               for(Proyectos pro1:proyecto.TrearProyecto()){
                                   if(pro1.getId()==ide2){
                                       for(Empleado em2:pro1.getListaempleado()){
                                           if(em2.getProyecto().equals(pro1)){
                                             Text+="******************************\n"
                                                 +"Nombre de empleado:"+em2.getNombre()+"\n";
                                           p++;  
                                           }
                                           
                                           
                                       }
                                       y++;
                                   }
                               }
                               if(Text==""){
                                   JOptionPane.showMessageDialog(null,"No se encuentra ningun empleado registrado");
                               }else{
                                   Text+="****************************************\nNumero de Empleados registrados:"+p;
                               JOptionPane.showMessageDialog(null,Text); 
                               }
                              
                               break;
                           case 7:
                               try{
                               int cont=0;
                               float ñ=0;
                               for(Proyectos pro1:proyecto.TrearProyecto()){
                                   ñ+=pro1.getMonto();
                                   cont++;
                               }
                               if(cont==0){
                                   JOptionPane.showMessageDialog(null,"No se encuenra ningun proyecto registrado");
                               }else{
                                    JOptionPane.showMessageDialog(null,"Monto Destinados a proyectos:"+ñ);
                               }
                              
                               }catch(java.lang.NumberFormatException e){
                                 JOptionPane.showMessageDialog(null,"Ingreso un carater cuando se esperaba un valor numerico");  
                               }
                               break;
                           case 8:
                               try{
                                   boolean na=false;
                                   int ya=0;
                                
                               for(Proyectos z:proyecto.TrearProyecto()){
                                   
                                   ya++;
                               }
                               if(ya==0){
                                   JOptionPane.showMessageDialog(null,"No se encuentra ningun proyecto resgitrado");   
                                   
                               
                               
                               }else{
                                   int ide3 =Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del proyecto"));
                               for(Proyectos z:proyecto.TrearProyecto()){
                                   if(ide3==z.getId()){
                                       na=true;
                                   }
                                   
                               }
                                   if(na==true){
                                      if(proyecto.calcularMontoIndividual(ide3)==0){
                                          JOptionPane.showMessageDialog(null,"No se encuenra ningun empleado resgitrado para calcular");
                                      }else{
                                          JOptionPane.showMessageDialog(null,"Monto que recive cada participante:"+proyecto.calcularMontoIndividual(ide3));
                                      }
                                       
                                   }else{
                                     JOptionPane.showMessageDialog(null,"El codigo de proyecto no se encuentra registrado");  
                                   }
                                   
                               }
                               
                               }catch(java.lang.NumberFormatException e){
                                  JOptionPane.showMessageDialog(null,"Ingreso un carater cuando se esperaba un valor numerico");  
                               }
                               break;
                           case 9:
                               try{
                               int año2=Integer.parseInt(JOptionPane.showInputDialog("FECHA INICIAL\nIngrese el año"));
                               int mes2=Integer.parseInt(JOptionPane.showInputDialog("FECHA INICIAL\nIngrese el mes"));
                               int dia2=Integer.parseInt(JOptionPane.showInputDialog("FECHA INICIAL\nIngrese el dia"));
                               calendar.set(año2,mes2,dia2);
                               Date fechaInicial=getDateCalendar();
                               int año3=Integer.parseInt(JOptionPane.showInputDialog("FECHA FINAL\nIngrese el año"));
                                int mes3=Integer.parseInt(JOptionPane.showInputDialog("FECHA FINAL\nIngrese el mes"));
                                int dia3=Integer.parseInt(JOptionPane.showInputDialog("FECHA FINAL\nIngrese el dia"));
                               calendar.set(año3,mes3,dia3);
                               Date fechaFinal=getDateCalendar();
                               
                               int añoDate,mesDate,diaDate;
                               String tete ="";
                               for(Proyectos e:proyecto.TrearProyecto()){
                                   añoDate=Integer.parseInt(año.format(e.getFechapreoyecto()));
                                   mesDate=Integer.parseInt(mes.format(e.getFechapreoyecto()));
                                   diaDate=Integer.parseInt(dia.format(e.getFechapreoyecto()));
                                   if (año2<añoDate&&añoDate<año3||año2==añoDate&&añoDate<año3||año2<añoDate&&añoDate==año3) {
                                       tete+="*************************************************\n"
                                           +"Nombre:"+e.getNombre()+"\n"
                                           +"Fecha de Proyecto:"+sdf.format(e.getFechapreoyecto())+"\n";;
                                   
                                   }else{
                                       if(año2==añoDate&&añoDate==año3){
                                           if(mes2<mesDate&&mesDate<mes3||mes2==mesDate&&mesDate<mes3||mes2<mesDate&&mesDate==mes3){
                                              tete+="*************************************************\n"
                                           +"Nombre:"+e.getNombre()+"\n"
                                           +"Fecha de Proyecto:"+sdf.format(e.getFechapreoyecto())+"\n";; 
                                           }else{
                                              if(mes2==mesDate&&mesDate==mes3){
                                                  if(dia2<diaDate&&diaDate<dia3||dia2==diaDate&&diaDate<dia3||dia2<diaDate&&diaDate==dia3){
                                                      tete+="*************************************************\n"
                                                     +"Nombre:"+e.getNombre()+"\n"
                                                     +"Fecha de Proyecto:"+sdf.format(e.getFechapreoyecto())+"\n";;
                                                  }else{
                                                      if(dia2==diaDate&&diaDate==dia3){
                                                          tete+="*************************************************\n"
                                                           +"Nombre:"+e.getNombre()+"\n"
                                                     +"Fecha de Proyecto:"+sdf.format(e.getFechapreoyecto())+"\n";; 
                                                      }else{
                                                          
                                                      }
                                                  }
                                              }else{
                                                  
                                              }
                                           }
                                       }else{
                                           
                                           //ya no entran
                                       }
                                        
                                   }
                               }
                               if(tete==""){
                                   JOptionPane.showMessageDialog(null,"No se encontro proyectos en el rango dado"); 
                               }else{
                                  JOptionPane.showMessageDialog(null,tete); 
                               }
                               
                               }catch(java.lang.NumberFormatException e){
                                    JOptionPane.showMessageDialog(null,"Ingreso un carater cunado se esperaba un valor numerico");  
                               }
                               break;
                               
                           case 10:
                               break;
                           default:
                                JOptionPane.showMessageDialog(null,"Elija una opcion exitente");
                               break;
                           
                           

                       }
                       
                       }catch(java.lang.NumberFormatException e){
                           JOptionPane.showMessageDialog(null,"Ingreso un carater cunado se esperaba un valor numerico"); 
                       }
                    } while (op3!=10);
                    break;
                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Elija una opcion exitente");
                    break;
            }
            }catch(java.lang.NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Ingreso un caracter cuando se esperaba un valor numerico"); 
            }
        } while (op!=3);
         
            
    }
    
    
}
