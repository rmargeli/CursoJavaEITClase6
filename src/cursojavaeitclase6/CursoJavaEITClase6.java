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

CLASE 7

MAVEN
JTA: Administra transacciones en JAVA.

BD

Rollback: En caso de que falle alguna acción, vuelve para atrás
Commit: La operación fue exitosa y guarda los cambios.

Objetos de BD ->1. Table
              ->2. View
              ->3. Procedure

select emp_no, first_name, last_name FROM employees;

select * from employees where emp_no <= 10008;

select * from employees where last_name = 'Erde';

select * from employees where gender = 'F';

select * from employees where last_name like '%o%';

select * from employees where emp_no > 10100 and emp_no < 10150;

select * from employees order by first_name;

select * from employees order by first_name desc, last_name;

insert into employees(emp_no, birth_date, first_name, last_name, gender, hire_date)
VALUES(-9000, '1992-05-09', 'Ramiro', 'Margeli', 'M', '2017-06-10');

UPDATE employees SET birth_date = '2017-06-09' 
where emp_no = -9000; 

select MAX(salary) from salaries;

select MIN(salary) from salaries;

select SUM(salary) from salaries;

select LENGTH(first_name) from employees;

select LOWER(first_name) from employees;

select upper(first_name) from employees;

select upper(first_name) AS name,
		now() AS _date
from employees;

select * from employees limit 1;

SELECT * FROM salaries
WHERE salary BETWEEN 70000 AND 89000;

SELECT e.*, t.* FROM employees e
INNER JOIN titles t  ON e.emp_no = t.emp_no;

SELECT e.*, s.* FROM employees e
JOIN salaries s ON e.emp_no = s.emp_no;

TRY{
    INSERT
    COMMIT
}
CATCH{
    ROLL BACK
}


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
