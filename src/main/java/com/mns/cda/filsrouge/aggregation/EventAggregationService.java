package com.mns.cda.filsrouge.aggregation;

import com.mns.cda.filsrouge.Iservice.IAthleteService;
import com.mns.cda.filsrouge.Iservice.IEventService;
import com.mns.cda.filsrouge.dto.AthleteDTO;
import com.mns.cda.filsrouge.dto.EventFull;
import com.mns.cda.filsrouge.dto.EventMedium;
import com.mns.cda.filsrouge.dto.TeamDTO;
import com.mns.cda.filsrouge.model.Team;
import com.mns.cda.filsrouge.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventAggregationService implements IEventAggregationService {


    private final IEventService eventService;

    private final TeamService teamService;

    private final IAthleteService athleteService;

    @Override
    public EventFull getEventFull(int idEvent) {

        EventMedium event = eventService.findEventMediumById(idEvent)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        // Récupérer les teams de l’évent
        List<Team> teams = teamService.findByEventId(idEvent);

        // Convertir chaque team en TeamDTO
        List<TeamDTO> teamDTOs = teams.stream()
                .map(t -> teamService.getTeamDTO(t.getIdTeam()))
                .toList();

        // Récupérer les athlètes solo
        List<AthleteDTO> Athletes = athleteService.findAthleteByEvent(idEvent);

        return new EventFull(event, teamDTOs, Athletes);
    }
}
