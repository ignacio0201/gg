package com.codingdojo.productcategory.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productcategory.models.Category;
import com.codingdojo.productcategory.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
//	Encuentra el producto por el id
	Product findProductById(Long id);
	
	//Buscar productos que la categoria no contenga
	List<Product> findByCategoriesNotContains(Category category);

//    //Este método recupera todos los libros de la base de datos //select * from books
//    List<Book> findAll();
		
//    //Este método encuentra un libro por su descripción //where description = 
//    List<Book> findByDescriptionContaining(String search);
	
//    //Este método cuenta cuántos libros contiene cierta cadena en el título //count
//    Long countByTitleContaining(String search);
	
//    //Este método borra un libro que empieza con un título específico // delete where title =
//    Long deleteByTitleStartingWith(String search);
	
// 	  Este método recupera todas las personas sin licencia
//    List<Person> findByLicenseIsNull();
	
//    Encuentra una persona por el id
// 	  Optional<Person> findById(Long id);
	
//    Encuentra el dormitorio por el id
//    Dormitory findDormitoryById(Long id);
	
//    @Query (value="SELECT * FROM songs ORDER BY rating DESC LIMIT 10", nativeQuery=true)
//    List<Song> findTopTenByRatingDESC();
	
	
	
}
