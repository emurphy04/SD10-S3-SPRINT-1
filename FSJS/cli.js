const fs = require('fs');
const path = './config.json';

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

// Command-line interface handling
const command = process.argv[2];
if (command === 'init') {
  initialize();
} else if (command === 'status') {
  status();
} else if (command === 'view-config') {
  viewConfig();
}
