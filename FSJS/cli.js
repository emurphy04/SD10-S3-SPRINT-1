const fs = require('fs');
const path = './config.json';

const defaultConfig = {
  setting1: 'value1',
  setting2: 'value2'
};

function initialize() {
  if (const fs = require('fs');
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

initialize();
!fs.existsSync(path)) {
    fs.writeFileSync(path, JSON.stringify(defaultConfig, null, 2));
    console.log('Initialization complete.');
  } else {
    console.log('Configuration file already exists.');
  }
}

initialize();

