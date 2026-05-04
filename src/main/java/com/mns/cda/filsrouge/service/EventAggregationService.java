package com.mns.cda.filsrouge.service;

import com.mns.cda.filsrouge.Iservice.IAthleteService;
import com.mns.cda.filsrouge.Iservice.IEventService;
import com.mns.cda.filsrouge.Iservice.ITeamService;
import com.mns.cda.filsrouge.dto.AthleteDTO;
import com.mns.cda.filsrouge.dto.EventFull;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.dto.TeamDTO;
import com.mns.cda.filsrouge.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventAggregationService {

    @Autowired
    private IEventService eventService;

    @Autowired
    private TeamService teamService; // Implémentation, pas interface

    @Autowired
    private IAthleteService athleteService;

    public EventFull getEventFull(int idEvent) {

        EventMedium event = eventService.findEventMediumById(idEvent)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Récupérer les teams de l’évent
        List<Team> teams = teamService.findByEventId(idEvent);
        System.out.println("Teams trouvées : " + teams.size());

        // Convertir chaque team en TeamDTO
        List<TeamDTO> teamDTOs = teams.stream()
                .map(t -> teamService.getTeamDTO(t.getIdTeam()))
                .toList();
        System.out.println("TeamDTOs créés : " + teamDTOs.size());

        // Récupérer les athlètes solo
        List<AthleteDTO> Athletes = athleteService.findAthleteByEvent(idEvent);

        return new EventFull(event, teamDTOs, Athletes);
    }
}
