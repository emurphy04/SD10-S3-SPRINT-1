global.DEBUG = true;

const fs = require('fs');
const express = require('express');
const crypto = require('crypto');
const myEventEmitter = require('./logEvents.js');

const { initializeApplication } = require('./init.js');
const { configApplication } = require('./config.js');
const { tokenApplication } = require('./token.js');

const myArgs = process.argv.slice(2);

if (DEBUG) if (myArgs.length >= 1) console.log('myArgs: ', myArgs);

// Initialize Express app
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
    const token = crypto.createHash('sha256').update(username).digest('hex');
    res.send(`Your token: ${token}`);
  } else {
    res.send('Username is required.');
  }
});

app.listen(3000, () => {
  console.log('Server is running on http://localhost:3000');
});

// Existing CLI handling code
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
  case 'token':
  case 't':
    if (DEBUG) console.log(myArgs[0], '- manage the tokens');
    tokenApplication();
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




