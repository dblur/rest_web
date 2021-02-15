package org.dblur.JarSoftTest.rest.service.categoryService;

import org.dblur.JarSoftTest.rest.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CategoryServiceRestImpl implements CategoryServiceRest {

    private final RestTemplate restTemplate;

    @Value("${central.server.url}")
    private String centralServerUrl;

    @Autowired
    public CategoryServiceRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Category> getAll() {
        ResponseEntity<?> responseEntity = restTemplate
                .getForEntity(centralServerUrl + "/allCategories", List.class);
        return (List<Category>) responseEntity.getBody();
    }

    @Override
    public void add(Category category) {
        HttpEntity<Category> httpEntity = new HttpEntity<>(category);
        ResponseEntity<?> responseEntity = restTemplate
                .postForEntity(centralServerUrl + "/addCategory", httpEntity, Category.class);
    }

    @Override
    public void delete(Long id) {
        restTemplate.getForEntity(centralServerUrl + "/deleteCategory/" + id, Category.class);
    }

    @Override
    public void edit(Long id) {
        restTemplate.getForEntity(centralServerUrl + "/editCategory/" + id, Category.class);
    }

    @Override
    public Category getById(Long id) {
        ResponseEntity<Category> responseEntity = restTemplate
                .getForEntity(centralServerUrl + "/categories/" + id, Category.class);
        return responseEntity.getBody();
    }

    @Override
    public Category isDeleted(boolean delete) {
        return null;
    }
}

