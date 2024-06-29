const fs = require('fs');
const path = './config.json';
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
}
