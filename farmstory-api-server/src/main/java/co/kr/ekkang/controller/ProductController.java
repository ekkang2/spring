package co.kr.ekkang.controller;

import co.kr.ekkang.dto.PageRequestDTO;
import co.kr.ekkang.dto.PageResponseDTO;
import co.kr.ekkang.dto.ProductDTO;
import co.kr.ekkang.service.ProductService;
import co.kr.ekkang.util.CustomFileUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;
    private final CustomFileUtil customFileUtil;

    @GetMapping("/product/{pg}")
    public PageResponseDTO<ProductDTO> list(PageRequestDTO pageRequestDTO) {

        PageResponseDTO<ProductDTO> pageResponseDTO = productService.list(pageRequestDTO);
        log.info(pageResponseDTO);

        return pageResponseDTO;
    }

    // 이미지 뿌릴때 처리
    @GetMapping("/product/thumb/{fileName}")
    public ResponseEntity<Resource> thumbnail(@PathVariable String fileName) {
        return customFileUtil.getFile(fileName);
    }


    @PostMapping("/product")
    public Map<String, Integer> register(ProductDTO productDTO) {

        log.info("productDTO : " + productDTO);

        List<MultipartFile> files = productDTO.getThumbFiles();

        // 파일 저장
        Map<String, String> uploadFileNames = customFileUtil.saveFiles(files);

        productDTO.setThumbNames(uploadFileNames);

        // 상품 저장
        int pno = productService.register(productDTO);

        return Map.of("pno", pno);

    }



}
