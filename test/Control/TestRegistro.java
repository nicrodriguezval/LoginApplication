/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Entidad.Usuario;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;

/**
 *
 * @author Samuel y Valeria
 */
public class TestRegistro {
    private static ValidarRegistro validar = new ValidarRegistro();
    
    private String LONGITUD_NOMBRE_INCORRECTA = "Longitud nombre incorrecta";
    private String LONGITUD_PASSWORD_INCORRECTA = "Longitud contraseña incorrecta";
    private String EQUAL_PASSWORD = "Las contraseñas no coinciden";
    private String EQUAL_USERNAMES = "El nombre de usuario ya existe";
    private String REGISTRO_EXITOSO = "Registro exitoso";
    
    public TestRegistro() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        
        Usuario a = new Usuario();
        Usuario b = new Usuario();
        Usuario c = new Usuario();
        
        a.setNombre("juan");
        a.setPassword("1234");
        b.setNombre("pedro");
        b.setPassword("123");
        c.setNombre("maria");
        c.setPassword("12345");
        
        usuarios.add(a);
        usuarios.add(b);
        usuarios.add(c);
        
        sistema.setUsuarios(usuarios);
        
        for(Usuario u : sistema.getUsuarios()) {
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
    public void testLongitudNombre() {
        Usuario u = new Usuario();
        u.setNombre("Nicolas");
        u.setPassword("12345");
        String validarContrasenia = "12345";
        assertEquals(LONGITUD_NOMBRE_INCORRECTA, validar.verificar(u, validarContrasenia));
        
        u.setNombre("L");
        u.setPassword("1111");
        validarContrasenia = "1111";
        assertEquals(LONGITUD_NOMBRE_INCORRECTA, validar.verificar(u, validarContrasenia));
    }
    
    @Test
    public void testLongitudPassword() {
        Usuario u = new Usuario();
        u.setNombre("pacho");
        u.setPassword("123654");
        String validarContrasenia = "123654";
        assertEquals(LONGITUD_PASSWORD_INCORRECTA, validar.verificar(u, validarContrasenia));
        
        u.setNombre("Andres");
        u.setPassword("A1");
        validarContrasenia = "A1";
        assertEquals(LONGITUD_PASSWORD_INCORRECTA, validar.verificar(u, validarContrasenia));
    }
    
    @Test
    public void testEqualPassword() {
        Usuario u = new Usuario();
        u.setNombre("pablo");
        u.setPassword("54321");
        String validarContrasenia = "12345";
        assertEquals(EQUAL_PASSWORD, validar.verificar(u, validarContrasenia));
        
        u.setNombre("Perez");
        u.setPassword("1000");
        validarContrasenia = "100";
        assertEquals(EQUAL_PASSWORD, validar.verificar(u, validarContrasenia));
    }
    
    @Test
    public void testEqualUsernames() {
        Usuario u = new Usuario();
        u.setNombre("juan");
        u.setPassword("B2222");
        String validarContrasenia = "B2222";
        assertEquals(EQUAL_USERNAMES, validar.verificar(u, validarContrasenia));
        
        u.setNombre("maria");
        u.setPassword("1212");
        validarContrasenia = "1212";
        assertEquals(EQUAL_USERNAMES, validar.verificar(u, validarContrasenia));
    }
    
    @Test
    public void testRegistroExitoso() {
        Usuario u = new Usuario();
        u.setNombre("Nico");
        u.setPassword("4455");
        String validarContrasenia = "4455";
        assertEquals(REGISTRO_EXITOSO, validar.verificar(u, validarContrasenia));
        
        u.setNombre("lucas");
        u.setPassword("1234");
        validarContrasenia = "1234";
        assertEquals(REGISTRO_EXITOSO, validar.verificar(u, validarContrasenia));
    }
}
