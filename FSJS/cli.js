const fs = require('fs');
const path = './config.json';
const usersPath = './users.json';
const crypto = require('crypto');

const defaultConfig = {
  setting1: 'value1',
  setting2: 'value2'
};

function initialize() {
  if (!fs.existsSync(path)) {
    fs.writeFileSync(path, JSON.stringify(defaultConfig, null, 2));
    console.log('Initialization complete.');
  } else {
    console.log('Configuration file already exists.');
  }
}

function status() {
  if (fs.existsSync(path)) {
    console.log('Configuration file is present.');
  } else {
    console.log('Configuration file is missing.');
  }
}

function viewConfig() {
  if (fs.existsSync(path)) {
    const config = fs.readFileSync(path, 'utf-8');
    console.log(JSON.parse(config));
  } else {
    console.log('Configuration file is missing.');
  }
}

function updateConfig(key, value) {
  if (fs.existsSync(path)) {
    const config = JSON.parse(fs.readFileSync(path, 'utf-8'));
    config[key] = value;
    fs.writeFileSync(path, JSON.stringify(config, null, 2));
    console.log(`Updated ${key} to ${value}.`);
  } else {
    console.log('Configuration file is missing.');
  }
}

function resetConfig() {
  fs.writeFileSync(path, JSON.stringify(defaultConfig, null, 2));
  console.log('Configuration reset to default.');
}

function generateToken(username) {
  const token = crypto.createHash('sha256').update(username).digest('hex');
  console.log(`Generated token for ${username}: ${token}`);
}

function updateUserRecord(username, email, phone) {
  let users = {};
  if (fs.existsSync(usersPath)) {
    users = JSON.parse(fs.readFileSync(usersPath, 'utf-8'));
  }
  if (!users[username]) {
    users[username] = {};
  }
  if (email) {
    users[username].email = email;
  }
  if (phone) {
    users[username].phone = phone;
  }
  fs.writeFileSync(usersPath, JSON.stringify(users, null, 2));
  console.log(`Updated user ${username}.`);
}

function searchUser(query) {
  if (fs.existsSync(usersPath)) {
    const users = JSON.parse(fs.readFileSync(usersPath, 'utf-8'));
    const results = Object.entries(users).filter(([username, details]) => {
      return username.includes(query) || (details.email && details.email.includes(query)) || (details.phone && details.phone.includes(query));
    });
    if (results.length > 0) {
      console.log('Search results:', results);
    } else {
      console.log('No matching user found.');
    }
  } else {
    console.log('User file is missing.');
  }
}

// Command-line interface handling
const command = process.argv[2];
if (command === 'init') {
  initialize();
} else if (command === 'status') {
  status();
} else if (command === 'view-config') {
  viewConfig();
} else if (command === 'update-config') {
  const key = process.argv[3];
  const value = process.argv[4];
  updateConfig(key, value);
} else if (command === 'reset-config') {
  resetConfig();
} else if (command === 'generate-token') {
  const username = process.argv[3];
  generateToken(username);
} else if (command === 'update-user') {
  const username = process.argv[3];
  const email = process.argv[4];
  const phone = process.argv[5];
  updateUserRecord(username, email, phone);
} else if (command === 'search-user') {
  const query = process.argv[3];
  searchUser(query);
}

