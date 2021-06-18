package service.product;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import model.ProductDTO;
import repository.ProductRepository;

public class ProductDeleteService {
	@Autowired
	ProductRepository productRepository;
	public void prodDel(String prodNo, HttpSession session) {
		//// 컴퓨터 파일 경로 내에 저장된 이미지 파일 삭제
		ProductDTO dto = productRepository.prodInfo(prodNo);
		String [] files = dto.getProdImage().split(",");
		String path = "WEB-INF/view/product/upload";
		String realPath = session.getServletContext().getRealPath(path);
		// ...\engineering\WEB-INF\view\product\ upload : 이 주소를 가져옴
		System.out.println(realPath);
		if(files.length > 0) {
			for(String fileName : files) {
				// 파일 경로 가져오기
				String filePath = realPath + "/" + fileName;
				// 파일 객체 생성
				File f = new File(filePath);
				// 파일 삭제
				if(f.exists()) f.delete();
			}
		}
		productRepository.prodDel(prodNo);
		//// DB 내용만 삭제되고, 파일 내에 이미지 파일은 삭제가 안 됨.
	}
}
