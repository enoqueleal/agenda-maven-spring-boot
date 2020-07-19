package com.agenda.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.agenda.configuration.EnvironmentConfiguration;
import com.agenda.model.Line;

@Service
public class SPTransService {

	private HttpEntity<String> httpEntity;
	private EnvironmentConfiguration env;
	private RestTemplate restTemplate;

	public SPTransService(EnvironmentConfiguration env, RestTemplateBuilder builder) {
		this.env = env;
		this.restTemplate = builder.build();
	}

	public List<Line> getLines(String parameter) {
		
		httpEntity = getHttpEntity();

		String uri = env.getUrl() + "Linha/Buscar?termosBusca=" + parameter;
		
		ResponseEntity<List<Line>> exchange = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, new ParameterizedTypeReference<List<Line>>() {});

		return exchange.getBody();

	}

	private HttpEntity<String> getHttpEntity() {

		String uri = env.getUrl() + "Login/Autenticar?token=" + env.getToken();

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(uri, null, String.class);

		List<String> headersItens = responseEntity.getHeaders().get("Set-Cookie");

		HttpHeaders headers = new HttpHeaders();

		for (String item : headersItens) {
			String cookieValue = item.substring(15, 407);
			headers.set("apiCredentials", cookieValue);
			break;
		}

		return new HttpEntity<String>(headers);

	}

}
