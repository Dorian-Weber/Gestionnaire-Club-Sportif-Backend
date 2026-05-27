package com.mns.cda.filsrouge.model;


import com.fasterxml.jackson.annotation.JsonView;
import com.mns.cda.filsrouge.view.DisciplineView;
import com.mns.cda.filsrouge.view.EventView;
import com.mns.cda.filsrouge.view.SportView;
import com.mns.cda.filsrouge.view.EventTypeView;
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
public class EventType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idEventType;

    @NotBlank
    @Column(unique = true)
    protected String eventTypeName;

    @OneToMany(mappedBy = "eventType")
    protected List<Event> events;
}
