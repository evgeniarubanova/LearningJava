package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.dao.interfaces.LogbookDao;
import shop.entities.Logbook;
import shop.repositories.LogbookRepository;

@Service
public class LogbookDaoDataJpa implements LogbookDao {

    private LogbookRepository logbookRepository;

    @Autowired
    public void setLogbookRepository(LogbookRepository logbookRepository) {
        this.logbookRepository = logbookRepository;
    }

    public LogbookDaoDataJpa() {}

    @Override
    public Logbook addNote(Logbook note) {
        return logbookRepository.save(note);
    }

//    @Override
//    public Map<Integer, Integer> getPurchaseProducts(Integer purchaseID) {
//        Map<Integer, Integer> res = new HashMap<>();
//        logbookRepository.findAll()
//        return null;
//    }
}
