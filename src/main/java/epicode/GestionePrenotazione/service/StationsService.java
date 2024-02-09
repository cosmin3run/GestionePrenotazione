package epicode.GestionePrenotazione.service;

import epicode.GestionePrenotazione.DAO.BuildingsDAO;
import epicode.GestionePrenotazione.DAO.ReservationsDAO;
import epicode.GestionePrenotazione.DAO.StationsDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StationsService {
    @Autowired
    private StationsDAO stationsDAO;


}
