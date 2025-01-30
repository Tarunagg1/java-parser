# XML Parser Application

A Spring Boot application that provides XML parsing capabilities with Excel export functionality.

## Description

This application allows users to:
- Upload XML files through a REST API
- Parse XML content
- Export data to Excel format
- Handle file processing operations efficiently

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Spring Boot 2.x

## Getting Started

### Installation

1. Clone the repository:
```bash
git clone [repository-url]
```

2. Navigate to the project directory:
```bash
cd xml-parser
```

3. Build the project:
```bash
mvn clean install
```

### Running the Application

You can run the application using Maven:

```bash
mvn spring-boot:run
```

Or run the JAR file directly after building:

```bash
java -jar target/xml-parser-[version].jar
```

The application will start on `http://localhost:8080` by default.

## API Endpoints

### File Upload
- **POST** `/api/upload` - Upload XML file for processing
- **GET** `/api/export` - Export processed data to Excel

## Configuration

Application configuration can be modified in `src/main/resources/application.properties`

## Built With

- Spring Boot
- Apache POI (for Excel operations)
- Java XML Processing APIs

## Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details