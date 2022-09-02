package alphasabawu.co.zw.fleetapp.services;


import alphasabawu.co.zw.fleetapp.models.State;
import alphasabawu.co.zw.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;
    // Get States
    public List<State> getStates(){
        return stateRepository.findAll();
    }
     // Add States
    public void saveState(State state){
        stateRepository.save(state);
    }

    public Optional<State> getStateByID(int id) {
        return stateRepository.findById(id);
    }

    public void removeState(Integer id) {
        stateRepository.deleteById(id);
    }
}
