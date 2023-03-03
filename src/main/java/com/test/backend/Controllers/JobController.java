package com.test.backend.Controllers;

import com.test.backend.Dto.Job.JobDto;
import com.test.backend.Dto.ResponseDto;
import com.test.backend.Service.JobService;
import com.test.backend.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<JobDto>>> getAllJob() throws Exception{
        try{
            ResponseDto<List<JobDto>> response =
                    ResponseUtil.responseDtoSucces(jobService.GetJobs(),"success");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }catch (Exception e){
            ResponseDto<List<JobDto>> response =
                    ResponseUtil.responseDtoFailed(null,e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<JobDto>> getJob(@PathVariable(value = "id") String id){
        try{
            ResponseDto<JobDto> response =
                    ResponseUtil.responseDtoSucces(jobService.GetJob(id),"success");
            return new ResponseEntity<>(response,HttpStatus.OK);

        }catch (Exception e){
            ResponseDto<JobDto> response =
                    ResponseUtil.responseDtoFailed(null,e.getMessage(),HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
    }

}
