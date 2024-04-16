# Pass-In

Pass-In is a participant management application for in-person events. 
It allows organizers to register events, open public registration pages, and enables registered participants to issue credentials for event check-in on the day of the event.

## Utilized Technologies

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- HSQLDB
- Flyway (for database migration)
- Lombok
- Spring Dev Tools

## Functional Requirements

- Organizer can register a new event
- Organizer can view event data
- Organizer can view the list of participants
- Participant can register for an event
- Participant can view their registration badge
- Participant can check in to the event

## Business Rules

- Participant can only register for an event once
- Participant can only register for events with available slots
- Participant can only check in to an event once

## Non-Functional Requirements

- Event check-in is performed via a QR Code

## Running the Project

You can use any API management software such as INSOMNIA, APIDog, Postman, etc...
1. Clone the repository: `git clone https://github.com/seu-usuario/pass-in.git`
2. Navigate to the project directory: `cd pass-in`
3. Run the application: `./mvnw spring-boot:run`

Within the code, it is possible to view all consumption paths.

Make sure you have Java and Maven installed on your machine.

## Contributing

Contributions are welcome! Feel free to open issues to report bugs or suggest new features. Pull requests are also encouraged.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
