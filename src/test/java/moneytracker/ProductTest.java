package moneytracker;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.moneytracker.dao.ProductDao;
import com.revature.moneytracker.model.Product;

public class ProductTest {

	  private static ProductDao mockProductDao;
	  private static Product product1;
	  private static Product product2;
	  //current uid
	  static int uid = 1;

	  @BeforeClass
	  public static void setUp(){
		 	  
	    //Create mock object of productDao
		  mockProductDao = mock(ProductDao.class);

	    //Create few instances of Product class.
		  product1 = new Product(1, uid, "Burger", "Food", "11/22/2020", 10);
		  product2 = new Product(2, uid, "Coffee", "Food", "11/22/2020", 5);

		//Stubbing the methods of mocked BookDAL with mocked data. 
		 when(mockProductDao.getAllProduct(uid)).thenReturn(new ArrayList<>(Arrays.asList(product1, product2)));

		 when(mockProductDao.insertProduct(uid, "Burger", "Food", "11/22/2020", 10)).thenReturn(product1);
		 
	  }

	  @Test
	  public void testGetAllProduct() throws Exception {
		  
	    ArrayList<Product> productList = mockProductDao.getAllProduct(uid);
	    
	    assertEquals(2, productList.size());
	    
	    Product product2 = productList.get(1);
	    
	    assertEquals(5, product2.getAmount());
	    
	    assertEquals("Coffee", product2.getTitle());
	    
	  }

	  @Test
	  public void testAddProduct(){
		
		//insert product1
	    Product inserted = mockProductDao.insertProduct(uid, "Burger", "Food", "11/22/2020", 10);

	    //assert
	    assertEquals(inserted.getAmount(), product1.getAmount());
	    
	  }

}
