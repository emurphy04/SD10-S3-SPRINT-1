const fs = require('fs');
const usersPath = './users.json';

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

module.exports = { updateUserRecord, searchUser };
