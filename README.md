# Production Management Software Solution

## Overview
This project focuses on developing a software solution for managing production planning, control, and management in an industrial facility. The solution addresses critical challenges in industrial management, including aspects of Product Engineering, Production Planning, and Production Control.

## Problem Statement
The primary goal is to create a software application that effectively tackles the complexities of planning, managing, and controlling production processes. This includes:

- **Product Engineering**: Managing the structure of the facility, including products, machines, operations, and layouts.
- **Production Planning**: Processing customer orders and generating production orders.
- **Production Control**: Supervising machine operations and scheduling preventive maintenance.

## Key Features
- **User-friendly Interface**: Intuitive design for easy navigation.
- **Production Planning Tools**: Efficient order processing and production order generation.
- **Real-time Monitoring**: Oversight of machine operations for enhanced control.
- **Maintenance Scheduling**: Preventive maintenance management to minimize downtime.

## Architecture
The system architecture consists of several interconnected components, including the use of Java for backend logic, C & Assembly for machine communication, and Oracle PL/SQL for database operations. The system uses CSV files for importing/exporting data and ODBC for database connectivity.

## Architecture Diagram
(Insert your architecture diagram here)

## Modules
- **Java-based applications** for managing production and plant operations.
- **Machine supervision** using Raspberry Pi and text file communication.
- **Oracle PL/SQL** for managing databases and plant-floor operations.

## Technologies Used
- **Java**: Core business logic.
- **C & Assembly**: Communicating with machines and sensors via Raspberry Pi.
- **Oracle PL/SQL**: Database management for production data.
- **CSV**: For data import/export between systems.
- **ODBC**: For database connectivity.

## Directory Structure


## Modules Description
- **Machine Supervisor**: Supervise and monitor machine operations using sensors and actuators via Raspberry Pi.
- **Plant Floor Manager**: Manages the production tasks and machine workflows on the shop floor.
- **Production Plan Simulator**: Simulates production scenarios for planning and resource optimization.
- **Project Manager**: Manages project-related tasks, schedules, and overall production workflow.

## Installation
### Prerequisites
- Java (version 23)
- Oracle Database
- Raspberry PI (for machine control)
- ODBC Drivers
### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/1150475/SEM3_PI_24-25_G324.git
2. Open the project in IntelliJ IDEA or any compatible IDE.
3. Run the Production Plan Simulator from `prodPlanSimulator/src/Main.java.`
4. Set up the Oracle Database using the SQL schema provided in the documentation folder.
5. Use ODBC drivers to connect the Plant Floor Manager to the database for data processing.
6. Deploy the Machine Supervisor module on Raspberry Pi for real-time machine monitoring.
