package com.test.backend.GetJob;

import com.test.backend.Dto.Job.JobDto;

import java.util.List;

public interface DataJob {
   List<JobDto> getJobs() throws Exception;

   JobDto GetJobById(String id);

}
