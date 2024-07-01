# SD10-S3-SPRINT-1: Full Stack JavaScript CLI Project

This project is a Command Line Interface (CLI) for a web application that confirms new user accounts. It was developed as part of the Semester Three Full Stack JavaScript Sprint One at Keyin College.

## Team Members
- Ethan Murphy
- Brenda Armstrong

## Installation

1. Clone the repository:
git clone https://github.com/emurphy04/SD10-S3-SPRINT-1.git

2. Navigate to the project directory:
cd SD10-S3-SPRINT-1/FSJS

3. Install dependencies:
npm install node
npm install express

## Project Structure

This project uses two main JavaScript files:

- `cli.js`: Handles the command-line interface, parsing arguments, and directing commands.
- `myapp.js`: Contains the core application logic and functions.

When running commands, you'll typically interact with `cli.js`.

## Usage

The CLI provides various commands for system administration and user management. Here are the main features and how to test them:

### 1. Initialize Application
node cli.js init

### 2. View Configuration
node cli.js config view

### 3. Update Configuration
node cli.js config update <key> <value>

### 4. Reset Configuration
node cli.js config reset

### 5. Generate User Token
node cli.js token generate <username>

### 6. Add/Update User Record
node cli.js user update <username> --email <email> --phone <phone>

### 7. Search User Record
node cli.js user search <query>

### 8. Web Form for Token Generation
Start the Express server:
node server.js
Then open a web browser and navigate to `http://localhost:3000`

### 9. Application Logging
Logs are automatically generated and stored in the `logs` directory.

## Project Branches

The project is organized into several feature branches:

1. main
2. feature/1-init-app
3. feature/2-view-config
4. feature/3-status
5. feature/4-update-config
6. feature/5-reset-config
7. feature/6-generate-token
8. feature/7-update-user-records
9. feature/8-search-user-record
10. feature/9-web-form-token

To switch between branches and test specific features, use:
git checkout <branch-name>

For example:
git checkout feature/1-init-app

To view all branches in the repository:
git branch -a

## Dependencies

- Node.js
- Express.js

Make sure you have Node.js installed on your system before running the application.

## Development

When developing new features or fixing bugs, create a new branch from `main`:
git checkout -b feature/new-feature

After making changes, commit your work:
git add .
git commit -m "Description of changes"

Push your branch to the remote repository:
git push origin feature/new-feature

Then create a pull request on GitHub to merge your changes into the `main` branch.

## Testing

To run tests (if implemented):
npm test

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to the project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
