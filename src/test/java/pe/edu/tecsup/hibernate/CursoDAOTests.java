package pe.edu.tecsup.hibernate;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.hibernate.dao.CursoDAO;
import pe.edu.tecsup.hibernate.model.Curso;
import pe.edu.tecsup.hibernate.model.Programa;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CursoDAOTests {

    @Autowired
    CursoDAO cursoDAO;

    @Test    
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getId());
            System.out.println(curso.getCodigo());
            System.out.println(curso.getNombre());

        }
        Assert.assertTrue(cursos.size() > 0);
    }
    
     // @Test
    public void verifyFind() {
        Curso curso = cursoDAO.get(73l);
        System.out.println(curso.getNombre());
        Assert.assertTrue(curso.getId() == 73l);
    }

     //  @Test
        public void verifySave() {
        Curso curso = new Curso();
        curso.setCodigo("1030");
        curso.setNombre("Nuevo curso jose luis2");
        ///curso.setDescripcion("......");

        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }
 
    // @Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso curso = new Curso();
        curso.setId(55l);
        curso.setCodigo("1020");
        curso.setNombre("curso Modificado por jose luis alca");

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(55l).getCodigo().equals("1020"));
    }     

       @Test
    public void verifyDelete() {

        Curso curso = new Curso();
        curso.setId(63l);
        cursoDAO.delete(curso);

        Assert.assertTrue(cursoDAO.get(63l) == null);
    }
    
    
}
