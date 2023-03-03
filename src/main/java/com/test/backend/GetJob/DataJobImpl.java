package com.test.backend.GetJob;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.backend.Dto.Job.JobDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DataJobImpl implements DataJob{
    @Override
    public List<JobDto> getJobs() throws Exception{
//        RestTemplate restTemplate = new RestTemplate();
//        String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(url, String.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        List<JobDto> resp = objectMapper.readValue(response.getBody(), new TypeReference<>(){
//        });
//        return resp;

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions.json";
        ResponseEntity<JobDto[]> response = restTemplate.getForEntity(url, JobDto[].class);
        JobDto[] jobs = response.getBody();
        List<JobDto> jobList = Arrays.asList(jobs);
        return jobList;
    }

    @Override
    public JobDto GetJobById(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions/{id}";
        JobDto job = restTemplate.getForObject(url, JobDto.class, id);
        return job;
    }

}
