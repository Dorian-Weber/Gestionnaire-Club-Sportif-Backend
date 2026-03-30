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
    @JsonView(EventTypeView.class)
    protected Integer idEventType;

    @NotBlank
    @Column(unique = true)
    @JsonView({EventView.class,
            EventTypeView.class,
            SportView.class,
            DisciplineView.class})
    protected String EventTypeName;

    @OneToMany(mappedBy = "eventType")
    @JsonView(EventTypeView.class)
    protected List<Event> events;
}
