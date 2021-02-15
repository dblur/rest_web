package org.dblur.JarSoftTest.rest.service.bannerService;

import org.dblur.JarSoftTest.rest.model.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BannerServiceRestImpl implements BannerServiceRest {

    private final RestTemplate restTemplate;

    @Value("${central.server.url}")
    private String centralServerUrl;

    @Autowired
    public BannerServiceRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Banner> getAll() {
        ResponseEntity<?> responseEntity = restTemplate
                .getForEntity(centralServerUrl + "/allBanners", List.class);
        return (List<Banner>) responseEntity.getBody();
    }

    @Override
    public void add(Banner banner) {
        HttpEntity<Banner> httpEntity = new HttpEntity<>(banner);
        ResponseEntity<?> responseEntity = restTemplate
                .postForEntity(centralServerUrl + "/addBanner", httpEntity, Banner.class);
    }

    @Override
    public void delete(Long id) {
        restTemplate.getForEntity(centralServerUrl + "/deleteBanner/" + id, Banner.class);
    }

    @Override
    public void edit(Banner banner) {
        restTemplate.put(centralServerUrl + "/editBanner/", banner);
    }

    @Override
    public Banner getById(Long id) {
        ResponseEntity<Banner> responseEntity = restTemplate
                .getForEntity(centralServerUrl + "/banners/" + id, Banner.class);
        return responseEntity.getBody();
    }

    @Override
    public Banner isDeleted(boolean delete) {
        return null;
    }
}
