/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.UsuarioDAO;
import Entidad.Usuario;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 *
 * @author usuario
 */
public class Inicializacion {
    
    public Inicializacion() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void initData(){
        
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
   UsuarioDAO dao = new UsuarioDAO();
    // Creacion usuarios
    Usuario a = new Usuario();
    Usuario b = new Usuario();
    Usuario c = new Usuario();
    
    //Datos
    
    a.setNombre("Juan");
    a.setPassword("1234");
    b.setNombre("Pedro");
    b.setPassword("123");
    c.setNombre("Maria");
    c.setPassword("12345");
    
    usuarios.add(a);
    usuarios.add(b);
    usuarios.add(c);
    
   // sistema.setUsuarios(usuarios);
           
     //   for (Usuario u : sistema.getUsuarios()) {
       for(Usuario u: usuarios){
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("--------------");
            dao.crear(u);
        }
        
    }
    
}
