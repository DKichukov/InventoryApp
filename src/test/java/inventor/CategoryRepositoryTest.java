package inventor;

import inventor.model.Category;
import inventor.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(value = false)
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository repo;

    @Test
    public void testCreateCategory(){
        Category savedCategory=repo.save(new Category("Electronics"));
        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}
