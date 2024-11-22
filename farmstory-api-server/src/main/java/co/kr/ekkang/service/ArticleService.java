package co.kr.ekkang.service;

import co.kr.ekkang.dto.ArticleDTO;
import co.kr.ekkang.dto.PageRequestDTO;
import co.kr.ekkang.dto.PageResponseDTO;
import co.kr.ekkang.entity.Article;
import co.kr.ekkang.entity.User;
import co.kr.ekkang.repository.ArticleRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;

    // 게시판 목록
    public PageResponseDTO findAll(PageRequestDTO pageRequestDTO) {

        Pageable pageable = pageRequestDTO.getPageable("no");

        Page<Article> pageArticle = articleRepository.findAllByCate(pageRequestDTO.getCate(), pageable);;

        // 엔티티 리스트를 DTO 리스트 변환
        List<ArticleDTO> articleList = pageArticle.getContent().stream()
                .map(entity -> {
                    ArticleDTO articleDTO = modelMapper.map(entity, ArticleDTO.class);
                    articleDTO.setWriter(entity.getUser().getNick());
                    return articleDTO;
            }).toList();

        int total = (int) pageArticle.getTotalElements();

        return PageResponseDTO.<ArticleDTO>builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(articleList)
                .total(total)
                .build();
    }

    // 게시판 등록
    public int save(ArticleDTO articleDTO) {

        Article article = modelMapper.map(articleDTO, Article.class);

        User user = User.builder()
                        .uid(articleDTO.getWriter())
                        .build();

        article.setUser(user);

        Article savedArticle = articleRepository.save(article);

        return savedArticle.getNo();
    }

}
