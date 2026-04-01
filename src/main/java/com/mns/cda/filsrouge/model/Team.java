package com.mns.cda.filsrouge.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.EventView;
import com.mns.cda.filsrouge.view.TeamView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(TeamView.class)
    protected Integer idTeam;

    @NotBlank
    @JsonView({TeamView.class, EventView.class})
    protected String teamName;

    @ManyToMany
    @JoinTable(name = "event_teams",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id"))
    @JsonView(TeamView.class)
    protected List<Event> events;
}
