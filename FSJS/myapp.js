global.DEBUG = true;

const fs = require('fs');
const express = require('express');
const myEventEmitter = require('./logEvents.js');

const { initializeApplication } = require('./init.js');
const { configApplication, updateConfig, resetConfig } = require('./config.js');
const { generateToken } = require('./token.js');
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

// CLI handling code
switch (myArgs[0]) {
  case 'init':
  case 'i':
    if (DEBUG) console.log(myArgs[0], '- init the app.');
    initializeApplication();
    break;
  case 'config':
  case 'c':
    if (DEBUG) console.log(myArgs[0], '- create the config folders and files.');
    configApplication();
    break;
  case 'update-config':
    if (DEBUG) console.log(myArgs[0], '- update config');
    updateConfig(myArgs[1], myArgs[2]);
    break;
  case 'reset-config':
    if (DEBUG) console.log(myArgs[0], '- reset config');
    resetConfig();
    break;
  case 'token':
  case 't':
    if (DEBUG) console.log(myArgs[0], '- manage the tokens');
    generateToken(myArgs[1]);
    break;
  case 'update-user':
    if (DEBUG) console.log(myArgs[0], '- update user records');
    updateUserRecord(myArgs[1], myArgs[2], myArgs[3]);
    break;
  case 'search-user':
    if (DEBUG) console.log(myArgs[0], '- search user records');
    searchUser(myArgs[1]);
    break;
  case 'server':
    if (DEBUG) console.log(myArgs[0], '- start the server');
    startServer();
    break;
  case '--help':
  case '--h':
  default:
    if (DEBUG) console.log(myArgs[0], '- display help');
    myEventEmitter.emit('event', process.argv, 'WARNING', 'Unrecognized CLI item requested.');
    fs.readFile(__dirname + "/usage.txt", (error, data) => {
      if (error) throw error;
      console.log(data.toString());
    });
}
