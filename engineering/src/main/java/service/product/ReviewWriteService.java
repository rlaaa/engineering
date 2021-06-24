package service.product;

import org.springframework.beans.factory.annotation.Autowired;
import model.ReviewDTO;
import repository.ProductRepository;

public class ReviewWriteService {
	@Autowired
	ProductRepository productRepository;
	public void reviewWrite(String prodNo, String purchNo, String reviewContent) {
		ReviewDTO  dto = new ReviewDTO ();
		dto.setProdNo(prodNo);
		dto.setPurchNo(purchNo);
		dto.setReviewContent(reviewContent);
		productRepository.reviewWrite(dto);	
	}
}
