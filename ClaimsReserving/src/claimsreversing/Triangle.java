package claimsreversing;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@ToString
public class Triangle {

	@Getter
	private String product;
	@Getter
	private Integer originYear;;
	@Getter
	private List<Product> listOfProductsInTriangle;
}
