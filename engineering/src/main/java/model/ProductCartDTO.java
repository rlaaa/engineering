package model;

public class ProductCartDTO {
	ProductDTO productDTO;
	CartDTO cartDTO;
	/// productDTO, cartDTO : property 드
	/// 타이어랑 같은 원리...
	/// membId에 해당되는 prodNo를 하나씩 받아옴
	/// 1:1로 받아옴
	/// Alt +Shift +S +R
	public ProductDTO getProductDTO() {
		return productDTO;
	}
	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}
	public CartDTO getCartDTO() {
		return cartDTO;
	}
	public void setCartDTO(CartDTO cartDTO) {
		this.cartDTO = cartDTO;
	}
}
