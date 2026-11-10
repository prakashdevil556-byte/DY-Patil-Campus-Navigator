# DY Patil Campus Navigator — Full Project

This project combines the supplied AI-generated frontend with a Java 17 / Spring Boot backend.

## Requirements
- JDK 17 (recommended; the project `pom.xml` targets Java 17)
- Apache Maven 3.8+
- Internet connection for CDN libraries and the official DYP campus photograph

## Run the complete website (recommended)
1. Extract this ZIP.
2. Open the `Campus_Navigation` folder in VS Code, then open its `backend` folder in the terminal.
3. Open Terminal → New Terminal.
4. Run `mvn -version` to verify Maven.
5. Run `mvn spring-boot:run`.
6. Wait for `Tomcat started on port 8080`.
7. Open http://localhost:8080 in Chrome.

The frontend is served by Spring Boot from `backend/src/main/resources/static/index.html`.

## API endpoints
- `GET http://localhost:8080/api/health`
- `GET http://localhost:8080/api/locations`
- `GET http://localhost:8080/api/route?from=dycoe&to=dypacad`

## Frontend development with Live Server (optional)
You may also open `frontend/index.html` using VS Code Live Server. It calls the backend at `http://localhost:8080/api` when Live Server is used.

## Important project-data note
The institution list and sample walking graph were retained/adapted from the supplied prototype. The campus photograph is served from the official DYP Akurdi website. The graph distances and map node positions are illustrative sample data, not verified measurements or a surveyed campus map. Before presenting this as turn-by-turn campus navigation, verify the building locations, pedestrian connections, distances, floor numbers and room details with the college.

## Image source
Official DYP Akurdi campus image: https://www.dypakurdipune.edu.in/bridge/images/home_images/campusmainimage_renamed_20240209235133.jpg
Official website: https://www.dypakurdipune.edu.in/


## Updated map and contrast improvements
- The home hero now uses a darker navy overlay and high-contrast white/gold text for readability.
- Campus Map Overview embeds Google Maps for Dr. D. Y. Patil Educational Complex, Akurdi, Pune. It requires an internet connection.
- The Dijkstra route distance remains based on the sample campus graph in the Java backend. Verify actual internal walking paths and distances before real-world use.
- After changing files, restart Spring Boot (`Ctrl+C`, then `mvn spring-boot:run`) and refresh `http://localhost:8080`.


## Logo and institution photographs
The navbar uses the supplied DYP logo (`backend/src/main/resources/static/images/dyp-logo.png`). Each institution card receives its own image URL from the institution image map in `CampusService.java`. These images are hosted on the public college/institution websites and require an internet connection. If a source website changes its image URL, update the corresponding `imageFor` case.
