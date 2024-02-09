package epicode.GestionePrenotazione.service;

import epicode.GestionePrenotazione.DAO.BuildingsDAO;
import epicode.GestionePrenotazione.DAO.ReservationsDAO;
import epicode.GestionePrenotazione.DAO.StationsDAO;
import epicode.GestionePrenotazione.entities.Station;
import epicode.GestionePrenotazione.exceptions.ItemNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StationsService {
    @Autowired
    private StationsDAO stationsDAO;

    public void saveStation(Station newStation){

        stationsDAO.save(newStation);
        log.info("Station saved");
    }


    public Station findById(int stationId) throws ItemNotFoundException{
        return stationsDAO.findById(stationId).orElseThrow(ItemNotFoundException::new);
    }

    public void findByIdAndUpdate(int stationId, Station updatedStation){
        Station found = this.findById(stationId);
        found.setBuilding(updatedStation.getBuilding());
        found.setDescription(updatedStation.getDescription());
        found.setStationType(updatedStation.getStationType());
        found.setMaxOccupants(updatedStation.getMaxOccupants());
    }

    public void findByIdAndDelete(int stationId){
        Station found = this.findById(stationId);
        stationsDAO.delete(found);
        log.info("Station deleted");
    }
}
