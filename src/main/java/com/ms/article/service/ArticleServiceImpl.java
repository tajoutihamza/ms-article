package com.ms.article.service;


import com.ms.article.dto.ArticleDto;
import com.ms.article.dto.DtoArticle;
import com.ms.article.dto.StockDto;
import com.ms.article.feign.StockClient;
import com.ms.article.model.Article;
import com.ms.article.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements IArticleService {

    private final ArticleRepository articleRepository;
    private final StockClient stockClient;
    private final StockService stockService;

    public ArticleServiceImpl(ArticleRepository articleRepository, StockClient stockClient, StockService stockService) {
        this.articleRepository = articleRepository;
        this.stockClient = stockClient;
        this.stockService = stockService;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findById(Long id) {
        return articleRepository.findById(id);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public ArticleDto getArticleWithStockInfo(Long id) {
        Optional<Article> articleOpt = articleRepository.findById(id);
        if (articleOpt.isPresent()) {
            Article article = articleOpt.get();
            StockDto stockDTO = stockClient.getStockById(article.getStockId());
            ArticleDto responseDTO = new ArticleDto();
            responseDTO.setName(article.getName());
            responseDTO.setQuantity(article.getQuantity());
            responseDTO.setStockZone(stockDTO.getZone());
            return responseDTO;
        } else {
            return null; // or throw an exception
        }
    }
    @Override
    public DtoArticle getArticleWithStockDto(Long id) {
        Optional<Article> articleOpt = articleRepository.findById(id);
        if (articleOpt.isPresent()) {
            Article article = articleOpt.get();
            StockDto stockDTO = stockService.getStockById(article.getStockId());
            DtoArticle responseDTO = new DtoArticle();
            responseDTO.setName(article.getName());
            responseDTO.setQuantity(article.getQuantity());
            responseDTO.setStockDto(stockDTO);
            return responseDTO;
        } else {
            return null; // or throw an exception
        }
    }
}

