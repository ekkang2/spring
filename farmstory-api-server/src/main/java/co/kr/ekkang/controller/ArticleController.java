package co.kr.ekkang.controller;

import co.kr.ekkang.dto.ArticleDTO;
import co.kr.ekkang.dto.PageRequestDTO;
import co.kr.ekkang.dto.PageResponseDTO;
import co.kr.ekkang.entity.Article;
import co.kr.ekkang.service.ArticleService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;

    // 게시판 목록
    @GetMapping("/article/{cate}/{pg}")
    public PageResponseDTO list(PageRequestDTO pageRequestDTO) {

        PageResponseDTO pageResponseDTO = articleService.findAll(pageRequestDTO);

        return pageResponseDTO;
    }


    // 게시판 등록
    @PostMapping("/article")
    public ResponseEntity write(@RequestBody ArticleDTO articleDTO, HttpServletRequest req) {

        log.info("articleDTO : " + articleDTO);

        articleDTO.setRegIp(req.getRemoteAddr());
        int no = articleService.save(articleDTO);

        return ResponseEntity
                .ok()
                .body(no);
    }
}
