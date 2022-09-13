package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.JobTitle;
import alphasabawu.co.zw.fleetapp.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;

    // Return a list countries
    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    }


    // Save new country
    public  void saveJobTitle(JobTitle JobTitle){
        jobTitleRepository.save(JobTitle);
        // return ;
    }

    // Get country by ID
    public Optional<JobTitle> getJobTitleByID(int JobTitleId){
        return jobTitleRepository.findById(JobTitleId);
    }


    public void removeJobTitle(Integer id) {
        jobTitleRepository.deleteById(id);
    }
}
