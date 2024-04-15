package techsolucoes.com.passin.dto.event;

import techsolucoes.com.passin.domain.event.Event;

public class EventResponseDTO {
    EventDetailDTO event;

    public EventResponseDTO(Event event, Integer numberOfAttendees) {
        this.event = new EventDetailDTO(event.getId(), event.getTitle(), event.getSlug(),
                 event.getMaximumAttendees(), numberOfAttendees);
    }
}
