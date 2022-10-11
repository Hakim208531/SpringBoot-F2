package be.iesca.ebar;

import be.iesca.ebar.dao.BiereDao;
import static org.junit.jupiter.api.Assertions.*;

import be.iesca.ebar.domaine.Biere;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestsBiereDao {
    @Autowired
    BiereDao biereDao;

    @Test
    public void testTableBieresContientLes8Bieres() {
        System.out.println(biereDao);
        assertEquals("8",biereDao);
    }
}
