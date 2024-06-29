global.DEBUG = true;

const fs = require('fs');
const express = require('express');
const myEventEmitter = require('./logEvents.js');

const { initializeApplication } = require('./init.js');
const { configApplication, updateConfig, resetConfig } = require('./config.js');
const { generateToken, listTokens, countTokens } = require('./token.js');
const { updateUserRecord, searchUser } = require('./users.js');

const myArgs = process.argv.slice(2);

if (DEBUG) if (myArgs.length >= 1) console.log('myArgs: ', myArgs);

function startServer() {
  const app = express();
  app.use(express.urlencoded({ extended: true }));

  // Route to serve the form and handle token generation
  app.get('/', (req, res) => {
    res.send(`
      <form method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
        <button type="submit">Submit</button>
      </form>
    `);
  });

  app.post('/', (req, res) => {
    const username = req.body.username;
    if (username) {
      const token = generateToken(username);
      res.send(`Your token: ${token}`);
    } else {
      res.send('Username is required.');
    }
  });

  app.listen(3000, () => {
    console.log('Server is running on http://localhost:3000');
  });
}

function displayHelp() {
  console.log(`
    myapp <command> <option>

    Usage:

    myapp --help          displays help

    myapp init            initialize the app
    myapp init --mk       create all the app folders
    myapp init --cat      create all the app files
    myapp init --all      create all the folders and files

    myapp config          manage configuration
    myapp config --show   show the contents of the config file
    myapp config --reset  reset to default the config file
    myapp config --set <key> <value>    set a specific attribute of the config file

    myapp token           manage user tokens
    myapp token --list    list all the tokens
    myapp token --count   provide a count of all the tokens
    myapp token --new <username>     generate a new token for the user

    myapp update-user <username> <email> <phone>   update user records
    myapp search-user <query>   search user records by username, email, or phone number

    myapp server          start the web server for token generation
  `);
}

// CLI handling code
switch (myArgs[0]) {
  case 'init':
  case 'i':
    if (DEBUG) console.log(myArgs[0], '- init the app.');
    initializeApplication();
    break;
  case 'config':
  case 'c':
    if (DEBUG) console.log(myArgs[0], '- manage configuration');
    if (myArgs.length < 2) {
      displayHelp();
    } else if (myArgs[1] === '--show') {
      configApplication();
    } else if (myArgs[1] === '--set') {
      if (myArgs.length < 4) {
        console.log('Usage: myapp config --set <key> <value>');
      } else {
        updateConfig(myArgs[2], myArgs[3]);
      }
    } else if (myArgs[1] === '--reset') {
      resetConfig();
    } else {
      displayHelp();
    }
    break;
  case 'token':
  case 't':
    if (DEBUG) console.log(myArgs[0], '- manage the tokens');
    if (myArgs.length < 2) {
      displayHelp();
    } else if (myArgs[1] === '--new') {
      if (myArgs.length < 3) {
        console.log('Usage: myapp token --new <username>');
      } else {
        const token = generateToken(myArgs[2]);
        console.log(`Generated token for ${myArgs[2]}: ${token}`);
      }
    } else if (myArgs[1] === '--list') {
      listTokens();
    } else if (myArgs[1] === '--count') {
      countTokens();
    } else {
      displayHelp();
    }
    break;
  case 'update-user':
    if (DEBUG) console.log(myArgs[0], '- update user records');
    if (myArgs.length < 4) {
      console.log('Usage: myapp update-user <username> <email> <phone>');
    } else {
      updateUserRecord(myArgs[1], myArgs[2], myArgs[3]);
    }
    break;
  case 'search-user':
    if (DEBUG) console.log(myArgs[0], '- search user records');
    if (myArgs.length < 2) {
      console.log('Usage: myapp search-user <query>');
    } else {
      searchUser(myArgs[1]);
    }
    break;
  case 'server':
    if (DEBUG) console.log(myArgs[0], '- start the server');
    startServer();
    break;
  case '--help':
  case '--h':
  default:
    displayHelp();
    myEventEmitter.emit('event', process.argv, 'WARNING', 'Unrecognized CLI item requested.');
}

