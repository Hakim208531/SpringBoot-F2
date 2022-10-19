package be.iesca.ebar;

import be.iesca.ebar.dao.BiereDao;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TestBiereDao {
    @Autowired
    BiereDao biereDao;

    @Test
    public void testTableBieresContientLes8Bieres() {
        assertEquals(8,biereDao.count());
        assertEquals("Chimay Rouge",biereDao.findByNom("Chimay Rouge").get().getNom());
        assertEquals("Floreffe Blonde",biereDao.findByNom("Floreffe Blonde").get().getNom());
        assertEquals("Blanche de Hoegaarden",biereDao.findByNom("Blanche de Hoegaarden").get().getNom());
        assertEquals("Chimay Bleue",biereDao.findByNom("Chimay Bleue").get().getNom());
        assertEquals("Floreffe Triple",biereDao.findByNom("Floreffe Triple").get().getNom());
        assertEquals("Blanche De Bruxelles",biereDao.findByNom("Blanche De Bruxelles").get().getNom());
        assertEquals("Bush Blonde",biereDao.findByNom("Bush Blonde").get().getNom());
        assertEquals("Bush",biereDao.findByNom("Bush").get().getNom());
    }
}
