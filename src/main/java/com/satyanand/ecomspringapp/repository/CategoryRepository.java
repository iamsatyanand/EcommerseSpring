package com.satyanand.ecomspringapp.repository;

import com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO;
import com.satyanand.ecomspringapp.dto.response.projection.CategorySummaryProjectionDTO;
import com.satyanand.ecomspringapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("""
            select new com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO(
                c.id, c.name, count(p), c.createdAt, c.updatedAt
            )
            from Category c left join c.products p
            group by c.id, c.name, c.createdAt, c.updatedAt
""")
    public List<CategoryResponseDTO> getAllCategoriesWithProducts();

    @Query("""
        select new com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO(
            c.id, c.name, count(p), c.createdAt, c.updatedAt
        )
        from Category c left join c.products p where c.id = :id
        group by c.id, c.name, c.createdAt, c.updatedAt
""")
    Optional<CategoryResponseDTO> findByIdWithProductCount(@Param("id") Long id);

    @Query("""
    select new com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO(
        c.id, c.name, count(p), c.createdAt, c.updatedAt
    )
    from Category c left join c.products p where lower(c.name) = lower(:name)
    group by c.id, c.name, c.createdAt, c.updatedAt
""")
    Optional<CategoryResponseDTO> findByNameWithProductCount(String name);

    @Query("""
    select new com.satyanand.ecomspringapp.dto.response.CategoryResponseDTO(
        c.id, c.name, count(p), c.createdAt, c.updatedAt
    )
    from Category  c left join c.products p where lower(c.name) like lower(concat('%', :keyword, '%'))
    group by c.id, c.name, c.createdAt, c.updatedAt
""")
    List<CategoryResponseDTO> searchWithProductCount(@Param("keyword") String keyword);

    List<CategorySummaryProjectionDTO> findAllBy();


}
