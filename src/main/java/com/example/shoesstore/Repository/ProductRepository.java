package com.example.shoesstore.Repository;

import com.example.shoesstore.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query(value = "Select * from Product order by id desc limit :number",nativeQuery = true)
//    List<Product> getListNewest(int number);
//
    @Query(value = "Select * from Product order by pro_date desc limit 10 ",nativeQuery = true)
    List<Product> getListByDate();
    @Query(value = "Select * from Product where pro_hot = 1 limit 10 ",nativeQuery = true)
    List<Product> getListHot();

    @Query(value = "Select * from Product where pro_basis_price > 0 limit 10 ",nativeQuery = true)
    List<Product> getListSale();
//
//    @Query(value ="Select * from Product where category_id = :id order by rand() limit 4",nativeQuery = true)
//    List<Product> findRelatedProduct(long id);
//
    @Query(value ="Select * from Product where cate_Id = :id",nativeQuery = true)
    List<Product> getListProductByCategory(long id);

    @Query(value ="Select * from Product where bra_Id = :id",nativeQuery = true)
    List<Product> getListProductByBrand(long id);
//
//    @Query(value = "Select * from Product where cate_Id = :id and pro_price between :min and :max",nativeQuery = true)
//    List<Product> getListProductByPriceRange(long id,int min,int max);
//
    @Query(value= "Select p from Product p where p.proName like %:keyword% order by p.proPrice desc")
    List<Product> searchProduct(String keyword);

}
