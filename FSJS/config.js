const fs = require('fs');
const path = './config/config.json';

const defaultConfig = {
  setting1: 'value1',
  setting2: 'value2'
};

function configApplication() {
  if (fs.existsSync(path)) {
    const config = fs.readFileSync(path, 'utf-8');
    console.log(JSON.parse(config));
  } else {
    fs.writeFileSync(path, JSON.stringify(defaultConfig, null, 2));
    console.log('Created default configuration.');
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

module.exports = { configApplication, updateConfig, resetConfig };
