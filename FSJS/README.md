# SD10-S3-SPRINT-1: Full Stack JavaScript CLI Project

This project is a Command Line Interface (CLI) for a web application that confirms new user accounts. It was developed as part of the Semester Three Full Stack JavaScript Sprint One at Keyin College.

## Team Members
- Ethan Murphy
- Brenda Armstrong

## Installation

1. Clone the repository:
git clone https://github.com/emurphy04/SD10-S3-SPRINT-1.git

3. Navigate to the project directory:
cd SD10-S3-SPRINT-1/FSJS
  
4. Install dependencies:
- npm install node
- npm install express

## Usage

The CLI provides various commands for system administration and user management. Here are the main features and how to test them:

### 1. Initialize Application
node myapp.js init

### 2. View Configuration
node myapp.js config view

### 3. Update Configuration
node myapp.js config update <key> <value>

### 4. Reset Configuration
node myapp.js config reset

### 5. Generate User Token
node myapp.js token generate <username>

### 6. Add/Update User Record
node myapp.js user update <username> --email <email> --phone <phone>

### 7. Search User Record
node myapp.js user search <query>

### 8. Web Form for Token Generation
Start the Express server:
node server.js
Then open a web browser and navigate to `http://localhost:3000`

### 9. Application Logging
Logs are automatically generated and stored in the `logs` directory.

## Project Structure

The project is organized into several branches, each implementing specific features:

- `main`: The main branch containing the core application
- `init`: Initializes the application structure
- `config`: Handles configuration management
- `token`: Implements token generation
- `user`: Manages user records
- `web`: Provides web interface for token generation
- `logging`: Implements application logging
- `documentation`: Contains project documentation

To switch between branches for specific features, use:
git checkout <branch-name>

### The branches are:
- git checkout main
- git checkout feature/1-init-app
- git checkout feature/2-status
- git checkout feature/3-view-config
- git checkout feature/4-update-config
- git checkout feature/5-reset-config
- git checkout feature/6-generate-token
- git checkout feature/7-update-user-records
- git checkout feature/8-search-user-record
- git checkout feature/9-web-form-token

## Dependencies 

- Node.js
- Express.js

Make sure you have Node.js and Express.js installed on your system before running the application
