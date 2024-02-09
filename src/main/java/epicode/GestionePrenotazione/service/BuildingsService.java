package epicode.GestionePrenotazione.service;

import epicode.GestionePrenotazione.DAO.BuildingsDAO;
import epicode.GestionePrenotazione.entities.Building;
import epicode.GestionePrenotazione.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuildingsService  {
    @Autowired
    private BuildingsDAO buildingsDAO;

    public void saveBuilding(Building newBuilding){
        if(this.existsByAddress(newBuilding.getAddress())){
            throw new RuntimeException("Building with address: " + newBuilding.getAddress() + " exists already.");
        }else {
            buildingsDAO.save(newBuilding);
            log.info("Building Saved.");
        }
    }

    public Building findById(int buildingId) throws ItemNotFoundException {
        return buildingsDAO.findById(buildingId).orElseThrow(()-> new ItemNotFoundException(buildingId));
    }

    public void findByIdAndUpdate(int buildingId, Building updatedBuilding){
        Building found = this.findById(buildingId);
        found.setAddress(updatedBuilding.getAddress());
        found.setCity(updatedBuilding.getCity());
        found.setName(updatedBuilding.getName());
        buildingsDAO.save(found);
        log.info("The building has been updated");
    }
    public void findByIdAndDelete(int buildingId) {
        Building found = this.findById(buildingId);
        buildingsDAO.delete(found);
        log.info("L'utente con l'id " + buildingId + " è stato cancellato correttamente!");
    }


    public boolean existsByAddress(String address){return buildingsDAO.existsByAddress(address);}
}
