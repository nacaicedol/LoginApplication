/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usuario
 */
public class PruebaLogin {
    
    private static ValidarLogin validarLogin = new ValidarLogin();
    
    private String LONG_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";       
    private String LONG_PASSWORD_INCORRECTA = "Longitud contrasenia incorrecta";       
    private String DATOS_INCORRECTOS = "Datos incorrectos";       
    private String USUARIO_AUTORIZADO = "Bienvenidos";       
    
    public PruebaLogin() {
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception{
    
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
   
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
    
    sistema.setUsuarios(usuarios);
           
        for (Usuario u : sistema.getUsuarios()) {
            System.out.println(u.getNombre());
            System.out.println(u.getPassword());
            System.out.println("--------------");
            
        }
        
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
    public void testLongitudNombre(){
        Usuario u = new Usuario();
        u.setNombre("R");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void testLongitudContrasenia(){
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
    
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarLogin.verificarLogin(u), LONG_PASSWORD_INCORRECTA);
    }

    @Test
    public void testNombre(){
        Usuario u = new Usuario();
        u.setNombre("Henry");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void testContrasenia(){
        Usuario u = new Usuario();
        u.setNombre("maria");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);    
    }
    
    @Test 
    public void testDatos(){

    Usuario u = new Usuario();
    u.setNombre("Henry");
    u.setPassword("A234");
        assertEquals(validarLogin.verificarLogin(u), DATOS_INCORRECTOS);
    }
    
    @Test
    public void testTodoCorrecto(){
        Usuario u = new Usuario();
        
        u.setNombre("Juan");
        u.setPassword("1234");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
        
        u.setNombre("Pedro");
        u.setPassword("123");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
        
        u.setNombre("Maria");
        u.setPassword("12345");
        assertEquals(validarLogin.verificarLogin(u), USUARIO_AUTORIZADO);
    }
    
}



