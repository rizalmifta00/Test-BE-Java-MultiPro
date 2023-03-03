package com.test.backend.Service.Impl;

import com.test.backend.Dto.Job.JobDto;
import com.test.backend.GetJob.DataJob;
import com.test.backend.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private DataJob dataJob;
    @Override
    public List<JobDto> GetJobs() throws Exception {
        return dataJob.getJobs();
    }

    @Override
    public JobDto GetJob(String id) {
        return dataJob.GetJobById(id);
    }
}
