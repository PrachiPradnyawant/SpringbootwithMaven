package com.dhanashri.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dhanashri.entity.Product;
import com.dhanashri.Exception.ProductAlreadyExistisException;
import com.dhanashri.Service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/save-product")
	public ResponseEntity<String> addCategory(@RequestBody @Validated Product product) {

		Boolean isAdded = service.addProduct(product);
		if (isAdded) {
			return new ResponseEntity<>("Saved!!!", HttpStatus.CREATED);
		} else {
			throw new ProductAlreadyExistisException("Prdouct Already Exists "+product.getProductName());
		}
	}

	@GetMapping("/get-product-by-id/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Product product = service.getProductById(id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/get-all-products")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> list = service.getAllProducts();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
	}

	@DeleteMapping("/delete-product")
	public ResponseEntity<Boolean> deleteProduct(@RequestParam Long id) {
		Boolean isDeleted = service.deleteProduct(id);
		if (isDeleted) {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.NO_CONTENT);

		}

	}

	@PutMapping("update-product")
	public ResponseEntity<Boolean> updateProduct(@RequestBody Product product) {
		Boolean isUpdated = service.updateProduct(product);
		if (isUpdated) {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.NO_CONTENT);

		}
	}

	@GetMapping("/sort-products/{sortBy}/{fieldName}")
	public ResponseEntity<List<Product>> sortProducts(@RequestParam("sortBy") String sortBy, @RequestParam("fieldName") String fieldName) {
		List<Product> list = service.sortProducts(sortBy, fieldName);
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/get-maxprice-products")
	public ResponseEntity<List<Product>> getMaxPriceProducts() {
		List<Product> list = service.getMaxPriceProducts();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Product>>(list, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/count-sumof-product-price")
	public ResponseEntity<Object> countSumOfProductPrice(){
		Double sumOfProductPrice = service.countSumOfProductPrice();
		
		if(sumOfProductPrice>0) {
			return ResponseEntity.ok(sumOfProductPrice);
		}else {
			return ResponseEntity.ok("Product Not Exists ");
		}
	}
	
	@GetMapping("/get-total-products-count")
	public ResponseEntity<Object> getTotalCountOfProducts(){
		Long productCount = service.getTotalCountOfProducts();
		
		if(productCount>0) {
			return ResponseEntity.ok(productCount);
		}else {
			return ResponseEntity.ok("Product Not Exists ");
		}
	}
	@PostMapping("/uploadExcelSheet")
	public ResponseEntity<String> uploadExcelSheet(@RequestParam("file") MultipartFile file)
	{
		String msg = service.uploadSheet(file);

		return ResponseEntity.ok(msg);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
