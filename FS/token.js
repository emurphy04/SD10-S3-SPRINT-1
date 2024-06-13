// Node.js common core global modules
const fs = require('fs');
const path = require('path');

const crc32 = require('crc/crc32');
const { format } = require('date-fns');

const myArgs = process.argv.slice(2);

function tokenList() {
  if(DEBUG) console.log('token.tokenCount()');
  fs.readFile(__dirname + '/json/tokens.json', 'utf-8', (error, data) => {
      if(error) throw error; 
      let tokens = JSON.parse(data);
      console.log('** User List **')
      tokens.forEach(obj => {
          console.log(' * ' + obj.username + ': ' + obj.token);
      });
   });
};

function searchUser(){
  // switch cases for if the user wants to search by username, email, or password - reworked from the config shower
  switch(myArgs[2]){
    case "u":
      fs.readFile(__dirname + "/json/tokens.json", (error, data) => {
        if(error) throw error;         
        let cfg = JSON.parse(data);
        for(let i = 0; i<cfg.length; i++){
          if(cfg[i].username == myArgs[3]){
            console.log(cfg[i])
          }
        }
      });
      break;
    case "e":
      fs.readFile(__dirname + "/json/tokens.json", (error, data) => {
        if(error) throw error;         
        let cfg = JSON.parse(data);
        for(let i = 0; i<cfg.length; i++){
          if(cfg[i].email == myArgs[3]){
            console.log(cfg[i])
          }
        }
      });
      break;
    case "p":
      fs.readFile(__dirname + "/json/tokens.json", (error, data) => {
        if(error) throw error;         
        let cfg = JSON.parse(data);
        for(let i = 0; i<cfg.length; i++){
          if(cfg[i].phone == myArgs[3]){
            console.log(cfg[i])
          }
        }
      });
      break;
  }
    
}

function updateUser(){
  if(DEBUG) console.log('token.updateUser()');
  if(DEBUG) console.log(myArgs);

  switch(myArgs[2]){
    // switch cases for if the user wants to update phone number or email - reworked from the config updater
    case 'e':
      fs.readFile(__dirname + "/json/tokens.json", (error, data) => {
        if(error) throw error;         
        if(DEBUG) console.log(JSON.parse(data));
        let cfg = JSON.parse(data);
        for(let i = 0; i<cfg.length; i++){
          if(cfg[i].username == myArgs[3]){
            cfg[i].email = myArgs[4]
            data = JSON.stringify(cfg)
            fs.writeFile(__dirname + '/json/tokens.json', data, (error) => {
              if (error) throw error;
              if(DEBUG) console.log('Config file successfully updated.');
            });
          }
        }
      });
      break;
    case 'p':
      fs.readFile(__dirname + "/json/tokens.json", (error, data) => {
        if(error) throw error;         
        if(DEBUG) console.log(JSON.parse(data));
        let cfg = JSON.parse(data);
        for(let i = 0; i<cfg.length; i++){
          if(cfg[i].username == myArgs[3]){
            cfg[i].phone = myArgs[4]
            data = JSON.stringify(cfg)
            fs.writeFile(__dirname + '/json/tokens.json', data, (error) => {
              if (error) throw error;
              if(DEBUG) console.log('Config file successfully updated.');
            });
          }
        }
      });
      break;
  }
    
}

function getToken(){
  //isnt working because window only works when in a browser... oops!
  window.open('http://127.0.0.1:5500/index.html', '_blank');
}

function newToken(username) {
  if(DEBUG) console.log('token.newToken()');
  let newToken = JSON.parse(`{
      "created": "1969-01-31 12:30:00",
      "username": "username",
      "email": "user@example.com",
      "phone": "5556597890",
      "token": "token",
      "expires": "1969-02-03 12:30:00",
      "confirmed": "tbd"
  }`);

  let now = new Date();
  let expires = addDays(now, 3);

  newToken.created = `${format(now, 'yyyy-MM-dd HH:mm:ss')}`;
  newToken.username = username;
  newToken.token = crc32(username).toString(16);
  newToken.expires = `${format(expires, 'yyyy-MM-dd HH:mm:ss')}`;

  fs.readFile(__dirname + '/json/tokens.json', 'utf-8', (error, data) => {
      if(error) throw error; 
      let tokens = JSON.parse(data);
      tokens.push(newToken);
      userTokens = JSON.stringify(tokens);
  
      fs.writeFile(__dirname + '/json/tokens.json', userTokens, (err) => {
          if (err) console.log(err);
          else { 
              console.log(`New token ${newToken.token} was created for ${username}.`);
          }
      })
      
  });
  return newToken.token;
}

function addDays(date, days) {
  var result = new Date(date);
  result.setDate(result.getDate() + days);
  return result;
}

function tokenApp() {
  if(DEBUG) console.log('tokenApp()');

  switch (myArgs[1]) {
  case '--count':
    if(DEBUG) console.log('--count');
 //     tokenCount();
      break;
  case '--list':
    if(DEBUG) console.log('--list');
      tokenList();
      break; 
  case '--upd':
    if(DEBUG) console.log('--upd');
      updateUser(myArgs[2], myArgs[3]);
      break; 
  case '--search':
    if(DEBUG) console.log('--search');
      searchUser();
      break; 
  case '--getToken':
    if(DEBUG) console.log('--getToken');
      getToken();
      break; 
  case '--new':
      if (myArgs.length < 3) {
          console.log('invalid syntax. node myapp token --new [username]')
      } else {
        if(DEBUG) console.log('--new');
        newToken(myArgs[2]);
      }
      break;
  case '--help':
  case '--h':
  default:
      fs.readFile(__dirname + "/usage.txt", (error, data) => {
          if(error) throw error;              
          console.log(data.toString());
      });
  }
}

module.exports = {
  tokenApp,
}