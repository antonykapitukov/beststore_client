package com.beststore.restclient.services;

import com.beststore.restclient.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final WebClient webClient;

    public List<Product> getAllProducts() {
        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class)
                .collectList()
                .block();
    }

    public Product getProductById(int id) {
        return webClient.get()
                .uri("/product/{id}", id)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    public Product createProduct(Product product) {
        return webClient.post()
                .uri("/products")
                .body(Mono.just(product), Product.class)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    public Product updateProduct(int id, Product product) {
        return webClient.put()
                .uri("/product/{id}", id)
                .body(Mono.just(product), Product.class)
                .retrieve()
                .bodyToMono(Product.class)
                .block();
    }

    public void deleteProduct(int id) {
        webClient.delete()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
