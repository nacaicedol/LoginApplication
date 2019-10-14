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
 * @author NICOLAS
 */
public class PruebaRegistro {
    
        
    private static ValidarRegistro validarRegistro = new ValidarRegistro();
    
    private String LONG_NOMBRE_INCORRECTA = "No cumple con la Longitud del nombre el usuario";       
    private String LONG_PASSWORD_INCORRECTA = "No cumple con la longitud de la contraseña";       
    private String COINCIDENCIA_PASSWORD = "Las contraseñas no son iguales";
    private String NOMBRE_OCUPADO = "El nombre ya se encuentra ocupado";        
    private String USUARIO_AUTORIZADO = "Usuario registrado con exito";    
    
    public PruebaRegistro() {
    }
    
    @BeforeClass
    public static void setUpClass() {   
        
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
        assertEquals(validarRegistro.VerificarRegistro(u,"123456" ), LONG_NOMBRE_INCORRECTA);
        u.setNombre("Roberto");
        u.setPassword("123456");
        assertEquals(validarRegistro.VerificarRegistro(u,"123456" ), LONG_NOMBRE_INCORRECTA);
    }
    
    @Test
    public void testLongitudContrasenia(){
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("12");
        assertEquals(validarRegistro.VerificarRegistro(u,"12"), LONG_PASSWORD_INCORRECTA);
    
        u.setNombre("Pepe");
        u.setPassword("123456");
        assertEquals(validarRegistro.VerificarRegistro(u,"123456"), LONG_PASSWORD_INCORRECTA);
    }
    
    @Test
    public void testcoincidenciaContraseña(){
        Usuario u = new Usuario();
        u.setNombre("Pepe");
        u.setPassword("1245");
        assertEquals(validarRegistro.VerificarRegistro(u,"123456"), COINCIDENCIA_PASSWORD);
    }
    
    @Test
    public void disponibilidadNombre(){
        Usuario u = new Usuario();
        u.setNombre("Juan");
        u.setPassword("1234");
        assertEquals(validarRegistro.VerificarRegistro(u,"1234"), NOMBRE_OCUPADO);
    }
    @Test
    public void testTodoCorrecto(){
        Usuario u = new Usuario();
        u.setNombre("Paco");
        u.setPassword("2345");
        assertEquals(validarRegistro.VerificarRegistro(u,"2345"), USUARIO_AUTORIZADO);

    }
}
