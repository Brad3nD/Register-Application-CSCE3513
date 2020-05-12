/*package edu.uark.registerapp.commands.products;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uark.registerapp.commands.ResultCommandInterface;
import edu.uark.registerapp.commands.exceptions.UnprocessableEntityException;
import edu.uark.registerapp.models.api.Product;
import edu.uark.registerapp.models.entities.ProductEntity;
import edu.uark.registerapp.models.repositories.ProductRepository;

@Service
public class ProductByPartialLookupCodeQuery implements ResultCommandInterface<Product> {
	@Override
	public Product[] execute() {
		this.validateProperties();

    List<Product> products = new LinkedList<Products>();
		final List<ProductEntity> productEntity =
			this.productRepository.findByLookupCodeContainingIgnoreCase(
        this.partiallookupCode);

    for(ProductEntity productEntity : productEntities){
      products.add(new Product(productEntity));
    }

    return (Product[])products.toArray();
	}

	// Helper methods
	private void validateProperties() {
		if (StringUtils.isBlank(this.partiallookupCode)) {
			throw new UnprocessableEntityException("partiallookupCode");
		}
	}

	// Properties
	private String partiallookupCode;
	public String getPartialLookupCode() {
		return this.partiallookupCode;
	}
	public ProductByPartialLookupCodeQuery setPartialLookupCode(final String partiallookupCode) {
		this.partiallookupCode = partiallookupCode;
		return this;
	}

	@Autowired
	private ProductRepository productRepository;
}
*/
