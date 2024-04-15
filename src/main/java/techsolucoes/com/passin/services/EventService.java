package techsolucoes.com.passin.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import techsolucoes.com.passin.domain.attendee.Attendee;
import techsolucoes.com.passin.domain.event.Event;
import techsolucoes.com.passin.domain.event.exceptions.EventNotFoundException;
import techsolucoes.com.passin.dto.event.EventIdDTO;
import techsolucoes.com.passin.dto.event.EventRequestDTO;
import techsolucoes.com.passin.dto.event.EventResponseDTO;
import techsolucoes.com.passin.repositories.AttendeeRepository;
import techsolucoes.com.passin.repositories.EventRepository;

import java.text.Normalizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;

    //metodo usado para criar a listação do evento e a quantidade de presenças
    public EventResponseDTO getEventDetail(String eventId) {
        Event event =
                this.eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event not found " + "with id " + eventId));
        List<Attendee> attendeeList = this.attendeeRepository.findByEventId(eventId);
        return new EventResponseDTO(event, attendeeList.size());
    }

    //metodo usado para criar o evento
    public EventIdDTO createEvent(EventRequestDTO eventDTO) {
        Event newEvent = new Event();
        newEvent.setTitle(eventDTO.title());
        newEvent.setDetails(eventDTO.details());
        newEvent.setMaximumAttendees(eventDTO.maximumAttendees());
        newEvent.setSlug(this.createSluc(eventDTO.title()));

        this.eventRepository.save(newEvent);
        return new EventIdDTO(newEvent.getId());
    }

    /*Este código define um método createSluc que recebe uma entrada de texto, normaliza-a, remove marcas diacríticas,
    caracteres que não são de palavras, caracteres que não são de espaço, substitui espaços por traços e converte-a em
    minúsculas para criar um ficheiro de texto. palavra, caracteres sem espaço, substitui espaços por traços e
    converte-o para minúsculas para criar um slug amigável para SEO.*/
    private String createSluc(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized.replaceAll("[\\p{InCOMBINING_DIACRITICAL_MARKS}]", "")
                .replaceAll("[^\\w\\s]", "")
                .replaceAll("\\s+", "-")
                .toLowerCase();
    }


}
