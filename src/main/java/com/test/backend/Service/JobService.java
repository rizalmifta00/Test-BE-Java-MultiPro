package com.test.backend.Service;

import com.test.backend.Dto.Job.JobDto;

import java.util.List;

public interface JobService {
    List<JobDto> GetJobs() throws Exception;

    JobDto GetJob(String id);
}
