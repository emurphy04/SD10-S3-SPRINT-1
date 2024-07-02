const express = require('express');
const crypto = require('crypto');
const fs = require('fs');
const app = express();

app.use(express.urlencoded({ extended: true }));

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
  const token = crypto.createHash('sha256').update(username).digest('hex');
  res.send(`Your token: ${token}`);
});

app.listen(3000, () => {
  console.log('Server is running on http://localhost:3000');
});



