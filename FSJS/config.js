const { add } = require('date-fns');
const fs = require('fs');
const path = './json/config.json';

const defaultConfig = {
  name: "AppConfigCLI",
  version: "1.0.0",
  description: "The Command Line Interface (CLI) for the MyApp.",
  main: "myapp.js",
  superuser: "admin",
  database: "exampledb"
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

function addConfig(name, value) {
  let users = {};
  if (fs.existsSync(path)) {
    config = JSON.parse(fs.readFileSync(path, 'utf-8'));
    config[name] = value
  }
  fs.writeFileSync(path, JSON.stringify(config, null, 2));
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

module.exports = { configApplication, updateConfig, resetConfig, addConfig };
