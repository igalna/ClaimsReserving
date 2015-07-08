package claimsreversing;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@ToString
public class TriangleOfPaymentFigures {

	@Getter
	private String productName;
	@Getter
	private Integer originYear;;
	@Getter
	private List<Product> listOfProductsInTriangle;

}
