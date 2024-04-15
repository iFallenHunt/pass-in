package techsolucoes.com.passin.dto.event;

import lombok.Getter;
import lombok.Setter;
import techsolucoes.com.passin.domain.event.Event;

@Getter

//Classe usada para retornar os dados do evento
public class EventResponseDTO {
    EventDetailDTO event;

    public EventResponseDTO(Event event, Integer numberOfAttendees) {
        this.event = new EventDetailDTO(event.getId(), event.getTitle(), event.getSlug(),
                 event.getMaximumAttendees(), numberOfAttendees);
    }
}
