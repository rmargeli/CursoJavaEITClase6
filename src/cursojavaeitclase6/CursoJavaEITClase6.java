/*                          SQL
    Client(USR/PASS/PATH)-------> BD

ORM: Herramientas que mapean modelo de objetos y algebra relacional.(Hibernate, toplink)

DDL->Crean las estructuras de las BD.

DML:Guardar y modificar la información
DELETE
INSERT
UPDATE
SELECT

El codigo de java sirve para cualquier base se datos. Hay que instalarle el driver JDBC 
de la bd a la que me quiero conectar


*/
package cursojavaeitclase6;

import java.util.HashMap;
import java.util.Map;

public class CursoJavaEITClase6 {


    public static void main(String[] args) {
        Map<String,Persona> personasPorDni = new HashMap<>();
        personasPorDni.put("10", new Persona("10", "Juan"));
        personasPorDni.put("30", new Persona("30", "Carlos"));
        Persona p2 = new Persona("20", "Pedro");
        personasPorDni.put(p2.getDni(), p2);
        personasPorDni.put("10", p2);
        Persona x = personasPorDni.get("10");
        for(Persona p : personasPorDni.values())               //Values() Imprimir por valor
            System.out.println(p);
        for(String k : personasPorDni.keySet())                //KeySet()  Imprimir por clave
            System.out.println(k + ":" + personasPorDni.get(k));
        for(Map.Entry<String, Persona> e : personasPorDni.entrySet())  //EntrySet
            System.out.println(e.getKey() + ":" + e.getValue());
        personasPorDni.containsKey("20");                   //Boolean pregunta si contiene la clave
        personasPorDni.containsValue(p2);                   //Boolean pregunta si contiene value
        Persona x1 = personasPorDni.getOrDefault("30", new Persona ("30", "Jorge")); //Si no encuentra persona devuelve objeto que defaulteo+
        personasPorDni.remove("20");
        personasPorDni.putIfAbsent("40", p2);       //Lo agrega solamente si no existe la clave o el valor asociado a la clave es null(Devuelve el valor agregado o el que existe)
        
        
        
    }
    
}
