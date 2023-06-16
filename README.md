# Hospital Management Web App

This web application is built using Java Spring Boot and provides functionalities for hospital management staff. It includes REST APIs for user authentication, patient admission, retrieving admitted patients, and patient discharge.

## Requirements

- Java Development Kit (JDK) 8 or above
- Maven
- MYSQL

## Getting Started

Follow the instructions below to set up and run the project on your local machine.

### 1. Clone the Repository
git clone https://github.com/adarshsinggh/hospital_management.git

### 2. Build the Project
cd hospital_management
mvn clean install

### 3. Configure the Database

- Create a MySQL database.
- Update the database connection settings in the `application.properties` file located in the `src/main/resources` directory according to your database name or put the name of the database as "hospital".

### 4. Run the Application
The application will start running on `http://localhost:8080`.

## API Documentation

The following APIs are available:

- **POST /rest/users/signup**: Signup for the hospital management system.
- **POST /rest/users/login**: Login to the application.
- **POST /rest/operations/admitPatient**: Admit a new patient with the specified details.
- **GET /rest/operations/getAdmittedPatients**: Retrieve all admitted patients.
- **PUT /rest/operations/dischargePatient/{id}: Discharge a patient with the given ID.
