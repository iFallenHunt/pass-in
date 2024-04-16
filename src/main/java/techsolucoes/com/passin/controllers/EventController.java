package techsolucoes.com.passin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import techsolucoes.com.passin.dto.attendee.AttendeeIdDTO;
import techsolucoes.com.passin.dto.attendee.AttendeeRequestDTO;
import techsolucoes.com.passin.dto.attendee.AttendeesListResponseDTO;
import techsolucoes.com.passin.dto.event.EventIdDTO;
import techsolucoes.com.passin.dto.event.EventRequestDTO;
import techsolucoes.com.passin.dto.event.EventResponseDTO;
import techsolucoes.com.passin.services.AttendeeService;
import techsolucoes.com.passin.services.EventService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final AttendeeService attendeeService;

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDTO> getEvent(@PathVariable String id) {
        EventResponseDTO event = this.eventService.getEventDetail(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping
    public ResponseEntity<EventIdDTO> createEvent(@RequestBody EventRequestDTO body, UriComponentsBuilder uriComponentsBuilder) {
        EventIdDTO eventIdDTO = this.eventService.createEvent(body);

        var uri = uriComponentsBuilder.path("/events/{id}").buildAndExpand(eventIdDTO.eventId()).toUri();

        return ResponseEntity.created(uri).body(eventIdDTO);
    }

    @PostMapping("/{eventId}/attendees")
    public ResponseEntity<AttendeeIdDTO> registerParticipant(@PathVariable String eventId,
                                                          @RequestBody AttendeeRequestDTO body,
                                          UriComponentsBuilder uriComponentsBuilder) {
        AttendeeIdDTO attendeeIdDTO = this.eventService.registerAttendeeOnEvent(eventId, body);
//no codigo dela ela errou e colocou /attendees/{attendId}" se der erro voltar nessa parte
        var uri = uriComponentsBuilder.path("/attendees/{attendeeId}").buildAndExpand(attendeeIdDTO.attendeeId()).toUri();

        return ResponseEntity.created(uri).body(attendeeIdDTO);
    }

    @GetMapping("/attendees/{id}")
    public ResponseEntity<AttendeesListResponseDTO> getEventAttendees(@PathVariable String id) {
        AttendeesListResponseDTO attendeesListResponse = this.attendeeService.getEventsAttendee(id);
        return ResponseEntity.ok(attendeesListResponse);
    }
}
